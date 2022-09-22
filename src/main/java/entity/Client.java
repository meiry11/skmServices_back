package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String email;
    @Column
    private Integer telephone;
    @Column(name="date_creation")
    private Date dateCreation;
    @Column(name="numero_siret")
    private Integer numeroSiret;
    @Column(name="mot_de_passe")
    private String motDePasse;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Adresse> adresse;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Commande> commande;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="client",fetch = FetchType.LAZY)
    private Role role;

    public Client() {
    }

    public Client(Integer id, String nom, String prenom, String email, Integer telephone, Date dateCreation, Integer numeroSiret, String motDePasse, List<Adresse> adresse, List<Commande> commande) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.numeroSiret = numeroSiret;
        this.motDePasse = motDePasse;
        this.adresse = adresse;
        this.commande = commande;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getNumeroSiret() {
        return numeroSiret;
    }

    public void setNumeroSiret(Integer numeroSiret) {
        this.numeroSiret = numeroSiret;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Adresse> getAdresse() {
        return adresse;
    }

    public void setAdresse(List<Adresse> adresse) {
        this.adresse = adresse;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", dateCreation=" + dateCreation +
                ", numeroSiret=" + numeroSiret +
                ", motDePasse='" + motDePasse + '\'' +
                ", adresse=" + adresse +
                ", commande=" + commande +
                '}';
    }
}
