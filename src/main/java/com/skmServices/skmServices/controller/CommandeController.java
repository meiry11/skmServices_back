package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Client;
import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Commande> findAll(){
        return commandeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Commande findById(@PathVariable Integer id){
        return commandeService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Commande create(@RequestBody Commande commande ){
        return commandeService.create(commande );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Commande update(@RequestBody Commande commande, @PathVariable Integer id){
        if(!id.equals(commande.getId_commande())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return commandeService.update(commande);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Commande delete(@PathVariable Integer id){
        return commandeService.delete(id);
    }
}
