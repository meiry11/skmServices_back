package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
    private List<Emballage> emballage;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
    private List<Produit> produit;

    @OneToOne(cascade=CascadeType.ALL,mappedBy = "commande")
    private Livraison livraison;

    public Commande() {
    }

    public Commande(Client client,int id_commande, Date date_commande, Facture facture,List<Emballage> emballage,List<Produit> produit) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.facture = facture;
        this.client = client;
        this.emballage=emballage;
        this.produit=produit;
    }

    public List<Emballage> getEmballage() {
        return emballage;
    }

    public void setEmballage(List<Emballage> emballage) {
        this.emballage = emballage;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
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
