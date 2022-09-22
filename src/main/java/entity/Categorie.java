package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class Categorie  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categorie;
    @Column
    private String nom_categorie;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categorie",fetch = FetchType.LAZY)
    private List<Produit> produit;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, List<Produit> produit) {
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

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }
}
