package entity;

public class Categorie {
    private int id_categorie;
    private String nom_categorie;
    private Produit produit;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, Produit produit) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.produit = produit;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
