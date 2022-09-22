package entity;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class IdLivraison implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commande")
    private Commande commande;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int livraison;

    public IdLivraison() {
    }

    public IdLivraison(Commande id_commande, int id_livraison) {
        this.commande = id_commande;
        this.livraison = id_livraison;
    }

    public Commande getId_commande() {
        return commande;
    }

    public void setId_commande(Commande id_commande) {
        this.commande = id_commande;
    }

    public int getId_livraison() {
        return livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.livraison = id_livraison;
    }
}
