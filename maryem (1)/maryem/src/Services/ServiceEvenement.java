/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.events.Comment;
import utils.DataSource;

/**
 *
 * @author Espace Info
 */
public class ServiceEvenement {

    private PreparedStatement pst;

    private static ServiceEvenement instance;
    private Statement st;
    private ResultSet rs;
    Connection myConnex;
    //cnxBD myc = cnxBD.myc.getIstance();
    Connection cnx = DataSource.getInstance().getCnx();

    public void ajouterEvent(Evenement e) {

        String req = "insert into evenement (sponsors_id_id,nom_ev,date_ev,heured_ev,heuref_ev,etoiles) values (?,?,?,?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
            //pst.setInt(1, e.getSonsors_id_id());
            pst.setInt(1, e.getSponsors_id_id());
            pst.setString(2, e.getNom_ev());

            pst.setDate(3, (Date) e.getDate_ev());

            pst.setString(4, e.getHeured_ev());
            pst.setString(5, e.getHeuref_ev());
            pst.setInt(6, e.getEtoiles());

            //          System.out.println(id_formation);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("hne");
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerevent(String nom) {

        try {
            String req2 = "DELETE FROM evenement  WHERE  nom_ev='" + nom + "'";

            st.executeUpdate(req2);
            System.out.println("evenement bien supprimer");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Evenement> afficherEvenement() {
        List<Evenement> Evenements = new ArrayList<Evenement>();
        String request = "SELECT * FROM evenement";

        try {
            st = cnx.createStatement();
            ResultSet results = st.executeQuery(request);

            while (results.next()) {
                Evenements.add(new Evenement(results.getInt("id"), results.getInt("sponsors_id_id"), results.getString("nom_ev"), results.getDate("date_ev"), results.getString("heured_ev"), results.getString("heuref_ev"), results.getInt("etoiles")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Evenements;

    }

    public void modifierEvent(Evenement e) throws SQLException {
        String req = "UPDATE `evenement` SET `sponsors_id_id`=?,`nom_ev`=?,`date_ev`=?,`heured_ev`=?,`heuref_ev`=?,`etoiles`=? WHERE id=? ";
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getSponsors_id_id());
            pst.setString(2, e.getNom_ev());

            pst.setDate(3, (Date) e.getDate_ev());

            pst.setString(4, e.getHeured_ev());
            pst.setString(5, e.getHeuref_ev());
            pst.setInt(6, e.getEtoiles());
             pst.setInt(7, e.getId());

            // java.sql.Date sqlDate=new java.sql.Date(f.getDteAjout().getTime());
            //pst.setDate(4,sqlDate);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
            pst = cnx.prepareStatement(req);
        }

    }

}
