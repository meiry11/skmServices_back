package entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class IdCatalogueemballage implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_emballage")
    private Emballage emballage;
    @ManyToOne
    @JoinColumn(name = "id_nom")
    private Client client;

    public IdCatalogueemballage() {
    }

    public IdCatalogueemballage(Emballage emballage, Client client) {
        this.emballage = emballage;
        this.client = client;
    }

    public Emballage getEmballage() {
        return emballage;
    }

    public void setEmballage(Emballage emballage) {
        this.emballage = emballage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
