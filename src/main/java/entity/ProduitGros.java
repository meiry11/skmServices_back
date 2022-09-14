package entity;

public class ProduitGros {
    private int id_produitGros;
    private Produit produit;

    public ProduitGros() {
    }

    public ProduitGros(int id_produitGros, Produit produit) {
        this.id_produitGros = id_produitGros;
        this.produit = produit;
    }

    public int getId_produitGros() {
        return id_produitGros;
    }

    public void setId_produitGros(int id_produitGros) {
        this.id_produitGros = id_produitGros;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
