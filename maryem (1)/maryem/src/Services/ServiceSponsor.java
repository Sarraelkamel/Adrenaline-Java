/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Services;




import Entities.Evenement;
import Entities.Sponsor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;



/**
 *
 * @author GhAlone
 */

public class ServiceSponsor implements SpService<Sponsor> {
    private static ServiceSponsor instance;

    public static ServiceSponsor getInstance() {
         if (instance == null) {
            instance = new ServiceSponsor();
        }
        return instance;
    }
     boolean x;
            
        Connection cnx=DataSource.getInstance().getCnx();

     @Override
    public void ajouter(Sponsor s) {
              try {
                String req ="insert into sponsor (nom_sp,num_sp,email_sp) values (?,?,?)";
                PreparedStatement pst= cnx.prepareStatement(req);
                pst.setString(1, s.getNom_sp());
                pst.setInt(2, s.getNum_sp());
                pst.setString(3, s.getEmail_sp());
                pst.executeUpdate();
                System.out.println("ajout avec succeé");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

   
     @Override
    public void modifier(Sponsor s) {
      try {
                String req="update sponsor set nom_sp=?,num_sp=?,email_sp=? where id=?";
                PreparedStatement pst=cnx.prepareStatement(req);
                pst.setString(1,s.getNom_sp());
                pst.setInt(2,s.getNum_sp());
                pst.setString(3,s.getEmail_sp());
                pst.setInt(4,s.getId());
                pst.executeUpdate();
                System.out.println("modifier");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());      }

    }

    
    public void delete(int id) {
 try {
                    String req="DELETE from sponsor where id=? ";
                    PreparedStatement pst=cnx.prepareStatement(req);
                    pst.setInt(1,id);
                    pst.executeUpdate();
                    System.out.println("deleted");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }    }

    
     @Override
    public List<Sponsor> afficher() {
   List<Sponsor> list =new ArrayList<>();

        try {
            String req = "select * from sponsor" ;
            PreparedStatement pst=cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add
        (new Sponsor(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4)));
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());       } 
        return list;    
    
    }

    
    

    
    
}
    
    
    

 

  
      


