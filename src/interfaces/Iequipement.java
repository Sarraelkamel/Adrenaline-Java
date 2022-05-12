/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.Equipement;
import models.TopEquipements;
/**
 *
 * @author MSI
 */
public interface Iequipement {
    
      public void ajouterEquipement( Equipement e);

    public void modifierEquipement(Equipement e);

    public void supprimerEquipement(Equipement e);

    public List<Equipement> afficherEquipement();
    
    public List<Equipement> chercherProduitDynamiquement(String s, List<Equipement> l);

public List<TopEquipements> TopEquip ();

}
