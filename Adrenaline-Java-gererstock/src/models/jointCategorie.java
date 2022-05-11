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
public class jointCategorie {

    int idEquip;
    String nomEquip;
    
    String NomCat;
    int PrixEquip;
    String descriptionEquip;
   
    int QuantiteEquip;

    public jointCategorie(int idEquip, String nomEquip, String NomCat, int PrixEquip, String descriptionEquip, int QuantiteEquip) {
        this.idEquip = idEquip;
        this.nomEquip = nomEquip;
        this.NomCat = NomCat;
        this.PrixEquip = PrixEquip;
        this.descriptionEquip = descriptionEquip;
        this.QuantiteEquip = QuantiteEquip;
    }

    public jointCategorie(String nom_eq, String nom_ca, int prix_eq, String desc_eq, int quantite) {
        this.nomEquip = nom_eq;
        this.NomCat = nom_ca;
        this.PrixEquip = prix_eq;
        this.descriptionEquip = desc_eq;
        this.QuantiteEquip = quantite;
    }

    public int getIdEquip() {
        return idEquip;
    }

    public String getNomEquip() {
        return nomEquip;
    }

    public String getNomCat() {
        return NomCat;
    }

    public int getPrixEquip() {
        return PrixEquip;
    }

    public String getDescriptionEquip() {
        return descriptionEquip;
    }

    public int getQuantiteEquip() {
        return QuantiteEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public void setNomCat(String NomCat) {
        this.NomCat = NomCat;
    }

    public void setPrixEquip(int PrixEquip) {
        this.PrixEquip = PrixEquip;
    }

    public void setDescriptionEquip(String descriptionEquip) {
        this.descriptionEquip = descriptionEquip;
    }

    public void setQuantiteEquip(int QuantiteEquip) {
        this.QuantiteEquip = QuantiteEquip;
    }

  
}
