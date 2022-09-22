package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "lignecommande")
public class Lignecommande implements Serializable {
    @EmbeddedId
    private IdLignecommande id_lignecommande;
    @Column
    private int lc_prixHT;
    @Column
    private int lc_tva;
    @Column
    private int lc_qte;
    @OneToOne
    @JoinColumn(name = "id_emballage")
    private Emballage emballage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Lignecommande")
    private Produit produit;


    public Lignecommande() {
    }

    public Lignecommande(IdLignecommande id_lignecommande, int lc_prixHT, int lc_tva, int lc_qte) {
        this.id_lignecommande = id_lignecommande;
        this.lc_prixHT = lc_prixHT;
        this.lc_tva = lc_tva;
        this.lc_qte = lc_qte;
    }

    public IdLignecommande getId_lignecommande() {
        return id_lignecommande;
    }

    public void setId_lignecommande(IdLignecommande id_lignecommande) {
        this.id_lignecommande = id_lignecommande;
    }

    public int getLc_prixHT() {
        return lc_prixHT;
    }

    public void setLc_prixHT(int lc_prixHT) {
        this.lc_prixHT = lc_prixHT;
    }

    public int getLc_tva() {
        return lc_tva;
    }

    public void setLc_tva(int lc_tva) {
        this.lc_tva = lc_tva;
    }

    public int getLc_qte() {
        return lc_qte;
    }

    public void setLc_qte(int lc_qte) {
        this.lc_qte = lc_qte;
    }
}
