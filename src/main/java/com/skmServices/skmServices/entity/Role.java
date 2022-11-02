package com.skmServices.skmServices.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    @Column
    private String nom;
//    @ManyToOne
//    @JoinColumn(name = "id_nom")
//    private Client client;

    public Role() {
    }

    public Role(int id_role, String nom) {
        this.id_role = id_role;
        this.nom = nom;
        //this.client = client;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom_role) {
        this.nom = nom_role;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
}
