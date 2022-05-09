/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Ireclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Reclamation;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author sarra
 */
public class ReclamationController implements Initializable {

     private Stage stage;
    private Scene scene;
    private Parent root;

    Ireclamation sc = new ServiceReclamation();
    
    @FXML
    private TableColumn<Reclamation, String> nomrec;
    @FXML
    private TableColumn<Reclamation, Date> daterec;
    @FXML
    private TableColumn<Reclamation, String> descriptionrec;
    @FXML
    private Button btn_deleterec;
    @FXML
    private Button btn_updaterec;
    @FXML
    private TableView<Reclamation> adminrectv;
    ObservableList<Reclamation> list1;
    @FXML
    private TextField nf;
    @FXML
    private TextField df;
    @FXML
    private TextField tna;
    @FXML
    private TextField tda;
    @FXML
    private DatePicker da;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Label combo;
    @FXML
    private TextField idc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          afficher();
        
        
        
    }    

    
    
    
         
    
    public void afficher(){
         List<Reclamation> listCom = sc.afficherReclamation();
         list1 = FXCollections.observableArrayList(listCom);
        nomrec.setCellValueFactory(new PropertyValueFactory<>("nom_r"));
        daterec.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionrec.setCellValueFactory(new PropertyValueFactory<>("description_r"));
        adminrectv.setItems(FXCollections.observableArrayList(list1));
    }
    
    
    
    
     private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    
    
    
   
     
    
    @FXML
    private void deleteReclamation(ActionEvent event) throws IOException {
        Reclamation r = adminrectv.getSelectionModel().getSelectedItem();
        sc.supprimerReclamation(r);
        afficher();

    }

    @FXML
    private void updateReclamation(ActionEvent event) throws IOException {
         Reclamation r = new Reclamation(nf.getText(),df.getText(),adminrectv.getSelectionModel().getSelectedItem().getId_rec());
    
        sc.modifierReclamation(r);
        afficher();
    }
   

    @FXML
    private void ajouterReclamation(ActionEvent event) {
        
        ServiceReclamation sr = new ServiceReclamation();
        int Commande = Integer.valueOf(idc.getText().trim());
        Date date = Date.valueOf(da.getValue());
        Reclamation r = new Reclamation(tna.getText().trim(), date, tda.getText().trim(),Integer.parseInt(idc.getText().trim()) );
        sr.ajouterReclamation(r);
        afficher();
    }
    
    }
    

