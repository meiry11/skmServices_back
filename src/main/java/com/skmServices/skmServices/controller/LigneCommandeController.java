package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.IdLignecommande;
import com.skmServices.skmServices.entity.Lignecommande;
import com.skmServices.skmServices.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lignecommande")
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Lignecommande> findAll(){
        return ligneCommandeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Lignecommande findById(@PathVariable IdLignecommande id){
        return ligneCommandeService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Lignecommande create(@RequestBody Lignecommande lignecommande ){
        return ligneCommandeService.create(lignecommande );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Lignecommande update(@RequestBody Lignecommande lignecommande, @PathVariable Integer id){
        if(!id.equals(lignecommande.getId_lignecommande())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return ligneCommandeService.update(lignecommande);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Lignecommande delete(@PathVariable IdLignecommande id){
        return ligneCommandeService.delete(id);
    }
}
