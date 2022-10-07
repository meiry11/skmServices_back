package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.skmServices.skmServices.repository.IClientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepo clientRepo;

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findById(Integer id){
        Optional<Client> optClient = clientRepo.findById(id);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Client findByEmail(String email){
        Optional<Client> optClient = clientRepo.findByEmail(email);
        if(optClient.isPresent())
            return optClient.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Optional<Client> login(String email){
        return clientRepo.findByEmail(email);
    }


    public Client create(Client Client ){
        return clientRepo.save(Client );
    }

    public Client update(Client Client){
        if(clientRepo.existsById(Client.getId()))
            return clientRepo.save(Client);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Client delete(Integer id){
        if (! clientRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Client optClient = findById(id);

        clientRepo.delete(optClient);
        return optClient;
    }
}
