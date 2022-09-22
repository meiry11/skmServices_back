package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commande;
    @Column
    private Date date_commande;
    @OneToOne
    @JoinColumn(name = "id_facture")
    private Facture facture;
    @ManyToOne
    @JoinColumn(name="id_nom")
    private Client client;

    @OneToOne
    @JoinColumn(name = "id_emballage")
    private Emballage emballage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Commande")
    private Produit produit;

    public Commande() {
    }

    public Commande(Client client,int id_commande, Date date_commande, Facture facture) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.facture = facture;
        this.client = client;
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
