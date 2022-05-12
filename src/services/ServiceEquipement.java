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
import models.TopEquipements;

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
        String request = "INSERT INTO `equipement`(`nom_eq`, `category_id_id`, `prix_eq`, `desc_eq`,`quantite_eq`,`image_eq`) "
                + "VALUES ('" + e.getNom_eq() + "','"
                + e.getCategorie().getId_ca() + "','"
                + e.getPrix_eq() + "','"
                + e.getDesc_eq() + "','"
                + e.getQuantite_eq() + "','"
                + e.getImage_eq()
                +"')";
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
                        rs.getInt(6),
                        rs.getString(7)
              
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Equipements;

    }

     @Override
    public List<TopEquipements> TopEquip (){
        int n =3;
        List<TopEquipements> Equipements = new ArrayList<TopEquipements>();
       

        String req = "select equi_id , count(equi_id) from commande group by equi_id order by count(equi_id) desc";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            int i=0;
            while(rs.next() && i<n ){
                String req1 = "select * from equipement where id ="+rs.getInt(1)+"";
                Statement st1 = cnx.createStatement();
                ResultSet rs1 = st1.executeQuery(req1);
                while(rs1.next()){
                Equipements.add(new TopEquipements(rs.getInt(1),rs.getInt(2),
                    new Equipement(rs1.getInt(1),rs1.getString(3),rs1.getInt(5),rs1.getString(4),rs1.getString(7))
));
                i++;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Equipements;
    }
    
     @Override
    public List<Equipement> chercherProduitDynamiquement(String s, List<Equipement> l) {
        List<Equipement> strList = l.stream()
                .map(Equipement::concat)
                .filter(pt -> pt.toLowerCase().contains(s.toLowerCase())) //starts with (only searches for a person's id)
                .map(pt -> new Equipement(Integer.parseInt(pt.split("-")[0]),
                pt.split("-")[1],
                
                new Categorie(Integer.parseInt(pt.split("-")[2]), pt.split("-")[3]),
                Integer.parseInt(pt.split("-")[4]),
                pt.split("-")[5],
                  Integer.parseInt(pt.split("-")[6]),
                pt.split("-")[7]
        ))
                //Dans le cas ou je veut limiter le nombre des produits affichés         .limit(5)
                .collect(Collectors.toList());
        return strList;
    }

    
}