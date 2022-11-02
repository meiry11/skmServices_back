package com.skmServices.skmServices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commande;
    @Column
    private Date date_commande;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_facture")
    private Facture facture;
    @ManyToOne
    @JoinColumn(name="id_nom")
    private Client client;

//    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "commande")
//    private List<Emballage> emballage = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
//    private List<Produit> produit = new ArrayList<>();

    @OneToMany//(cascade = CascadeType.ALL,mappedBy = "commande")
    @JoinColumn(name = "id_ligne_commande")
    private List<Lignecommande> Lignecommandes = new ArrayList<>();

    @OneToMany//(cascade=CascadeType.ALL,mappedBy = "commande")
    @JoinColumn(name = "id_livraison")
    private List<Livraison> livraison= new ArrayList<>();

    public Commande() {
    }

    public Commande(Client client,int id_commande, Date date_commande, Facture facture,List<Emballage> emballage,List<Produit> produit) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.facture = facture;
        this.client = client;
        //this.emballage=emballage;
        //this.produit=produit;
    }

    public List<Lignecommande> getLignecommandes() {
        return Lignecommandes;
    }

    public void setLignecommandes(List<Lignecommande> Lignecommandes) {
        this.Lignecommandes = Lignecommandes;
    }

//    public List<Emballage> getEmballage() {
//        return emballage;
//    }
//
//    public void setEmballage(List<Emballage> emballage) {
//        this.emballage = emballage;
//    }

//    public List<Produit> getProduit() {
//        return produit;
//    }
//
//    public void setProduit(List<Produit> produit) {
//        this.produit = produit;
//    }

    public List<Livraison> getLivraison() {
        return livraison;
    }

    public void setLivraison(List<Livraison> livraison) {
        this.livraison = livraison;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
