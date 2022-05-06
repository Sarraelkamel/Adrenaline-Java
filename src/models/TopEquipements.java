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
public class TopEquipements {
     private int id;
    private int nbrachat;
    private Equipement p;


    public TopEquipements() {
    }

    public TopEquipements(int id, int nbrachat) {
        this.id = id;
        this.nbrachat = nbrachat;
    }

    public TopEquipements(int id, int nbrachat,Equipement p) {
        this.id = id;
        this.nbrachat = nbrachat;
        this.p = p;
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrachat() {
        return nbrachat;
    }

    public void setNbrachat(int nbrachat) {
        this.nbrachat = nbrachat;
    }

    public Equipement getP() {
        return p;
    }

    public void setP(Equipement p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "TopProduits{" + "id=" + id + ", nbrachat=" + nbrachat + ", p=" + p + '}';
    }
}
