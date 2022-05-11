/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrenaline;

import interfaces.Icategorie;
import interfaces.Iequipement;
import models.Categorie;
import models.Equipement;
import services.ServiceCategorie;
import services.ServiceEquipement;

/**
 *
 * @author MSI
 */
public class Adrenaline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Icategorie cc = new ServiceCategorie();
        Iequipement eq = new ServiceEquipement();
        
        
        Categorie c1 = new Categorie(8, "hazem");
         Equipement e1 = new Equipement(3,"Salah",c1,40,"personne",4 );
         
         System.out.println(cc.retrieveCategorie(c1.getNom_ca()));
System.out.println(eq.chercherProduitDynamiquement("enfant", eq.afficherEquipement()));
         
         //Categorie CRUD
         
         //cc.modifierCategorie(c1);
         //cc.ajouterCategorie(c1);
        // cc.supprimerCategorie(c1);
        // System.out.println(cc.afficherCategorie());
        
        //Equipements CRUD
        
        //System.out.println(eq.afficherEquipement());
        //System.out.println( eq.ajouterEquipement(e1));
        //eq.supprimerEquipement(e1);
        //eq.modifierEquipement(e1);
    }
    
}
