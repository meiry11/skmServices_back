package com.skmServices.skmServices.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresse")
public class Adresse  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_adresse;
    @Column
    private String nom_rue;
    @Column
    private int numero;
    @Column
    private String code_postale;
    @Column
    private String nom_ville;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nom")
    private Client client;

    public Adresse() {
    }

    public Adresse(String nom_rue, int numero, String code_postale, String nom_ville, Client client) {
        this.nom_rue = nom_rue;
        this.numero = numero;
        this.code_postale = code_postale;
        this.nom_ville = nom_ville;
        this.client = client;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getNom_rue() {
        return nom_rue;
    }

    public void setNom_rue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(String code_postale) {
        this.code_postale = code_postale;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
