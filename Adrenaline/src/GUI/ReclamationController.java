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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          List<Reclamation> listCom = sc.afficherReclamation();
        nomrec.setCellValueFactory(new PropertyValueFactory<>("nom_r"));
        daterec.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionrec.setCellValueFactory(new PropertyValueFactory<>("description_r"));
        
        
        listCom.forEach((c) -> {
            adminrectv.getItems().add(new Reclamation(c.getNom_r(), c.getDate(), c.getDescription_r()));
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
    private void deleteReclamation(ActionEvent event) throws IOException {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de suppression");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir supprimer cette reclamation ? ");
        Optional<ButtonType> action = alert1.showAndWait();
        if (nomrec.getText().isEmpty()) {
            System.out.println(" Aucun champ n'est selectionné ");
            showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                    " Echec de suppression !  ", " Aucun champ n'a été selectionné! ");
        } else {
            if (action.get() == ButtonType.OK) {

                // alerte confirmation suppression
                sc.supprimerReclamation(new Reclamation(nomrec.getText()));

                root = FXMLLoader.load(getClass().getResource("./Main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Succés de suppression! ", " Suppression de la reclamation établie avec succés! ");

            } else {
                alert1.close();
            }
        }

    }

    @FXML
    private void updateReclamation(ActionEvent event) throws IOException {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de modification");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier cette reclamation ? ");
        Optional<ButtonType> action = alert1.showAndWait();
        if (action.get() == ButtonType.OK) {
            if (nomrec.getText().isEmpty()) {
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur de modification reclamation ! ", " Erreur de modification de la reclamation ! \n Veuillez remplir touts les champs! ");
                adminrectv.getSelectionModel().clearSelection();
                // Alerte de confirmation
            } else {
                sc.modifierReclamation(new Reclamation( nomrec.getText(),daterec.getText(),descriptionrec.getText()));
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
    

