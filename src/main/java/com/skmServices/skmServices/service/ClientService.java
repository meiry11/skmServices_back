package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Client;
import com.skmServices.skmServices.entity.Role;
import com.skmServices.skmServices.repository.IRoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.skmServices.skmServices.repository.IClientRepo;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientService implements UserDetailsService {
    @Autowired
    private IClientRepo clientRepo;
    @Autowired
    private IRoleRepo roleRepo;

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findById(Integer id){
        Optional<Client> optClient = clientRepo.findById(id);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Client findByEmail(String email){
        Optional<Client> optClient = clientRepo.findByUsername(email);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Optional<Client> login(String email){
        return clientRepo.findByUsername(email);
    }

    public void addRoleToClient(String username,String roleName){
        log.info("ajout de role pour utilisateur"+username+roleName);
        Client client = clientRepo.findByUsername(username).get();
        Role role = roleRepo.findByNom(roleName);
        List<Role> listrole = client.getRole();
        if (!listrole.contains(role)){
            listrole.add(role);
            client.setRole(listrole);
            update(client);
        }


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepo.findByUsername(username).get();
        if(client == null){
            log.error("Client introuvable dans la BDD");
            throw new UsernameNotFoundException("Client introuvable dans la BDD");
        }else {
            log.info("Client existe !!");

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        client.getRole().forEach(role ->
            {authorities.add(new SimpleGrantedAuthority(role.getNom())
            );});
        return new User(client.getUsername(),client.getPassword(),authorities);
    }
    public Client create(Client Client ){
        log.info("ajout d un utilisatur");
        return clientRepo.save(Client );
    }

    public Client update(Client Client){
        if(clientRepo.existsById(Client.getId()))
            return clientRepo.save(Client);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Client delete(Integer id){
        if (! clientRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Client optClient = findById(id);

        clientRepo.delete(optClient);
        return optClient;
    }


}
