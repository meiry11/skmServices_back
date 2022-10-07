package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Categorie;
import com.skmServices.skmServices.entity.Client;
import com.skmServices.skmServices.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

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

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Client create(@RequestBody Client client ){
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
