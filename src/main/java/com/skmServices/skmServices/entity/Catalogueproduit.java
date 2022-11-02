package com.skmServices.skmServices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "catalogueproduit")
public class Catalogueproduit  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_catlogueproduit;
    @Column
    private int nombre_total;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "catalogueproduit")
    private List<Produit> produits = new ArrayList<>();

    public Catalogueproduit() {
    }

    public Catalogueproduit(int id_catlogueproduit, int nombre_total) {
        this.id_catlogueproduit = id_catlogueproduit;
        this.nombre_total = nombre_total;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public int getId_catlogueproduit() {
        return id_catlogueproduit;
    }

    public void setId_catlogueproduit(int id_catlogueproduit) {
        this.id_catlogueproduit = id_catlogueproduit;
    }

    public int getNombre_total() {
        return nombre_total;
    }

    public void setNombre_total(int nombre_total) {
        this.nombre_total = nombre_total;
    }
}
