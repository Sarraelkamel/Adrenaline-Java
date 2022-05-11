/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Espace Info
 */
public class Evenement {
    private int id;
    private int sponsors_id_id;
    private String nom_ev;
    private Date date_ev;
    private String heured_ev,heuref_ev;
    private int etoiles;

    public Evenement(int id, int sponsors_id_id, String nom_ev, Date date_ev, String heured_ev, String heuref_ev, int etoiles) {
        this.id = id;
        this.sponsors_id_id = sponsors_id_id;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.heured_ev = heured_ev;
        this.heuref_ev = heuref_ev;
        this.etoiles = etoiles;
    }


    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public Evenement( int sponsors_id_id, String nom_ev, Date date_ev, String heured_ev, String heuref_ev, int etoiles) {
        this.sponsors_id_id = sponsors_id_id;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.heured_ev = heured_ev;
        this.heuref_ev = heuref_ev;
        this.etoiles = etoiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSponsors_id_id() {
        return sponsors_id_id;
    }

    public void setSponsors_id_id(int sponsors_id_id) {
        this.sponsors_id_id = sponsors_id_id;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public Date getDate_ev() {
        return date_ev;
    }

    public void setDate_ev(Date date_ev) {
        this.date_ev = date_ev;
    }

    public String getHeured_ev() {
        return heured_ev;
    }

    public void setHeured_ev(String heured_ev) {
        this.heured_ev = heured_ev;
    }

    public String getHeuref_ev() {
        return heuref_ev;
    }

    public void setHeuref_ev(String heuref_ev) {
        this.heuref_ev = heuref_ev;
    }

    public Evenement(int id, int sponsors_id_id, String nom_ev, Date date_ev, String heured_ev, String heuref_ev) {
        this.id = id;
        this.sponsors_id_id = sponsors_id_id;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.heured_ev = heured_ev;
        this.heuref_ev = heuref_ev;
    }

    public Evenement(int id, String nom_ev, Date date_ev, String heured_ev, String heuref_ev) {
        this.id = id;
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.heured_ev = heured_ev;
        this.heuref_ev = heuref_ev;
    }

    public Evenement(String nom_ev, Date date_ev, String heured_ev, String heuref_ev) {
        this.nom_ev = nom_ev;
        this.date_ev = date_ev;
        this.heured_ev = heured_ev;
        this.heuref_ev = heuref_ev;
    }

    public Evenement() {
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", sponsors_id_id=" + sponsors_id_id + ", nom_ev=" + nom_ev + ", date_ev=" + date_ev + ", heured_ev=" + heured_ev + ", heuref_ev=" + heuref_ev + '}';
    }
    
    
}
