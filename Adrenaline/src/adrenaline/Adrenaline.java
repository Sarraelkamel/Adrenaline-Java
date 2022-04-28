/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrenaline;

import java.sql.Date;
import java.time.LocalDate;
import interfaces.Icategorie;
import interfaces.Icommande;
import interfaces.Iequipement;
import interfaces.Ireclamation;
import models.Categorie;
import models.Commande;
import models.Equipement;
import models.Reclamation;
import services.ServiceCategorie;
import services.ServiceCommande;
import services.ServiceEquipement;
import services.ServiceReclamation;

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
        String str = "2018-03-21";
        Date date = Date.valueOf(str);
        Icategorie cc = new ServiceCategorie();
        Iequipement eq = new ServiceEquipement();
        
        
        Categorie c1 = new Categorie(8, "hazem");
         Equipement e1 = new Equipement(3,"Salah",c1,40,"personne",4 );
         
         
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
        
        
        Icommande c = new ServiceCommande();
        
        Commande c2 = new Commande(33,"DS",date,23,1,e1); 
        
       Ireclamation r = new ServiceReclamation();
        
       Reclamation r1= new Reclamation(19,c2,"TEST",date,"DHDH");
        
       r.ajouterReclamation(r1);
       //c.ajouterCommande(c2);
      //System.out.println( c.afficherCommande());
      //  c.modifierCommande("fgsarrraaaaaaa",2,6,35);
      //c.supprimerCommande(c2);
      //r.supprimerReclamation(r1);
      
      //System.out.println( r.afficherReclamation());
      //r.modifierReclamation("Testtttttt","dsddfsd",19);
      
       
        
    }
    
}
