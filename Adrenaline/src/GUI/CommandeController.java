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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<?, ?> Action;
    @FXML
    private Button btn_deletecommande;
    @FXML
    private TableColumn<?, ?> idcom;
    @FXML
    private Button btn_updatecmd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

        // Old AFFICHAGE + without selection here
        List<Commande> listCom = sc.afficherCommande();
        nomcom.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
        datecom.setCellValueFactory(new PropertyValueFactory<>("date"));
        prixcom.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quancom.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        
        listCom.forEach((c) -> {
            admincmdtv.getItems().add(new Commande(c.getNom_c(), c.getDate(), c.getPrix(),c.getQuantite()));
        });
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
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de suppression");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir supprimer cette commende ? ");
        Optional<ButtonType> action = alert1.showAndWait();
        if (nomcom.getText().isEmpty()) {
            System.out.println(" Aucun champ n'est selectionné ");
            showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                    " Echec de suppression !  ", " Aucun champ n'a été selectionné! ");
        } else {
            if (action.get() == ButtonType.OK) {

                // alerte confirmation suppression
                sc.supprimerCommande(new Commande(nomcom.getText()));

                root = FXMLLoader.load(getClass().getResource("./Main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Succés de suppression! ", " Suppression de la commande établie avec succés! ");

            } else {
                alert1.close();
            }
        }

    }
    
    
    
    
    
    
    
     @FXML
    private void updateCommande(ActionEvent event) throws IOException {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de modification");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier cette commande ? ");
        Optional<ButtonType> action = alert1.showAndWait();
        if (action.get() == ButtonType.OK) {
            if (nomcom.getText().isEmpty()) {
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur de modification commande ! ", " Erreur de modification de la commande ! \n Veuillez remplir touts les champs! ");
                admincmdtv.getSelectionModel().clearSelection();
                // Alerte de confirmation
            } else {
                sc.modifierCommande(new Commande( nomcom.getText(),(Integer.parseInt(prixcom.getText())),(Integer.parseInt(quancom.getText())),(Integer.parseInt(idcom.getText()))));
                root = FXMLLoader.load(getClass().getResource("./Main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Succés de modification! ", " Modification de la commande établie avec succés! ");
            }
        } else {
            alert1.close();
        }
    }
    
}
