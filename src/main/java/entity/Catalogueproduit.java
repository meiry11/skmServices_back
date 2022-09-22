package entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

public class Catalogueproduit  implements Serializable {
    @EmbeddedId
    private IdCatalogueproduit id_catlogueproduit;
    @Column
    private int nombre_total;

    public Catalogueproduit() {
    }

    public Catalogueproduit(IdCatalogueproduit id_catlogueproduit, int nombre_total) {
        this.id_catlogueproduit = id_catlogueproduit;
        this.nombre_total = nombre_total;
    }

    public IdCatalogueproduit getId_catlogueproduit() {
        return id_catlogueproduit;
    }

    public void setId_catlogueproduit(IdCatalogueproduit id_catlogueproduit) {
        this.id_catlogueproduit = id_catlogueproduit;
    }

    public int getNombre_total() {
        return nombre_total;
    }

    public void setNombre_total(int nombre_total) {
        this.nombre_total = nombre_total;
    }
}
