package com.skmServices.skmServices.controller;


import com.skmServices.skmServices.entity.Adresse;
import com.skmServices.skmServices.repository.IAdresseRepo;
import com.skmServices.skmServices.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adresse")
public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findAll(){
        return adresseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adresse findById(@PathVariable Integer id){
        return adresseService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Adresse create(@RequestBody Adresse adresse ){
        return adresseService.create(adresse );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse update(@RequestBody Adresse adresse, @PathVariable Integer id){
        if(!id.equals(adresse.getId_adresse())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return adresseService.update(adresse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse delete(@PathVariable Integer id){
        return adresseService.delete(id);
    }
}
