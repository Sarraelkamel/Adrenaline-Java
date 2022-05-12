/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Iskander
 */
public class Categorie {

    private int id_ca;
    private String nom_ca; // Seuelement???

    // Constructor vide
    public Categorie() {
    }

    public Categorie(int id_ca, String nom_ca) {
        this.id_ca = id_ca;
        this.nom_ca = nom_ca;
    }

    public Categorie(int id_ca) {
        this.id_ca = id_ca;
    }

    public Categorie(String nom_ca) {
        this.nom_ca = nom_ca;
    }

    public int getId_ca() {
        return id_ca;
    }

    public String getNom_ca() {
        return nom_ca;
    }

    public void setId_ca(int id_ca) {
        this.id_ca = id_ca;
    }

    public void setNom_ca(String nom_ca) {
        this.nom_ca = nom_ca;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_ca=" + id_ca + ", nom_ca=" + nom_ca + '}';
    }

  
}
