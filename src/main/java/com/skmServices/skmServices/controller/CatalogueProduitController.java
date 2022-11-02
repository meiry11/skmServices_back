package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Catalogueemballage;
import com.skmServices.skmServices.entity.Catalogueproduit;
import com.skmServices.skmServices.service.CatalogueProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/catalogueproduit")
public class CatalogueProduitController {
    @Autowired
    private CatalogueProduitService catalogueProduitService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Catalogueproduit> findAll(){
        return catalogueProduitService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Catalogueproduit findById(@PathVariable Integer id){
        return catalogueProduitService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Catalogueproduit create(@RequestBody Catalogueproduit catalogueproduit ){
        return catalogueProduitService.create(catalogueproduit );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Catalogueproduit update(@RequestBody Catalogueproduit catalogueproduit, @PathVariable Integer id){
        if(!id.equals(catalogueproduit.getId_catlogueproduit())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return catalogueProduitService.update(catalogueproduit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Catalogueproduit delete(@PathVariable Integer id){
        return catalogueProduitService.delete(id);
    }
}
