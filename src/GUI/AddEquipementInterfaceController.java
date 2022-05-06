/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.Icategorie;
import interfaces.Iequipement;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Categorie;
import models.Equipement;
import models.jointCategorie;
import services.ServiceCategorie;
import services.ServiceEquipement;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AddEquipementInterfaceController implements Initializable {
       private Stage stage;
    private Scene scene;
    private Parent root;
    private final ObservableList<Equipement> obsProduit = FXCollections.observableArrayList();
    Iequipement sp = new ServiceEquipement();
   
    List<Equipement> listProd = sp.afficherEquipement();

    // Fichier de l'image
    File selectedFile;
    private String path;
    

    @FXML
    private AnchorPane anchorFormulaire;
       @FXML
    private TextField id;
    @FXML
    private TableView<jointCategorie> productsTV;
    @FXML
    private TableColumn<jointCategorie, String> colNomEquipement;
    @FXML
    private TableColumn<jointCategorie, String> colCategorie;
    @FXML
    private TableColumn<jointCategorie, Integer> colPrix;
    @FXML
    private TableColumn<jointCategorie, String> colDescription;
    @FXML
    private TableColumn<jointCategorie, Integer> colQuantite;
    @FXML
    private TableColumn<jointCategorie, Integer> colIdProd;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnModif;
    @FXML
    private Button btn_retour;
    @FXML
    private Button btnSuppression;
    @FXML
    private ImageView screenshotView;
    @FXML
    private TextField nomEquipementTF;
    @FXML
    private ComboBox comboBoxCat;
    @FXML
    private TextField prixTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField quantiteTF;
    @FXML
    private Button image;
    @FXML
    private TextField id_Produit;

    
    
        
      private boolean showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        // Désactivation des boutons
////        btnModif.setDisable(true);
//        btnSuppression.setDisable(true);
////        btnqr.setDisable(true);
//      anchorFormulaire.setOpacity(0);
        List<Equipement> prodDataBase = sp.afficherEquipement();
        Equipement p2 = new Equipement();

        // Méthode de séléction d'un élement du TV aprés clique sur le curseur
        productsTV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (productsTV.getSelectionModel().getSelectedItem() != null) {
                    jointCategorie selectedEquipement = productsTV.getSelectionModel().getSelectedItem();
//                    System.out.println(selectedProduit);
                    id.setText(String.valueOf(selectedEquipement.getIdEquip()));
                    nomEquipementTF.setText(selectedEquipement.getNomEquip());
                     String e = String.valueOf(selectedEquipement.getQuantiteEquip());
                    quantiteTF.setText(e);
                    
                    comboBoxCat.setValue(selectedEquipement.getNomCat());
                    String z = String.valueOf(selectedEquipement.getPrixEquip());
                    prixTF.setText(z);
                    descriptionTF.setText(selectedEquipement.getDescriptionEquip());
                   

  //              image.setselectedEquipement(selectedEquipement.getImage()));
//                    int index = selectedProduit.getUser().toString().indexOf("email");
//                    int indexlast = selectedProduit.getUser().toString().indexOf(", password");
                  

//                    selectedEquipement.setImage(selectedEquipement.getImage());
//                    (image.getContentDisplay(selectedEquipement.getImage());
                } else {
                    productsTV.getSelectionModel().clearSelection();

                }
            }
        }
        );

        // Affichage du combo box 1 : Catégories combo box
        Icategorie sc = new ServiceCategorie();
        List<Categorie> Categories = sc.afficherCategorie();
        Categories.forEach(
                (c) -> {
                    comboBoxCat.getItems().add(c.getNom_ca());
                }
        );
        // Affichage du combo box 2 : ID + Email fournisseur Combo box
       
        afficherEquips("");
        // TODO
    }    
    
    public void afficherEquips(String input) {
        
//        listProd = sp.chercherProduitDynamiquement(input, sp.afficherProduit());
        Icategorie c = new ServiceCategorie();

// Affichge des attributs produits
        colNomEquipement.setCellValueFactory(
                new PropertyValueFactory<>("nomEquip"));
       
        colCategorie.setCellValueFactory(
                new PropertyValueFactory<>("NomCat"));
        colPrix.setCellValueFactory(
                new PropertyValueFactory<>("PrixEquip"));
        colDescription.setCellValueFactory(
                new PropertyValueFactory<>("descriptionEquip"));
            colQuantite.setCellValueFactory(
                new PropertyValueFactory<>("QuantiteEquip"));
        
        colIdProd.setCellValueFactory(
                new PropertyValueFactory<>("idEquip"));
        listProd.forEach(
                (p) -> {
                    productsTV.getItems().addAll(
                            new jointCategorie(p.getId(),p.getNom_eq(), p.getCategorie().getNom_ca(), p.getPrix_eq(),
                                    p.getDesc_eq(), p.getQuantite_eq())
                    );

           
            });
                }
     

    

       @FXML
    private void ajouterEquipementAction(ActionEvent event)  throws IOException {
        Iequipement sp = new ServiceEquipement();
       
        Icategorie sc = new ServiceCategorie();

        // Affichage d'une alerte de confirmation
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir ajouter ce produit ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            // Controle de saisie
            if ((nomEquipementTF.getText().isEmpty())
                    || (comboBoxCat.getValue() == null)
                    
                    || (prixTF.getText().isEmpty())
                    || (descriptionTF.getText().isEmpty())
                   
                    || (quantiteTF.getText().isEmpty())
                    || (selectedFile == null)
                    ) { // ajout des produits
                 
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur d'ajout du produit ! ", " Erreur d'ajout! \n Veuillez remplir touts les champs! ");
            } else {
                 sp.ajouterEquipement(new Equipement(nomEquipementTF.getText(),
                        sc.retrieveCategorie(String.valueOf(comboBoxCat.getValue())),
                        Integer.parseInt(prixTF.getText()),
                        descriptionTF.getText(),
                       Integer.parseInt(quantiteTF.getText()) ,
                
                             selectedFile.getAbsolutePath().replace("\\", "/")));

                // ajout<<
                root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Ajouter Equipement ! ","");
            }

        } else {
            alert1.close();
        }
    }

       @FXML
    private void modifierEquipementAction(ActionEvent event) throws IOException {
      
        Iequipement sp = new ServiceEquipement();
        Icategorie sc = new ServiceCategorie();

        // Alerte de confirmation de modification
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier ce equipement ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            if ((nomEquipementTF.getText().isEmpty())
                    || (comboBoxCat.getValue() == null)
                 
                    || (prixTF.getText().isEmpty())
                    || (descriptionTF.getText().isEmpty())
                    ||  (quantiteTF.getText().isEmpty())
                    ) { // ajout des produits
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur de modification ! ", " Erreur de modification! \n Veuillez remplir touts les champs! ");
            } else {
                sp.modifierEquipement(new Equipement(Integer.parseInt(id.getText()), nomEquipementTF.getText(),
                         
                        sc.retrieveCategorie((String) comboBoxCat.getValue()),
                        Integer.parseInt(prixTF.getText()),
                        descriptionTF.getText(),                
                       Integer.parseInt(quantiteTF.getText()) ));

             
                root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Succés! ", " Modification d'equipement établie avec succés! ");
            }
        } else {
          }
        }

    
 
 
 
 
    

    @FXML
    private void switchTo(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("./Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

       @FXML
    private void supprimerEquipementAction(ActionEvent event) throws IOException {
        Icategorie sc = new ServiceCategorie();
        // Alerte de confirmation du suppression
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir supprimer ce equipement ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            Equipement e = new Equipement(Integer.parseInt(id.getText()), nomEquipementTF.getText(), Integer.parseInt(prixTF.getText()),descriptionTF.getText() ,
                     Integer.parseInt(quantiteTF.getText()));
          
           sp.supprimerEquipement(e);
            root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                    " Succés de suppression ! ", " Suppression du Equipement établie avec succés! ");
//        } else {
//            alert1.close();
//        }
        }
        
        
    }

    @FXML
    private void image(ActionEvent event)  throws MalformedURLException {

        FileChooser fc = new FileChooser();
        fc.setTitle("Veuillez choisir l'image du produit en question ");
        String userDirectoryString = System.getProperty("user.home") + "/Desktop";
        File userDirectory = new File(userDirectoryString);
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            path = selectedFile.getName();
            // Affichage dans une liste view invisible
            screenshotView.setImage(new Image(selectedFile.toURI().toURL().toString()));
            screenshotView.setFitHeight(150);
            screenshotView.setFitWidth(250);
            image.setText(path);
            System.out.println(selectedFile.getAbsolutePath());

//            String req = "INSERT into produit SET image= '" + selectedFile.getAbsolutePath().replace("/", "/")+"' WHERE id_produit = " + p.getId_produit() + " ";
//
//                Statement st = cnx.createStatement();
//                st.executeUpdate(req);
        }
    }

    @FXML
    private void clearonWhiteSpace(MouseEvent event) {
        
        id.setText("");
        nomEquipementTF.setText("");
       
        comboBoxCat.setValue("");
        prixTF.setText("");
        descriptionTF.setText("");
       
        quantiteTF.setText("");

    }

    private void ajouterProduitAction(ActionEvent event) throws IOException {
        Iequipement sp = new ServiceEquipement();
       
        Icategorie sc = new ServiceCategorie();

        // Affichage d'une alerte de confirmation
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir ajouter ce equipement ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            // Controle de saisie
            if ((nomEquipementTF.getText().isEmpty())
                    || (comboBoxCat.getValue() == null)
                    
                    || (prixTF.getText().isEmpty())
                    || (descriptionTF.getText().isEmpty())
                   
                    || (quantiteTF.getText().isEmpty())
                    || (selectedFile == null)) { // ajout des produits
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur d'ajout d'equipement ! ", " Erreur d'ajout! \n Veuillez remplir touts les champs! ");
            } else {
                 sp.ajouterEquipement(new Equipement(nomEquipementTF.getText(),
                        sc.retrieveCategorie((String) comboBoxCat.getValue()),
                        Integer.parseInt(prixTF.getText()),
                        descriptionTF.getText(),
                       Integer.parseInt(quantiteTF.getText()) ));
                
                             this.image.getText();

                // ajout<<
                root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Ajouter equipement ! ","");
            }

        } else {
            alert1.close();
        }
    }

    private void modifierProduitAction(ActionEvent event)  throws IOException {
      
        Iequipement sp = new ServiceEquipement();
        Icategorie sc = new ServiceCategorie();

        // Alerte de confirmation de modification
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir modifier ce equipement ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            if ((nomEquipementTF.getText().isEmpty())
                    || (comboBoxCat.getValue() == null)
                 
                    || (prixTF.getText().isEmpty())
                    || (descriptionTF.getText().isEmpty())
                    ||  (quantiteTF.getText().isEmpty())
                    ) { // ajout des produits
                System.out.println("valeur null");
                showAlert(Alert.AlertType.ERROR, ((Node) event.getSource()).getScene().getWindow(),
                        " Erreur de modification ! ", " Erreur de modification! \n Veuillez remplir touts les champs! ");
            } else {
                sp.modifierEquipement(new Equipement(Integer.parseInt(id.getText()), nomEquipementTF.getText(),
                         
                        sc.retrieveCategorie((String) comboBoxCat.getValue()),
                        Integer.parseInt(prixTF.getText()),
                        descriptionTF.getText(),                
                       Integer.parseInt(quantiteTF.getText()) ));

             
                root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                        " Succés! ", " Modification d'equipement établie avec succés! ");
            }
        } else {
          }
    }

    private void supprimerProduitAction(ActionEvent event)throws IOException {
        Icategorie sc = new ServiceCategorie();
        // Alerte de confirmation du suppression
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation d'ajout");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir supprimer ce equipement ? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            sp.supprimerEquipement(new Equipement(Integer.parseInt(id.getText()), nomEquipementTF.getText(),
                    sc.retrieveCategorie((String) comboBoxCat.getValue()),
                    Integer.parseInt(prixTF.getText()),
                    descriptionTF.getText() ,
                     Integer.parseInt(quantiteTF.getText()))
            );
            root = FXMLLoader.load(getClass().getResource("AddEquipementInterface.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            showAlert(Alert.AlertType.INFORMATION, ((Node) event.getSource()).getScene().getWindow(),
                    " Succés de suppression ! ", " Suppression d'equipement établie avec succés! ");
//        } else {
//            alert1.close();
//        }
        }
    }
    
}
