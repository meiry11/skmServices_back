package com.skmServices.skmServices.service;

import com.skmServices.skmServices.entity.Facture;
import com.skmServices.skmServices.entity.Role;
import com.skmServices.skmServices.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private IRoleRepo roleRepo;

    public List<Role> findAll(){
        return roleRepo.findAll();
    }

    public Role findById(Integer id){
        Optional<Role> optionalRole = roleRepo.findById(id);
        if(optionalRole.isPresent())
            return optionalRole.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

//    public Role findByNom_role(String nom){
//        return roleRepo.findByNom_role(nom);
//    }

    public Role create(Role role ){
        return roleRepo.save(role );
    }

    public Role update(Role role){
        if(roleRepo.existsById(role.getId_role()))
            return roleRepo.save(role);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Role delete(Integer id){
        if (! roleRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Role optRole = findById(id);

        roleRepo.delete(optRole);
        return optRole;
    }
}
