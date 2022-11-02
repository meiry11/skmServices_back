package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.Emballage;
import com.skmServices.skmServices.repository.IEmballageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmballageService {
    @Autowired
    private IEmballageRepo emballageRepo;

    public List<Emballage> findAll(){
        return emballageRepo.findAll();
    }

    public Emballage findById(Integer id){
        Optional<Emballage> optionalEmballage = emballageRepo.findById(id);
        if(optionalEmballage.isPresent())
            return optionalEmballage.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Emballage create(Emballage emballage ){
        return emballageRepo.save(emballage );
    }

    public Emballage update(Emballage emballage){
        if(emballageRepo.existsById(emballage.getId_emballage()))
            return emballageRepo.save(emballage);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Emballage delete(Integer id){
        if (! emballageRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Emballage optemballage = findById(id);

        emballageRepo.delete(optemballage);
        return optemballage;
    }
}
