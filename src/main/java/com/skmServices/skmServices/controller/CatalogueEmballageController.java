package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Adresse;
import com.skmServices.skmServices.entity.Catalogueemballage;
import com.skmServices.skmServices.service.CatalogueEmballageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/catalogueemballage")
public class CatalogueEmballageController {
    @Autowired
    private CatalogueEmballageService catalogueEmballageService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Catalogueemballage> findAll(){
        return catalogueEmballageService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Catalogueemballage findById(@PathVariable Integer id){
        return catalogueEmballageService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Catalogueemballage create(@RequestBody Catalogueemballage catalogueemballage ){
        return catalogueEmballageService.create(catalogueemballage );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Catalogueemballage update(@RequestBody Catalogueemballage catalogueemballage, @PathVariable Integer id){
        if(!id.equals(catalogueemballage.getId_catalogueemballage())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return catalogueEmballageService.update(catalogueemballage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Catalogueemballage delete(@PathVariable Integer id){
        return catalogueEmballageService.delete(id);
    }
}
