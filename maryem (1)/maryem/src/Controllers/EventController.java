/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Evenement;
import java.net.URL;
//import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Services.ServiceEvenement;
import java.sql.Connection;
//import java.util.Date;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author GhAlone
 */
public class EventController implements Initializable {

    @FXML
    private TableView<Evenement> apprenants;
    @FXML
    private TableColumn<Evenement, Integer> idev;
    @FXML
    private TableColumn<Evenement, Integer> idsp;
    @FXML
    private TableColumn<Evenement, String> nomev;
    @FXML
    private TableColumn<Evenement, Date> dateev;
    @FXML
    private TableColumn<Evenement, String> hdebut;
    @FXML
    private TableColumn<Evenement, String> hfin;
    @FXML
    private Button btn_supp;
    @FXML
    private TextField txt_search;
    @FXML
    private TextField txt_ev;
    @FXML
    private TextField txt_fin;
    @FXML
    private Button btn_ajouter;
    @FXML
    private DatePicker date_ev;
    private TextField myLabel;
    @FXML
    private TextField txt_debut;
    @FXML
    private Label Star1;
    @FXML
    private Label Star2;
    @FXML
    private Label Star4;
    @FXML
    private Label Star3;
    @FXML
    private Label Star5;
    @FXML
    private TextField txt_sp;
    @FXML
    private TableColumn<Evenement, Integer> etoile1;
     java.sql.Connection cnx=DataSource.getInstance().getCnx();
    //ServiceEvenement eventcru = ServiceEvenement.getInstance();

    ObservableList<Evenement> liste1;
    
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
                      afficher();
                
        }
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    
      ObservableList<Evenement> listev;
    ServiceEvenement se=new ServiceEvenement();
    Evenement evenement = null ;
    
    
    static int stars = 0;
    
    
    
    public void afficher(){
        List<Evenement> p1 = se.afficherEvenement();
         liste1=FXCollections.observableArrayList(p1);
       idev.setCellValueFactory(new PropertyValueFactory("id"));
        idsp.setCellValueFactory(new PropertyValueFactory("sponsors_id_id"));   
        nomev.setCellValueFactory(new PropertyValueFactory("nom_ev"));
        dateev.setCellValueFactory(new PropertyValueFactory("date_ev"));
         hdebut.setCellValueFactory(new PropertyValueFactory("heured_ev"));
         hfin.setCellValueFactory(new PropertyValueFactory("heuref_ev"));
         etoile1.setCellValueFactory(new PropertyValueFactory("etoiles"));
         apprenants.setItems(FXCollections.observableArrayList(liste1));
                      
                
    
    
    }
    @FXML
    private void delete(ActionEvent event) {
        Evenement e = apprenants.getSelectionModel().getSelectedItem();
        se.supprimerevent(e.getNom_ev());
                              

        afficher();
    }

    @FXML
    private void click(ActionEvent event) throws Exception{
        Evenement e=new Evenement(apprenants.getSelectionModel().getSelectedItem().getId(),Integer.parseInt(txt_sp.getText()),txt_ev.getText(),Date.valueOf(date_ev.getValue()),txt_debut.getText(),txt_fin.getText().trim(),stars);
       se.modifierEvent(e);
       afficher();
        
        
        
        //Star1.getText(),Star2.getText(),Star3.getText(),Star4.getText(),Star5.getText()
        
    }
    private void actualisé(ActionEvent event) {
         try {
            listev.clear();
            
             String query = "SELECT * FROM `evenement`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                listev.add(new  Evenement(
                        resultSet.getInt("id"),
                        resultSet.getInt("sponsors_id_id"),
                        resultSet.getString("nom_ev"),
                        resultSet.getDate("date_ev"),
                        resultSet.getString("heured_ev"),
                        resultSet.getString("heuref_ev"),
                        resultSet.getInt("etoiles")));
                apprenants.setItems(listev);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    

    @FXML
    private void ajouter(ActionEvent event) {
        ServiceEvenement se = new ServiceEvenement();
        int sponsor = Integer.valueOf(txt_sp.getText().trim());
        Date date = Date.valueOf(date_ev.getValue());
        Evenement e = new Evenement(sponsor, txt_ev.getText().trim(), date, txt_debut.getText().trim(), txt_fin.getText().trim(), stars);
        se.ajouterEvent(e);
        //sendSMS sm = new sendSMS();
           // sm.sendSMS();

    }
    

    @FXML
    public void handlestar5() {
        Star5.setOpacity(1);
        Star4.setOpacity(1);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 5;
    }

    @FXML
    public void handlestar4() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(1);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 4;
    }

    @FXML
    public void handlestar3() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(1);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 3;
    }

    @FXML
    public void handlestar2() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(0.4);
        Star2.setOpacity(1);
        Star1.setOpacity(1);
        stars = 2;
    }

    @FXML
    public void handlestar1() {
        Star5.setOpacity(0.4);
        Star4.setOpacity(0.4);
        Star3.setOpacity(0.4);
        Star2.setOpacity(0.4);
        Star1.setOpacity(1);
        stars = 1;
    }

}
