package entity;

import java.sql.Date;

public class Facture {
    private int id_facture;
    private String nom_facture;
    private Date date_facture;
    private Commande commande;

    public Facture() {
    }

    public Facture(int id_facture, String nom_facture, Date date_facture, Commande commande) {
        this.id_facture = id_facture;
        this.nom_facture = nom_facture;
        this.date_facture = date_facture;
        this.commande = commande;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public String getNom_facture() {
        return nom_facture;
    }

    public void setNom_facture(String nom_facture) {
        this.nom_facture = nom_facture;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}