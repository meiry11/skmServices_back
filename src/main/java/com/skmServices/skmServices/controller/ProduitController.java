package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.Produit;
import com.skmServices.skmServices.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Produit> findAll(){
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Produit findById(@PathVariable Integer id){
        return produitService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Produit create(@RequestBody Produit produit ){
        return produitService.create(produit );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Produit update(@RequestBody Produit produit, @PathVariable Integer id){
        if(!id.equals(produit.getId_produit())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return produitService.update(produit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Produit delete(@PathVariable Integer id){
        return produitService.delete(id);
    }
}
