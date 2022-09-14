package entity;

public class IdCatalogueproduit {
    private Produit produit;
    private Client client;

    public IdCatalogueproduit() {
    }

    public IdCatalogueproduit(Produit produit, Client client) {
        this.produit = produit;
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
