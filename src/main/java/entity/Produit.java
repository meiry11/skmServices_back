package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    private int id_produit;
    @Column
    private String nom_produit;
    @Column
    private int prixHT_produit;
    @Column
    private int stock_produit;
    @Column
    private int reference_produit;
    @Column
    private String description_produit;
    @Column
    private String image_produit;
    @Column
    private Date date_creation_produit;
    @Column
    private Date date_peremption;
    @OneToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;
    @OneToOne
    @JoinColumn(name = "id_lignecommande")
    private Lignecommande ligneCommande;
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private  Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_produitgros")
    private ProduitGros produitGros;

    public Produit() {
    }

    public Produit(ProduitGros produitGros,Categorie categorie,int id_produit, String nom_produit, int prixHT_produit, int stock_produit, int reference_produit, String description_produit, String image_produit, Date date_creation_produit, Date date_peremption, Commande commande, Lignecommande ligneCommande) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.prixHT_produit = prixHT_produit;
        this.stock_produit = stock_produit;
        this.reference_produit = reference_produit;
        this.description_produit = description_produit;
        this.image_produit = image_produit;
        this.date_creation_produit = date_creation_produit;
        this.date_peremption = date_peremption;
        this.commande = commande;
        this.ligneCommande = ligneCommande;
        this.categorie=categorie;
        this.produitGros=produitGros;
    }

    public ProduitGros getProduitGros() {
        return produitGros;
    }

    public void setProduitGros(ProduitGros produitGros) {
        this.produitGros = produitGros;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getPrixHT_produit() {
        return prixHT_produit;
    }

    public void setPrixHT_produit(int prixHT_produit) {
        this.prixHT_produit = prixHT_produit;
    }

    public int getStock_produit() {
        return stock_produit;
    }

    public void setStock_produit(int stock_produit) {
        this.stock_produit = stock_produit;
    }

    public int getReference_produit() {
        return reference_produit;
    }

    public void setReference_produit(int reference_produit) {
        this.reference_produit = reference_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public String getImage_produit() {
        return image_produit;
    }

    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }

    public Date getDate_creation_produit() {
        return date_creation_produit;
    }

    public void setDate_creation_produit(Date date_creation_produit) {
        this.date_creation_produit = date_creation_produit;
    }

    public Date getDate_peremption() {
        return date_peremption;
    }

    public void setDate_peremption(Date date_peremption) {
        this.date_peremption = date_peremption;
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
