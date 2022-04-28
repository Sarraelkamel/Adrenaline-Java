/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Reclamation;

/**
 *
 * @author sarra
 */
public interface Ireclamation {
    
    public void ajouterReclamation( Reclamation r);

    public void modifierReclamation(String nom_r,String description_r,int id );

    public void supprimerReclamation(Reclamation r);

    public List<Reclamation> afficherReclamation();
}
