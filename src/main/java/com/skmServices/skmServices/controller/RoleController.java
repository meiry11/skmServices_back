package com.skmServices.skmServices.controller;

import com.skmServices.skmServices.entity.Commande;
import com.skmServices.skmServices.entity.Role;
import com.skmServices.skmServices.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Role findById(@PathVariable Integer id){
        return roleService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public Role create(@RequestBody Role role ){
        return roleService.create(role );
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Role update(@RequestBody Role role, @PathVariable Integer id){
        if(!id.equals(role.getId_role())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");}
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Role delete(@PathVariable Integer id){
        return roleService.delete(id);
    }
}
