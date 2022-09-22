package entity;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class IdCatalogueproduit implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "id_nom")
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
