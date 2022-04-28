/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Sponsor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;




/**
 *
 * @author GhAlone
 */
public class DataSource {  
   Connection conn=null;

    public static Connection ConnectDb(){
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/adrenaline","root","");
            JOptionPane.showMessageDialog(null,"ConnectionEstablished");
            return conn;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static ObservableList<Sponsor>getDatasponsor(){
        Connection conn = ConnectDb();
        ObservableList<Sponsor> list= FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from sponsor");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            list.add(new Sponsor(Integer.parseInt(rs.getString("id")), rs.getString("nom_sp"), Integer.parseInt(rs.getString("num_sp")), rs.getString("email_sp")));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    }
        
        
   