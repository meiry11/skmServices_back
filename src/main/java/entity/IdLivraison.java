package entity;

public class IdLivraison {
    private int id_commande;
    private int id_livraison;

    public IdLivraison() {
    }

    public IdLivraison(int id_commande, int id_livraison) {
        this.id_commande = id_commande;
        this.id_livraison = id_livraison;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }
}
