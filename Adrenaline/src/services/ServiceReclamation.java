/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ireclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Commande;
import models.Reclamation;
import utils.MaConnexion;

/**
 *
 * @author sarra
 */
public class ServiceReclamation implements Ireclamation{

    Connection cnx = MaConnexion.getInstance().getCnx();
  
    @Override
    public void ajouterReclamation(Reclamation r) {
        
        String request = "INSERT INTO `reclamation`(`reclamation_id_id`, `nom_r`, `date`,`description_r`) VALUES ("
                + r.getCmd().getId() + ",'"
                + r.getNom_r() + "','"
                + r.getDate() + "','"
                + r.getDescription_r() + "')" ;
        try {
            // Définier une var Statement responsable de la connexion
            Statement st = cnx.createStatement();
            //Execution da la fonction statement
            //execute update pour l'éxecution même au cours du modification i lfait maj
            st.executeUpdate(request);
            System.out.println(" ** L'ajout de la reclamation est établie avec succés!  ");
        } catch (SQLException ex) {
                       ex.printStackTrace();
                        System.out.println(" FFFFFFFFF  ");
        }
    }

    @Override
    public void modifierReclamation(String nom_r,String description_r,int id ) {
        
        String request = "UPDATE `reclamation` SET `nom_r`='" + nom_r + "',`description_r`='" + description_r + " ' WHERE `id`="+id+""; 
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** Reclamation modifié avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimerReclamation(Reclamation r) {
         String request = "DELETE FROM `reclamation` WHERE `id` = " + r.getId_rec() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** Reclamation supprimé avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(" Erreur de suppression ");
        }
    }

    @Override
    public List<Reclamation> afficherReclamation() {
         List<Reclamation> Reclamations = new ArrayList<Reclamation>();
        String query = "SELECT * FROM reclamation r inner join commande c on r.reclamation_id_id  = c.id ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Reclamations.add(new Reclamation(rs.getInt("id"),
                        
                         new Commande(rs.getInt("c.id"),
                                rs.getString("c.nom_c")),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5)
                        
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Reclamations;
    }
    
    
}
