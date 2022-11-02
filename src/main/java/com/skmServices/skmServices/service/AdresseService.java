package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Adresse;
import com.skmServices.skmServices.repository.IAdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {
    @Autowired
    private IAdresseRepo adresseRepo;

    public List<Adresse> findAll(){
        return adresseRepo.findAll();
    }

    public Adresse findById(Integer id){
        Optional<Adresse> optClient = adresseRepo.findById(id);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Adresse create(Adresse adresse ){
        return adresseRepo.save(adresse );
    }

    public Adresse update(Adresse adresse){
        if(adresseRepo.existsById(adresse.getId_adresse()))
            return adresseRepo.save(adresse);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Adresse delete(Integer id){
        if (! adresseRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Adresse optadresse = findById(id);

        adresseRepo.delete(optadresse);
        return optadresse;
    }
}
