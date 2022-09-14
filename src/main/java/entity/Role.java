package entity;

public class Role {
    private int id_role;
    private String nom_role;
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
