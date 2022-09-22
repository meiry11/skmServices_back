package entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "catalogueemballage")
public class Catalogueemballage implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id_catalogueemballage;
    @Column
    private int nombre_total;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "catalogueemballage")
    private List<Emballage> emballage;

    public Catalogueemballage() {
    }

    public List<Emballage> getEmballage() {
        return emballage;
    }

    public void setEmballage(List<Emballage> emballage) {
        this.emballage = emballage;
    }

    public Catalogueemballage(int id_catalogueemballage, int nombre_total) {
        this.id_catalogueemballage = id_catalogueemballage;
        this.nombre_total = nombre_total;
    }

    public int getId_catalogueemballage() {
        return id_catalogueemballage;
    }

    public void setId_catalogueemballage(int id_catalogueemballage) {
        this.id_catalogueemballage = id_catalogueemballage;
    }

    public int getNombre_total() {
        return nombre_total;
    }

    public void setNombre_total(int nombre_total) {
        this.nombre_total = nombre_total;
    }
}
