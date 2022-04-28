/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Icommande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Commande;
import models.Equipement;

import utils.MaConnexion;

/**
 *
 * @author sarra
 */
public class ServiceCommande implements Icommande {

    Connection cnx = MaConnexion.getInstance().getCnx();
//ajoute temchiiiiiiiiiiiiiiii
    @Override
    public void ajouterCommande(Commande c) {
     
        String request = "INSERT INTO `commande`( `nom_c`, `date`,`prix`,`quantite`,`equi_id`) VALUES ('"
                + c.getNom_c() + "','"
                + c.getDate() + "',"
                + c.getPrix() + ","
                + c.getQuantite() + ","
                + c.getEq().getId() + ")";
        try {
            // Définier une var Statement responsable de la connexion
            Statement st = cnx.createStatement();
            //Execution da la fonction statement
            //execute update pour l'éxecution même au cours du modification i lfait maj
            st.executeUpdate(request);
            System.out.println(" ** L'ajout de la commande est établie avec succés!  ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void modifierCommande(String nom_c,int prix ,int quantite,int id ) {
        
      String request = "UPDATE `commande` SET `nom_c`='" + nom_c+ "', `prix`="+prix+", `quantite`="+quantite+" WHERE `id`="+id+" ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** Commande modifié avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimerCommande(Commande c) {
        String request = "DELETE FROM `commande` WHERE id ="+c.getId()+"";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" ** commande supprimée avec succés ** ");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(" Erreur de suppression ");
        }
    }

    @Override
    public List<Commande> afficherCommande() {
        List<Commande> Commandes = new ArrayList<Commande>();
        String query = "SELECT * FROM commande c inner join equipement e on c.equi_id  = e.id ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("here");

                Commandes.add(new Commande(rs.getInt("id"),
                        rs.getString("nom_c"),
                        rs.getDate("date"),
                        rs.getInt("prix"),
                        rs.getInt("quantite"),
                        new Equipement(rs.getInt("e.id"),
                                rs.getString("e.nom_eq"))
                ));
                System.out.println(" ** commande AFFiCHE** ");
            }
        } catch (SQLException ex) {
            System.out.println("exception");
            ex.getMessage();
        }

        return Commandes;

    }

    

    
}
