package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Facture> findAll(){
        return factureService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Facture findById(@PathVariable Integer id){
        return factureService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Facture create(@RequestBody Facture facture ){
        return factureService.create(facture );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Facture update(@RequestBody Facture facture, @PathVariable Integer id){
        if(!id.equals(facture.getId_facture())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return factureService.update(facture);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Facture delete(@PathVariable Integer id){
        return factureService.delete(id);
    }
}
