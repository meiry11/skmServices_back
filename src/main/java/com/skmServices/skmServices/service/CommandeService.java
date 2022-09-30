package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Client;
import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.repository.ICommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private ICommandeRepo commandeRepo;

    public List<Commande> findAll(){
        return commandeRepo.findAll();
    }

    public Commande findById(Integer id){
        Optional<Commande> optionalCommande = commandeRepo.findById(id);
        if(optionalCommande.isPresent())
            return optionalCommande.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Commande create(Commande commande ){
        return commandeRepo.save(commande );
    }

    public Commande update(Commande commande){
        if(commandeRepo.existsById(commande.getId_commande()))
            return commandeRepo.save(commande);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Commande delete(Integer id){
        if (! commandeRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Commande optcommande = findById(id);

        commandeRepo.delete(optcommande);
        return optcommande;
    }
}
