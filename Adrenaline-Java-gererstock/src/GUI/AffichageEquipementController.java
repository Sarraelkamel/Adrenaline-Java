/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Icategorie;
import interfaces.Iequipement;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import models.Categorie;
import models.Equipement;
import services.ServiceCategorie;
import services.ServiceEquipement;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AffichageEquipementController implements Initializable {

    @FXML
    private TextField chercherMagasin;
    @FXML
    private ComboBox<String> comboCat;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    Iequipement sp = new ServiceEquipement();
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Icategorie sc = new ServiceCategorie();
        List<Categorie> Categories = sc.afficherCategorie();
        Categories.forEach(
                (c) -> {
                    comboCat.getItems().add(c.getNom_ca());
                }
                
        );
    Iequipement sp = new ServiceEquipement();
        List<Equipement> eqs = sp.afficherEquipement();
        try {
            afficherEquipementsMag(eqs);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
        
        public void afficherEquipementsMag(List<Equipement> eqs) throws IOException {
            
        int column = 0;
        int row = 1;
        
        try{
        for (int i = 0; i < eqs.size(); i++) {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("itemEquipement.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemController itemController = fxmlLoader.getController();

            itemController.setData(eqs.get(i));

            if (column == 2) {
                column = 0;
                row++;
            }

            grid.add(anchorPane, column++, row); //(child,column,row)
            //set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);

            //set grid height
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchorPane, new Insets(10));
        }
            }catch(IOException ex){
                     ex.printStackTrace();
                    }
    }    
        

    
    @FXML
    private void chercherProduitsMag(KeyEvent event) throws IOException {
         grid.getChildren().clear();
        List<Equipement> p = sp.afficherEquipement();
        System.out.println(p);
        afficherEquipementsMag(sp.chercherProduitDynamiquement(chercherMagasin.getText(), p));
    }

    @FXML
    private void clearSelection(MouseEvent event) throws IOException {
        
  
        
    }

    @FXML
    private void trierCat(ActionEvent event) throws IOException {
 List<Equipement> p = sp.afficherEquipement();
        System.out.println(p);
        afficherEquipementsMag(sp.chercherProduitDynamiquement(comboCat.getValue(), p));
        grid.getChildren().clear(); // change pictures' names not to include 
        afficherEquipementsMag(sp.chercherProduitDynamiquement(comboCat.getValue(), p));
    }
    
    @FXML
    private void switchToItemInt(MouseEvent event) {
    }
    
      private Equipement getDataFromScene(Parent scene) {
        Equipement p = new Equipement();
        Label IdItem = (Label) scene.lookup("#IdItem");
        p.setId(Integer.parseInt(IdItem.getText()));
        return p;
    }

}
