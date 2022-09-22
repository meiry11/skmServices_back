package entity;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class IdLivraison implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "id_livraison")
    private Livraison livraison;

    public IdLivraison() {
    }

    public IdLivraison(Commande id_commande, Livraison id_livraison) {
        this.commande = id_commande;
        this.livraison = id_livraison;
    }

    public Commande getId_commande() {
        return commande;
    }

    public void setId_commande(Commande id_commande) {
        this.commande = id_commande;
    }

    public Livraison getId_livraison() {
        return livraison;
    }

    public void setId_livraison(Livraison id_livraison) {
        this.livraison = id_livraison;
    }
}
