
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package services;

import models.Evenement;
import java.util.List;

/**
 *
 * @author GhAlone
 */

public interface SpService<Sp> {
        public void ajouter(Sp s);
      //  public void delete(Sp s);
        public void modifier(Sp s);
        public List <Sp> afficher();
         public List<Sp> tristreamnom() ;
           public List<Sp> tristreamdescription() ;
   
        
} 