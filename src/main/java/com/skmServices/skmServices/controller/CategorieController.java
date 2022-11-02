package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Catalogueproduit;
import com.skmServices.skmServices.entity.Categorie;
import com.skmServices.skmServices.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Categorie> findAll(){
        return categorieService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Categorie findById(@PathVariable Integer id){
        return categorieService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Categorie create(@RequestBody Categorie categorie ){
        return categorieService.create(categorie );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Categorie update(@RequestBody Categorie categorie, @PathVariable Integer id){
        if(!id.equals(categorie.getId_categorie())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return categorieService.update(categorie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Categorie delete(@PathVariable Integer id){
        return categorieService.delete(id);
    }
}
