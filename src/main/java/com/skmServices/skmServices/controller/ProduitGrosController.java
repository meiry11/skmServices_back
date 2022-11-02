package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.ProduitGros;
import com.skmServices.skmServices.service.ProduitGrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produitgros")
public class ProduitGrosController {
    @Autowired
    private ProduitGrosService produitGrosService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProduitGros> findAll(){
        return produitGrosService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProduitGros findById(@PathVariable Integer id){
        return produitGrosService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public ProduitGros create(@RequestBody ProduitGros produitGros ){
        return produitGrosService.create(produitGros );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ProduitGros update(@RequestBody ProduitGros produitGros, @PathVariable Integer id){
        if(!id.equals(produitGros.getId_produitGros())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return produitGrosService.update(produitGros);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ProduitGros delete(@PathVariable Integer id){
        return produitGrosService.delete(id);
    }
}
