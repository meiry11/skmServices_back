package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "livraison")
public class Livraison implements Serializable {
    @EmbeddedId
    private  IdLivraison id_livraison;
    @Column
    private String nom_livraison;
    @Column
    private String choix_livraison;

    public Livraison() {
    }

    public Livraison(IdLivraison id_livraison, String nom_livraison, String choix_livraison) {
        this.id_livraison = id_livraison;
        this.nom_livraison = nom_livraison;
        this.choix_livraison = choix_livraison;
    }

    public IdLivraison getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(IdLivraison id_livraison) {
        this.id_livraison = id_livraison;
    }

    public String getNom_livraison() {
        return nom_livraison;
    }

    public void setNom_livraison(String nom_livraison) {
        this.nom_livraison = nom_livraison;
    }

    public String getChoix_livraison() {
        return choix_livraison;
    }

    public void setChoix_livraison(String choix_livraison) {
        this.choix_livraison = choix_livraison;
    }
}
