package com.skmServices.skmServices.entity;

import com.sun.istack.NotNull;

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
    @Column
    private String email;
    @Column
    private String telephone;
    @Column(name="date_creation")
    private Date dateCreation;
    @Column(name="numero_siret")
    private Integer numeroSiret;
    @Column(name="mot_de_passe")
    private String motDePasse;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Adresse> adresse = new ArrayList<>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Commande> commande = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy="client",fetch = FetchType.LAZY)
    private List<Role>  role = new ArrayList<>();

    public Client() {
    }

    public Client(String nom, String prenom, String email, String telephone, Date dateCreation, Integer numeroSiret, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.numeroSiret = numeroSiret;
        this.motDePasse = motDePasse;
    }

    public Client(String nom, String prenom, String email, String telephone, Date dateCreation, Integer numeroSiret, String motDePasse, List<Adresse> adresse, List<Commande> commande, List<Role> role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.numeroSiret = numeroSiret;
        this.motDePasse = motDePasse;
        this.adresse = adresse;
        this.commande = commande;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", dateCreation=" + dateCreation +
                ", numeroSiret=" + numeroSiret +
                ", motDePasse='" + motDePasse + '\'' +
                ", adresse=" + adresse +
                ", commande=" + commande +
                '}';
    }
}
