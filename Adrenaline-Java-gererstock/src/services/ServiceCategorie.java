package services;

import interfaces.Icategorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Categorie;
import utils.MaConnexion;

/**
 *
 * @author Iskander
 */
public class ServiceCategorie implements Icategorie {

    // var
    String nomcat;

    // Variable 1
    Connection cnx = MaConnexion.getInstance().getCnx();

    // Crud ajout catégorie
    @Override
    public void ajouterCategorie(Categorie c) {
        String request = "INSERT INTO `categorie`(`nom_ca`) VALUES ('" + c.getNom_ca() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" * Categorie ajoutée avec succés * ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Modification
    @Override
    public void modifierCategorie(Categorie c) {
        String request = "UPDATE `categorie` SET `nom_ca`='" + c.getNom_ca() + "' WHERE id=" + c.getId_ca() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" * Catégorie modifiée avec succés * ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Crud Suppression
    @Override
    public void supprimerCategorie(Categorie c) {
        String request = "DELETE FROM `categorie` WHERE `id` = " + c.getId_ca() + " ";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println(" * Catégorie supprimée avec succés * ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Affichage
    @Override
    public List<Categorie> afficherCategorie() {
        List<Categorie> Categories = new ArrayList<Categorie>();
        String query = "SELECT * FROM categorie";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Categories.add(new Categorie(rs.getInt("id"), rs.getString(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Categories;
    }

    @Override
    public Categorie retrieveCategorie(String nom) {
        
          Categorie Categories = new Categorie();
        String query = "SELECT * FROM categorie where `nom_ca`= '" + nom + "' ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
           Categories.setId_ca(rs.getInt(1));
           Categories.setNom_ca( rs.getString(2));
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Categories;
    }

}
