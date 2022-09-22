package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "produitgros")
public class ProduitGros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produitGros;
    @OneToMany(mappedBy = "produitgros",fetch = FetchType.LAZY)
    private List<Produit> produit;

    @Column
    private int quantite;

    public ProduitGros() {
    }

    public ProduitGros(int quantite,int id_produitGros, List<Produit> produit) {
        this.id_produitGros = id_produitGros;
        this.produit = produit;
        this.quantite = quantite;
    }

    public int getId_produitGros() {
        return id_produitGros;
    }

    public void setId_produitGros(int id_produitGros) {
        this.id_produitGros = id_produitGros;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
