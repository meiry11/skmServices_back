package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Catalogueproduit;
import com.skmServices.skmServices.entity.Categorie;
import com.skmServices.skmServices.repository.ICategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private ICategorieRepo categorieRepo;

    public List<Categorie> findAll(){
        return categorieRepo.findAll();
    }

    public Categorie findById(Integer id){
        Optional<Categorie> optionalCategorie = categorieRepo.findById(id);
        if(optionalCategorie.isPresent())
            return optionalCategorie.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Categorie create(Categorie categorie ){
        return categorieRepo.save(categorie );
    }

    public Categorie update(Categorie categorie){
        if(categorieRepo.existsById(categorie.getId_categorie()))
            return categorieRepo.save(categorie);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Categorie delete(Integer id){
        if (! categorieRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Categorie categorie = findById(id);

        categorieRepo.delete(categorie);
        return categorie;
    }
}
