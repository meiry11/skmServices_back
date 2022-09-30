package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Emballage;
import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.repository.IFactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private IFactureRepo factureRepo;

    public List<Facture> findAll(){
        return factureRepo.findAll();
    }

    public Facture findById(Integer id){
        Optional<Facture> optionalFacture = factureRepo.findById(id);
        if(optionalFacture.isPresent())
            return optionalFacture.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Facture create(Facture facture ){
        return factureRepo.save(facture );
    }

    public Facture update(Facture facture){
        if(factureRepo.existsById(facture.getId_facture()))
            return factureRepo.save(facture);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Facture delete(Integer id){
        if (! factureRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Facture optfacture = findById(id);

        factureRepo.delete(optfacture);
        return optfacture;
    }
}
