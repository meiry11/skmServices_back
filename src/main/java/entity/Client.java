package entity;

import java.sql.Date;

public class Client {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Integer telephone;
    private Date dateCreation;
    private Integer numeroSiret;
    private String motDePasse;
    private Adresse adresse;
    private Commande commande;

    public Client() {
    }

    public Client(Integer id, String nom, String prenom, String email, Integer telephone, Date dateCreation, Integer numeroSiret, String motDePasse, Adresse adresse, Commande commande) {
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
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
