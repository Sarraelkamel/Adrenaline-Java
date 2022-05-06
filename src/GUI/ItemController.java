/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import models.Equipement;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private ImageView imgItemProduit;
    @FXML
    private Label priceLable;
    @FXML
    private Label IdItem;
    @FXML
    private Label descriptionlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
    }
    
       public void setData(Equipement eq) throws MalformedURLException {
 
        this.nameLabel.setText(eq.getNom_eq());
        this.priceLable.setText(String.valueOf(eq.getPrix_eq()) + " DT");
        this.descriptionlabel.setText(eq.getDesc_eq());
//        this.priceLable.setStrikethrough(true);
        this.IdItem.setText(String.valueOf(eq.getId()));

       Image imn = new Image(
                "file:/" + eq.getImage_eq());
        imgItemProduit.setImage(imn);
        System.out.println("file:/" + eq.getImage_eq());
    }
}
