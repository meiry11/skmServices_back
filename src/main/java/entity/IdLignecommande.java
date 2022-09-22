package entity;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class IdLignecommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commande;
    @ManyToOne
    @JoinColumn(name = "id_ligneCommande")
    private Lignecommande ligneCommande;

    public IdLignecommande() {
    }

    public IdLignecommande(int commande, Lignecommande ligneCommande) {
        this.commande = commande;
        this.ligneCommande = ligneCommande;
    }

    public int getId_commande() {
        return commande;
    }

    public void setId_commande(int id_commande) {
        this.commande = id_commande;
    }

    public Lignecommande getId_ligneCommande() {
        return ligneCommande;
    }

    public void setId_ligneCommande(Lignecommande id_ligneCommande) {
        this.ligneCommande = id_ligneCommande;
    }
}
