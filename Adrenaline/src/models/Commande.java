/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author sarra
 */
public class Commande {
    
    private int id;
    private String nom_c;
    private Date date;
    private int prix;
    private int quantite;
    private Equipement eq;
    public Commande(int id, String nom_c) {
        this.id = id;
        this.nom_c = nom_c;
    }

    public Commande(int id, String nom_c, Date date, int prix, int quantite) {
        this.id = id;
        this.nom_c = nom_c;
        this.date = date;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Commande( String nom_c, int prix, int quantite, int id) {
        
        this.nom_c = nom_c;
        this.prix = prix;
        this.quantite = quantite;
        this.id = id;
    }

   

   

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_c(String nom_c) {
        this.nom_c = nom_c;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEq(Equipement eq) {
        this.eq = eq;
    }

    public int getId() {
        return id;
    }

    public String getNom_c() {
        return nom_c;
    }

    public Date getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public Equipement getEq() {
        return eq;
    }

    public Commande(int id , String nom_c, int prix, int quantite, Equipement eq) {
        this.id= id;
        this.nom_c = nom_c;
        this.prix = prix;
        this.quantite = quantite;
        this.eq = eq;
    }

    public Commande(String nom_c, Date date, int prix, int quantite, Equipement eq) {
        this.nom_c = nom_c;
        this.date = date;
        this.prix = prix;
        this.quantite = quantite;
        this.eq = eq;
    }

    public Commande(int id , String nom_c, Date date, int prix, int quantite, Equipement eq) {
        this.id = id;
        this.nom_c = nom_c;
        this.date = date;
        this.prix = prix;
        this.quantite = quantite;
        this.eq = eq;
    }

    public Commande(String nom_c, Date date, int prix, int quantite) {
        this.nom_c = nom_c;
        this.date = date;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Commande(String nom_c) {
        this.nom_c = nom_c;
    }

    public Commande(String nom_c, int prix) {
        this.nom_c = nom_c;
        this.prix = prix;
    }

    public Commande(String nom_c, int prix, int quantite) {
        this.nom_c = nom_c;
        this.prix = prix;
        this.quantite = quantite;
    }
 

    @Override
    public String toString() {
        return "Commande{" + "id=" + id+ ", nom_c=" + nom_c + ", date=" + date + ", prix=" + prix + ", quantite=" + quantite + ", eq=" + eq + '}';
    }
    
    
}
