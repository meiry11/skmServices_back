package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Adresse;
import com.skmServices.skmServices.entity.Catalogueproduit;
import com.skmServices.skmServices.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueProduitService {
    @Autowired
    private ICatalogueProduitRepo catalogueProduitRepo;

    public List<Catalogueproduit> findAll(){
        return catalogueProduitRepo.findAll();
    }

    public Catalogueproduit findById(Integer id){
        Optional<Catalogueproduit> optcatalogue = catalogueProduitRepo.findById(id);
        if(optcatalogue.isPresent())
            return optcatalogue.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Catalogueproduit create(Catalogueproduit catalogueproduit ){
        return catalogueProduitRepo.save(catalogueproduit );
    }

    public Catalogueproduit update(Catalogueproduit catalogueproduit){
        if(catalogueProduitRepo.existsById(catalogueproduit.getId_catlogueproduit()))
            return catalogueProduitRepo.save(catalogueproduit);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Catalogueproduit delete(Integer id){
        if (! catalogueProduitRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Catalogueproduit catalogueproduit = findById(id);

        catalogueProduitRepo.delete(catalogueproduit);
        return catalogueproduit;
    }
}
