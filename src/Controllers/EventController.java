/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author GhAlone
 */
public class EventController implements Initializable {

    @FXML
    private TableView<?> apprenants;
    @FXML
    private TableColumn<?, ?> idev;
    @FXML
    private TableColumn<?, ?> idsp;
    @FXML
    private TableColumn<?, ?> nomev;
    @FXML
    private TableColumn<?, ?> dateev;
    @FXML
    private TableColumn<?, ?> hdebut;
    @FXML
    private TableColumn<?, ?> hfin;
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
    @FXML
    private TextField txt_ev1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
