/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Icommande;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Commande;
import services.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author sarra
 */
public class CommandeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Icommande sc = new ServiceCommande();

    @FXML
    private TableColumn<Commande, String> nomcom;
    @FXML
    private TableColumn<Commande, Date> datecom;
    @FXML
    private TableColumn<Commande, Integer> prixcom;
    @FXML
    private TableColumn<Commande, Integer> quancom;
    @FXML
    private TableColumn<Commande, Integer> PrTotal;
    @FXML
    private TableView<Commande> admincmdtv;
    @FXML
    private Button btn_deletecommande;
    @FXML
    private Button btn_updatecmd;
    @FXML
    private Label label_insert_id;
    @FXML
    private TextField id_commandetf;
    @FXML
    private TableColumn<Commande, Integer> idcommande;
    @FXML
    private TextField nomcmdtf;
    @FXML
    private TextField datecmdtf;
    @FXML
    private TextField prixcmdtf;
    @FXML
    private TextField quantitecmdtf;

    ObservableList<Commande> list1;
    @FXML
    private TextField nf;
    @FXML
    private TextField pf;
    @FXML
    private TextField qf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        admincmdtv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable , Object oldValue , Object newValue){
                if(admincmdtv.getSelectionModel().getSelectedItem() != null){
                    Commande SelectedCommande = admincmdtv.getSelectionModel().getSelectedItem();
                    id_commandetf.setText(String.valueOf(SelectedCommande.getId()));
                    nomcmdtf.setText(SelectedCommande.getNom_c());
                     String e = String.valueOf(SelectedCommande.getQuantite());
                    quantitecmdtf.setText(e);
                    String z = String.valueOf(SelectedCommande.getPrix());
                    prixcmdtf.setText(z);
                    datecmdtf.setText(String.valueOf(SelectedCommande.getDate()));
                }
                else {
                    admincmdtv.getSelectionModel().clearSelection();
                } 
            }
        });

        
        afficher();
    } 
    
    
    
    
    
    
    public void  afficher(){
       
          List<Commande> listCom = sc.afficherCommande();
          list1 = FXCollections.observableArrayList(listCom);
        nomcom.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
        datecom.setCellValueFactory(new PropertyValueFactory<>("date"));
        prixcom.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quancom.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        idcommande.setCellValueFactory(new PropertyValueFactory<>("id"));
         admincmdtv.setItems(FXCollections.observableArrayList(list1));
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
    private void deleteCommande(ActionEvent event) throws IOException {
      
        Commande c = admincmdtv.getSelectionModel().getSelectedItem();
        sc.supprimerCommande(c);
        afficher();
        

    }
    
    
    
     @FXML
    private void updateCommande(ActionEvent event) throws IOException {
        Commande c = new Commande(nf.getText(),Integer.parseInt(pf.getText()),Integer.parseInt(qf.getText()),admincmdtv.getSelectionModel().getSelectedItem().getId());
    
        sc.modifierCommande(c);
        afficher();
    }
    public void ajouterCommande (Commande c){
        
    }
}
