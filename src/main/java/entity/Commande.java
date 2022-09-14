package entity;

import java.sql.Date;

public class Commande {
    private int id_commande;
    private Date date_commande;
    private Facture facture;

    public Commande() {
    }

    public Commande(int id_commande, Date date_commande, Facture facture) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.facture = facture;
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
}
