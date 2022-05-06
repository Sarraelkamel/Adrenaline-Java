/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author MSI
 */
public class Equipement {
     private int id;
    private String nom_eq;
    private Categorie categorie;
    private int prix_eq;
    private String desc_eq;
    private int quantite_eq;
    private String image_eq;

    public Equipement() {
    }

    public Equipement(String nom_eq, Categorie categorie, int prix_eq, String desc_eq, int quantite_eq, String image_eq) {
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite_eq;
        this.image_eq = image_eq;
    }

    public Equipement(int id, String nom_eq, Categorie categorie, int prix_eq, String desc_eq, int quantite_eq, String image_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite_eq;
        this.image_eq = image_eq;
    }

    public Equipement(String nom_eq, String desc_eq) {
        this.nom_eq = nom_eq;
        this.desc_eq = desc_eq;
    }

    public Equipement(int id, String nom_eq, Categorie categorie, int prix_eq, String desc_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
    }

   

    public Equipement(int id, String nom_eq, int prix_eq, String desc_eq, int quantite_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite_eq;
    }

    
    
    public Equipement(String nom_eq, Categorie categorie, int prix_eq, String desc_eq, int quantite_eq) {
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite_eq;
       
    }

    public Equipement(int id, String nom_eq, int prix_eq, String desc_eq, String image_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.image_eq = image_eq;
    }

    public Equipement(String nom_eq, int prix_eq) {
        this.nom_eq = nom_eq;
        this.prix_eq = prix_eq;
    }

    public Equipement(int id, String nom_eq, int prix_eq, int quantite_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.prix_eq = prix_eq;
        this.quantite_eq = quantite_eq;
    }

    public Equipement(int id, String nom_eq, Categorie categorie, String desc_eq, int quantite_eq, String image_eq) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite_eq;
        this.image_eq = image_eq;
    }

    public Equipement(int id, String nom_eq, Categorie categorie, int prix_eq, String desc_eq , int quantite ) {
        this.id = id;
        this.nom_eq = nom_eq;
        this.categorie = categorie;
        this.prix_eq = prix_eq;
        this.desc_eq = desc_eq;
        this.quantite_eq = quantite;
    }

  

    public int getId() {
        return id;
    }

    public String getNom_eq() {
        return nom_eq;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public int getPrix_eq() {
        return prix_eq;
    }

    public String getDesc_eq() {
        return desc_eq;
    }

    public int getQuantite_eq() {
        return quantite_eq;
    }

    public String getImage_eq() {
        return image_eq;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_eq(String nom_eq) {
        this.nom_eq = nom_eq;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setPrix_eq(int prix_eq) {
        this.prix_eq = prix_eq;
    }

    public void setDesc_eq(String desc_eq) {
        this.desc_eq = desc_eq;
    }

    public void setQuantite_eq(int quantite_eq) {
        this.quantite_eq = quantite_eq;
    }

    public void setImage_eq(String image_eq) {
        this.image_eq = image_eq;
    }

    @Override
    public String toString() {
        return "Equipement{" + "id=" + id + ", nom_eq=" + nom_eq + ", categorie=" + categorie + ", prix_eq=" + prix_eq + ", desc_eq=" + desc_eq + ", quantite_eq=" + quantite_eq + ", image_eq=" + image_eq + '}';
    }
     // La méthode de concaténation pour le 1ér métier
    public String concat() {
        return id + "-" + nom_eq + "-" + categorie.getId_ca() + "-" + categorie.getNom_ca() + "-" + prix_eq + "-" + desc_eq + "-"  + quantite_eq + "-" + image_eq + "-"; // probléme d'espace / path : 7othom f dossier sans espace
    }
    
    
}
