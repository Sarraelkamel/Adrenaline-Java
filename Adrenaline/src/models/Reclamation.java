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
public class Reclamation {
    
    private int id;
    private Commande cmd;
    private String nom_r;
    private Date date;
    private String description_r;

    public Reclamation(int id, Commande cmd, String nom_r, Date date, String description_r) {
        this.id = id;
        this.cmd = cmd;
        this.nom_r = nom_r;
        this.date = date;
        this.description_r = description_r;
    }

    public Reclamation(Commande cmd, String nom_r, Date date, String description_r) {
        this.cmd = cmd;
        this.nom_r = nom_r;
        this.date = date;
        this.description_r = description_r;
    }

    public Reclamation(String nom_r, Date date, String description_r) {
        this.nom_r = nom_r;
        this.date = date;
        this.description_r = description_r;
    }

    public Reclamation(Date date, String description_r) {
        this.date = date;
        this.description_r = description_r;
    }

    public Reclamation(String description_r) {
        this.description_r = description_r;
    }

    public Reclamation(int id , String nom_r, Date date, String description_r) {
        this.id = id;
        this.nom_r = nom_r;
        this.date = date;
        this.description_r = description_r;
    }

    public Reclamation(int id , Commande cmd, Date date, String description_r) {
        this.id  = id ;
        this.cmd = cmd;
        this.date = date;
        this.description_r = description_r;
    }
    

    public int getId_rec() {
        return id;
    }

    public Reclamation(int id, String nom_r) {
        this.id = id;
        this.nom_r = nom_r;
    }

    public Commande getCmd() {
        return cmd;
    }

    public String getNom_r() {
        return nom_r;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription_r() {
        return description_r;
    }

    public void setId_rec(int id) {
        this.id= id;
    }

    public void setCmd(Commande cmd) {
        this.cmd = cmd;
    }

    public void setNom_r(String nom_r) {
        this.nom_r = nom_r;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription_r(String description_r) {
        this.description_r = description_r;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", cmd=" + cmd + ", nom_r=" + nom_r + ", date=" + date + ", description_r=" + description_r + '}';
    }

   
    
    
}
