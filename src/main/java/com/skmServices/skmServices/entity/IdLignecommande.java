package com.skmServices.skmServices.entity;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class IdLignecommande implements Serializable {

    @Column(name = "id_ligne_commande")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ligneCommande;
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;

    public IdLignecommande() {
    }

    public IdLignecommande(int id_ligneCommande, Commande commande) {
        this.id_ligneCommande = id_ligneCommande;
        this.commande = commande;
    }

    public int getId_ligneCommande() {
        return id_ligneCommande;
    }

    public void setId_ligneCommande(int id_ligneCommande) {
        this.id_ligneCommande = id_ligneCommande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
