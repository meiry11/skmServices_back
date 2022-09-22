package entity;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class IdLignecommande implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "id_ligneCommande")
    private Lignecommande ligneCommande;

    public IdLignecommande() {
    }

    public IdLignecommande(Commande commande, Lignecommande ligneCommande) {
        this.commande = commande;
        this.ligneCommande = ligneCommande;
    }

    public Commande getId_commande() {
        return commande;
    }

    public void setId_commande(Commande id_commande) {
        this.commande = id_commande;
    }

    public Lignecommande getId_ligneCommande() {
        return ligneCommande;
    }

    public void setId_ligneCommande(Lignecommande id_ligneCommande) {
        this.ligneCommande = id_ligneCommande;
    }
}
