package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "emballage")
public class Emballage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emballage;
    @Column
    private String nom_emballage;
    @Column
    private String model_emballage;
    @Column
    private String format_emballage;
    @ManyToOne
    @JoinColumn(name="id_commande")
    private Commande commande;
    @OneToOne
    @JoinColumn(name = "id_ligneCommande")
    private Lignecommande ligneCommande;

    @ManyToOne
    @JoinColumn(name = "id_catalogueemballage")
    private Catalogueemballage catalogueemballage;

    public Emballage() {
    }

    public Emballage(int id_emballage, String nom_emballage, String model_emballage, String format_emballage, Commande commande, Lignecommande ligneCommande) {
        this.id_emballage = id_emballage;
        this.nom_emballage = nom_emballage;
        this.model_emballage = model_emballage;
        this.format_emballage = format_emballage;
        this.commande = commande;
        this.ligneCommande = ligneCommande;
    }

    public Catalogueemballage getCatalogueemballage() {
        return catalogueemballage;
    }

    public void setCatalogueemballage(Catalogueemballage catalogueemballage) {
        this.catalogueemballage = catalogueemballage;
    }

    public int getId_emballage() {
        return id_emballage;
    }

    public void setId_emballage(int id_emballage) {
        this.id_emballage = id_emballage;
    }

    public String getNom_emballage() {
        return nom_emballage;
    }

    public void setNom_emballage(String nom_emballage) {
        this.nom_emballage = nom_emballage;
    }

    public String getModel_emballage() {
        return model_emballage;
    }

    public void setModel_emballage(String model_emballage) {
        this.model_emballage = model_emballage;
    }

    public String getFormat_emballage() {
        return format_emballage;
    }

    public void setFormat_emballage(String format_emballage) {
        this.format_emballage = format_emballage;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Lignecommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(Lignecommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }
}
