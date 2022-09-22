package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    @Column
    private String nom_role;
    @ManyToOne
    @JoinColumn(name = "id_nom")
    private Client client;

    public Role() {
    }

    public Role(int id_role, String nom_role, Client client) {
        this.id_role = id_role;
        this.nom_role = nom_role;
        this.client = client;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getNom_role() {
        return nom_role;
    }

    public void setNom_role(String nom_role) {
        this.nom_role = nom_role;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
