package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.IdLignecommande;
import com.skmServices.skmServices.entity.IdLivraison;
import com.skmServices.skmServices.entity.Lignecommande;
import com.skmServices.skmServices.entity.Livraison;
import com.skmServices.skmServices.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/livraison")
public class LivraisonController {
    @Autowired
    private LivraisonService livraisonService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Livraison> findAll(){
        return livraisonService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Livraison findById(@PathVariable IdLivraison id){
        return livraisonService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Livraison create(@RequestBody Livraison livraison ){
        return livraisonService.create(livraison );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Livraison update(@RequestBody Livraison livraison, @PathVariable IdLivraison id){
        if(!id.equals(livraison.getId_livraison())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return livraisonService.update(livraison);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Livraison delete(@PathVariable IdLivraison id){
        return livraisonService.delete(id);
    }
}
