package com.skmServices.skmServices.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skmServices.skmServices.entity.Client;
import com.skmServices.skmServices.entity.Role;
import com.skmServices.skmServices.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {
    public static final String DEFAULT_ROLE = "ROLE_USER";
    public static final String[] ADMIN_ACCESS = {"ROLE_ADMIN","ROLE_MODERATOR"};
    public static final String[] MODERATOR_ACCESS = {"ROLE_MODERATOR"};

    @Autowired
    private ClientService clientService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/access/{username}/{roleName}")
    public void addRoleToClient(@PathVariable String username,@PathVariable String roleName){
        clientService.addRoleToClient(username,roleName);
        log.info( "HI"+username+"new role assign  "+roleName);

    }
    @GetMapping("/access/tokenRefresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("Secret".getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                Client client = clientService.findByEmail(username);

                String jwtAccessToken = JWT.create()
                        .withSubject(client.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",client.getRole().stream().map(Role::getNom).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token",jwtAccessToken);
                tokens.put("refresh_token",refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);


            } catch (Exception exception) {
                log.info("Erreur de connexion {}",exception.getMessage());
                response.setHeader("erreur",exception.getMessage());
                //response.sendError(FORBIDDEN.value());
                Map<String,String> erreur = new HashMap<>();
                erreur.put("error_message",exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),erreur);
            }
        }else {
            throw new RuntimeException("Refresh Token is missing");
        }

    }
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Client findById(@PathVariable Integer id){
        return clientService.findById(id);
    }

    @GetMapping("/{email}")
    @ResponseStatus(code = HttpStatus.OK)
    public Client findByEmail(@PathVariable String email){
        return clientService.findByEmail(email);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Client> login(@PathVariable String username){
        Optional<Client> optionalClient = clientService.login(username);
        return optionalClient.map( ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Client create(@RequestBody Client client ){
        client.setRoles(DEFAULT_ROLE);
        String passencrypte = passwordEncoder.encode(client.getPassword());
        client.setPassword(passencrypte);
        clientService.create(client);
        return clientService.create(client );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Client update(@RequestBody Client client, @PathVariable Integer id){
        if(!id.equals(client.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Client delete(@PathVariable Integer id){
        return clientService.delete(id);
    }
}
