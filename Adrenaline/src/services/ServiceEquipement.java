/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.Iequipement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import models.Categorie;

import models.Equipement;

import utils.MaConnexion;
/**
 *
 * @author MSI
 */
public class ServiceEquipement implements Iequipement{
    
    // Variable 1 : Variable de connexion 
    Connection cnx = MaConnexion.getInstance().getCnx();

    
    // Crud d'ajouter d'un produit selon un produit saisie {{ WITHOUT USER ID ]] 

    @Override
    public void ajouterEquipement(Equipement e) {
        String s = "";
        String request = "INSERT INTO `equipement`(`nom_eq`, `category_id_id`, `prix_eq`, `desc_eq`,`quantite_eq`) "
                + "VALUES ('" + e.getNom_eq() + "',"
               
                + e.getCategorie().getId_ca() + ","
                + e.getPrix_eq() + ",'"
                + e.getDesc_eq() + "',"
                + e.getQuantite_eq() +")";
        try {
            // Définier une var Statement responsable de la connexion
            Statement st = cnx.createStatement();
            //Execution da la fonction statement
            //execute update pour l'éxecution même au cours du modification i lfait maj
            st.executeUpdate(request);
            System.out.println(" ** L'ajout du produit est établie avec succés!  ");
        } catch (SQLException ex) {
                       ex.printStackTrace();
        }

    }
    
     // Crud: Modification d'un produit existant selon son objet p et non l'id
    
    @Override
    public void modifierEquipement(Equipement e) {
        String request = "UPDATE `equipement` SET `nom_eq`='" + e.getNom_eq()
                + "',`category_id_id`=" + e.getCategorie().getId_ca()
                + ",`prix_eq`=" + e.getPrix_eq()
                + ",`desc_eq`='" + e.getDesc_eq()
                + "',`quantite_eq`=" + e.getQuantite_eq()
                //                + ",`image`='" + s + 
                + " WHERE id=" + e.getId() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** Equipement modifié avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Crud suppression selon l'appel d'un id d'un produit
   
    @Override
    public void supprimerEquipement(Equipement e) {
        String request = "DELETE FROM `equipement` WHERE `id` = " + e.getId() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** Equipement supprimé avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(" Erreur de suppression ");
        }
    }

    // Affichage de tout les produits du magasin sans exception 
    
    @Override
    public List<Equipement> afficherEquipement() {
        List<Equipement> Equipements = new ArrayList<Equipement>();
        String query = "SELECT * FROM equipement e inner join categorie c on e.category_id_id  = c.id ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Equipements.add(new Equipement(rs.getInt("id"),
                        rs.getString(3),
                         new Categorie(rs.getInt("c.id"),
                                rs.getString("c.nom_ca")),
                        rs.getInt(5),
                        rs.getString(4),
                        rs.getInt(6)
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Equipements;

    }

    
    
    
    
}
