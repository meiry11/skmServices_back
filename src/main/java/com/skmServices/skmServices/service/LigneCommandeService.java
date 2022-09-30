package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.entity.IdLignecommande;
import com.skmServices.skmServices.entity.Lignecommande;
import com.skmServices.skmServices.repository.ILigneCommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {
    @Autowired
    private ILigneCommandeRepo ligneCommandeRepo;

    public List<Lignecommande> findAll(){
        return ligneCommandeRepo.findAll();
    }

    public Lignecommande findById(IdLignecommande id){
        Optional<Lignecommande> optionalLignecommande = ligneCommandeRepo.findById(id);
        if(optionalLignecommande.isPresent())
            return optionalLignecommande.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Lignecommande create(Lignecommande lignecommande ){
        return ligneCommandeRepo.save(lignecommande );
    }

    public Lignecommande update(Lignecommande lignecommande){
        if(ligneCommandeRepo.existsById(lignecommande.getId_lignecommande()))
            return ligneCommandeRepo.save(lignecommande);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Lignecommande delete(IdLignecommande id){
        if (! ligneCommandeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Lignecommande optLignecommande = findById(id);

        ligneCommandeRepo.delete(optLignecommande);
        return optLignecommande;
    }
}
