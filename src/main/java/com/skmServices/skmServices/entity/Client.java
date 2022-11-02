package com.skmServices.skmServices.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client",uniqueConstraints = { @UniqueConstraint( columnNames = "email") })
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nom;
    @Column
    private String nom;
    @Column
    private String prenom;
    @NotNull
    @Column(name = "email")
    private String username;
    @Column
    private String telephone;
    @Column(name="date_creation")
    private Date dateCreation;
    @Column(name="numero_siret")
    private Integer numeroSiret;
    @Column(name="mot_de_passe")
    private String password;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Adresse> adresse = new ArrayList<>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Commande> commande = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role>  role = new ArrayList<>();

    private String roles;

    private boolean isActive;

    public Client() {
    }

    public Client(String nom, String prenom, String username, String telephone, Date dateCreation, Integer numeroSiret, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.numeroSiret = numeroSiret;
        this.password = password;
    }

    public Client(String nom, String prenom, String username, String telephone, Date dateCreation, Integer numeroSiret, String password, List<Adresse> adresse, List<Commande> commande, List<Role> role) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.numeroSiret = numeroSiret;
        this.password = password;
        this.adresse = adresse;
        this.commande = commande;
        this.role = role;
    }

    public Integer getId_nom() {
        return id_nom;
    }

    public void setId_nom(Integer id_nom) {
        this.id_nom = id_nom;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getId() {
        return id_nom;
    }

    public void setId(Integer id) {
        this.id_nom = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getNumeroSiret() {
        return numeroSiret;
    }

    public void setNumeroSiret(Integer numeroSiret) {
        this.numeroSiret = numeroSiret;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String motDePasse) {
        this.password = motDePasse;
    }

    public List<Adresse> getAdresse() {
        return adresse;
    }

    public void setAdresse(List<Adresse> adresse) {
        this.adresse = adresse;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id_nom +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + username + '\'' +
                ", telephone=" + telephone +
                ", dateCreation=" + dateCreation +
                ", numeroSiret=" + numeroSiret +
                ", motDePasse='" + password + '\'' +
                ", adresse=" + adresse +
                ", commande=" + commande +
                '}';
    }
}
