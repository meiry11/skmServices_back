package com.skmServices.skmServices.entity;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class IdLivraison implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande id_commande;
    @Column(name = "id_livraison")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int livraison;

    public IdLivraison() {
    }

    public IdLivraison(Commande id_commande, int id_livraison) {
        this.id_commande = id_commande;
        this.livraison = id_livraison;
    }

    public Commande getId_commande() {
        return id_commande;
    }

    public void setId_commande(Commande id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_livraison() {
        return livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.livraison = id_livraison;
    }
}
