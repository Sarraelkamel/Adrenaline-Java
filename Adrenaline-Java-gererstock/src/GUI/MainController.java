/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author sarra
 */
public class MainController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane grid;
    @FXML
    private Button dashboard;
    @FXML
    private ImageView top;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         dashboard.setVisible(true);
        // TODO
    }    

    @FXML
    private void switchToProfil(ActionEvent event) {
    }

    @FXML
    private void switchToDashboard(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Dashboard.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void switchToTop(ActionEvent event) {       
        try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TopEquipements.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void switchToCommande(ActionEvent event) {
//         try {
//            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);
//
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("Commande.fxml"));
//
//            AnchorPane anchorPane;
//            anchorPane = fxmlLoader.load();
//
//            grid.add(anchorPane, 0, 1);
//            //rid.add(anchorPane, 0, 1);
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    @FXML
    private void switchToCategorie(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("addCategoryInterface.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToReclamation(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Reclamation.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToEquipementaff(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("affichageEquipement.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToGesequi(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AddEquipementInterface.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToevent(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AddEquipementInterface.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchTospon(ActionEvent event) {
         try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AddEquipementInterface.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToComma(ActionEvent event) {
          try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Commande.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();

            grid.add(anchorPane, 0, 1);
            //rid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
