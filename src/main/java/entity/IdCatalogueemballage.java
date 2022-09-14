package entity;

public class IdCatalogueemballage {
    private Emballage emballage;
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
