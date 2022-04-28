
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author GhAlone
 */
public class Sponsor {
    private int id ; 
    private String nom_sp ;
    private int num_sp ;
    private String email_sp ;

    public Sponsor(int id, String nom_sp, int num_sp, String email_sp) {
        this.id = id;
        this.nom_sp = nom_sp;
        this.num_sp = num_sp;
        this.email_sp = email_sp;
    }



    
 

 
    public int getId() {
        return id;
    }

    public String getNom_sp() {
        return nom_sp;
    }

    public int getNum_sp() {
        return num_sp;
    }

    public String getEmail_sp() {
        return email_sp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_sp(String nom_sp) {
        this.nom_sp = nom_sp;
    }

    public void setNum_sp(int num_sp) {
        this.num_sp = num_sp;
    }

    public void setEmail_sp(String email_sp) {
        this.email_sp = email_sp;
    }
  
    
}
