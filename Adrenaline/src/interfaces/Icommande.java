/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Commande;

/**
 *
 * @author sarra
 */
public interface Icommande {
    
    public void ajouterCommande (Commande c);

   public void modifierCommande(String nom_c,int prix ,int quantite,int id );
   
    public void supprimerCommande(Commande c);

    public List<Commande> afficherCommande();
}
