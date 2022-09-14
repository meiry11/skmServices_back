package entity;

public class Catalogueemballage {
    private IdCatalogueemballage id_catalogueemballage;
    private int nombre_total;

    public Catalogueemballage() {
    }

    public Catalogueemballage(IdCatalogueemballage id_catalogueemballage, int nombre_total) {
        this.id_catalogueemballage = id_catalogueemballage;
        this.nombre_total = nombre_total;
    }

    public IdCatalogueemballage getId_catalogueemballage() {
        return id_catalogueemballage;
    }

    public void setId_catalogueemballage(IdCatalogueemballage id_catalogueemballage) {
        this.id_catalogueemballage = id_catalogueemballage;
    }

    public int getNombre_total() {
        return nombre_total;
    }

    public void setNombre_total(int nombre_total) {
        this.nombre_total = nombre_total;
    }
}
