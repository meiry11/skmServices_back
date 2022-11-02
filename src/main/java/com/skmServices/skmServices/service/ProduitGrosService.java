package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.entity.Produit;
import com.skmServices.skmServices.entity.ProduitGros;
import com.skmServices.skmServices.repository.IProduitGrosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitGrosService {
    @Autowired
    private IProduitGrosRepo produitGrosRepo;

    public List<ProduitGros> findAll(){
        return produitGrosRepo.findAll();
    }

    public ProduitGros findById(Integer id){
        Optional<ProduitGros> optionalProduitGros = produitGrosRepo.findById(id);
        if(optionalProduitGros.isPresent())
            return optionalProduitGros.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public ProduitGros create(ProduitGros produitGros ){
        return produitGrosRepo.save(produitGros );
    }

    public ProduitGros update(ProduitGros produitGros){
        if(produitGrosRepo.existsById(produitGros.getId_produitGros()))
            return produitGrosRepo.save(produitGros);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public ProduitGros delete(Integer id){
        if (! produitGrosRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        ProduitGros optproduitgros = findById(id);

        produitGrosRepo.delete(optproduitgros);
        return optproduitgros;
    }
}
