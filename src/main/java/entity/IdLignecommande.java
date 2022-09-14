package entity;

public class IdLignecommande {
    private int id_commande;
    private int id_ligneCommande;

    public IdLignecommande() {
    }

    public IdLignecommande(int id_commande, int id_ligneCommande) {
        this.id_commande = id_commande;
        this.id_ligneCommande = id_ligneCommande;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_ligneCommande() {
        return id_ligneCommande;
    }

    public void setId_ligneCommande(int id_ligneCommande) {
        this.id_ligneCommande = id_ligneCommande;
    }
}
