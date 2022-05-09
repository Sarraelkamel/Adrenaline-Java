/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.util.List;
import Entities.Evenement;

/**
 *
 * @author Espace Info
 */
public interface evService  {
    public void affichierEvenement(Evenement e);
    public void ajouterEvent(Evenement e);
    public void modifierEvent(Evenement e);
    
}
