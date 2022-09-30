package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.entity.Produit;
import com.skmServices.skmServices.repository.IProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private IProduitRepo produitRepo;

    public List<Produit> findAll(){
        return produitRepo.findAll();
    }

    public Produit findById(Integer id){
        Optional<Produit> optionalProduit = produitRepo.findById(id);
        if(optionalProduit.isPresent())
            return optionalProduit.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Produit create(Produit produit ){
        return produitRepo.save(produit );
    }

    public Produit update(Produit produit){
        if(produitRepo.existsById(produit.getId_produit()))
            return produitRepo.save(produit);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Produit delete(Integer id){
        if (! produitRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Produit optproduit = findById(id);

        produitRepo.delete(optproduit);
        return optproduit;
    }
}
