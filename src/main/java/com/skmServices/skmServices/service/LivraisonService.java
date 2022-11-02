package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.entity.IdLivraison;
import com.skmServices.skmServices.entity.Livraison;
import com.skmServices.skmServices.repository.ILivraisonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {
    @Autowired
    private ILivraisonRepo livraisonRepo;

    public List<Livraison> findAll(){
        return livraisonRepo.findAll();
    }

    public Livraison findById(IdLivraison id){
        Optional<Livraison> optionalLivraison = livraisonRepo.findById(id);
        if(optionalLivraison.isPresent())
            return optionalLivraison.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Livraison create(Livraison livraison ){
        return livraisonRepo.save(livraison );
    }

    public Livraison update(Livraison livraison){
        if(livraisonRepo.existsById(livraison.getId_livraison()))
            return livraisonRepo.save(livraison);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Livraison delete(IdLivraison id){
        if (! livraisonRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Livraison optlivraison = findById(id);

        livraisonRepo.delete(optlivraison);
        return optlivraison;
    }
}
