/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Sponsor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author GhAlone
 */
public class SponsorController implements Initializable {

    @FXML
    private TableView <Sponsor> apprenants;

    @FXML
    private TableColumn<Sponsor,Integer> idsp;
    @FXML
    private TableColumn<Sponsor,String> nomsp;
    @FXML
    private TableColumn<Sponsor,Integer> numsp;
    @FXML
    private TableColumn<Sponsor,String> emailsp;
    @FXML
    private Button btn_supp;
    @FXML
    private TextField txt_search;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_num;
    @FXML
    private TextField txt_email;
    @FXML
    private Button btn_ajouter;

    ObservableList<Sponsor>listSp;
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst=null;
    
    
    
    
    /**
     * Initializes the controller class.
  
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idsp.setCellFactory(new PropertyValueFactory("id"));
        nomsp.setCellFactory(new PropertyValueFactory("nom_sp"));
        numsp.setCellFactory(new PropertyValueFactory("num_sp"));
        emailsp.setCellFactory(new PropertyValueFactory("email_sp"));

    listSp = DataSource.getDatasponsor();
    apprenants.setItems(listSp);
    
    }
    @FXML
    private void delete(ActionEvent event) {  
    
    }

    @FXML
    private void click(ActionEvent event) {
    }

    @FXML
    private void reload(MouseEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    
}
