package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.Emballage;
import com.skmServices.skmServices.service.EmballageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/emballage")
public class EmballageController {
    @Autowired
    private EmballageService emballageService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Emballage> findAll(){
        return emballageService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Emballage findById(@PathVariable Integer id){
        return emballageService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Emballage create(@RequestBody Emballage emballage ){
        return emballageService.create(emballage );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Emballage update(@RequestBody Emballage emballage, @PathVariable Integer id){
        if(!id.equals(emballage.getId_emballage())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return emballageService.update(emballage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Emballage delete(@PathVariable Integer id){
        return emballageService.delete(id);
    }
}
