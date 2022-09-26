package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Adresse;
import com.skmServices.skmServices.entity.Catalogueemballage;
import com.skmServices.skmServices.repository.ICatalogueEmballageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueEmballageService {
    @Autowired
    private ICatalogueEmballageRepo catalogueEmballageRepo;

    public List<Catalogueemballage> findAll(){
        return catalogueEmballageRepo.findAll();
    }

    public Catalogueemballage findById(Integer id){
        Optional<Catalogueemballage> optClient = catalogueEmballageRepo.findById(id);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Catalogueemballage create(Catalogueemballage Catalogueemballage ){
        return catalogueEmballageRepo.save(Catalogueemballage );
    }

    public Catalogueemballage update(Catalogueemballage Catalogueemballage){
        if(catalogueEmballageRepo.existsById(Catalogueemballage.getId_catalogueemballage()))
            return catalogueEmballageRepo.save(Catalogueemballage);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Catalogueemballage delete(Integer id){
        if (! catalogueEmballageRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Catalogueemballage optCatalogueemballage = findById(id);

        catalogueEmballageRepo.delete(optCatalogueemballage);
        return optCatalogueemballage;
    }
}
