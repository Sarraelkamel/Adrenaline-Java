/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Sponsor;
import Services.ServiceSponsor;
import Services.SpService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author GhAlone
 */
public class SponsorController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    SpService sc = new ServiceSponsor();

    @FXML
    private TableView<Sponsor> apprenants;

    @FXML
    private TableColumn<Sponsor, Integer> idsp;
    @FXML
    private TableColumn<Sponsor, String> nomsp;
    @FXML
    private TableColumn<Sponsor, Integer> numsp;
    @FXML
    private TableColumn<Sponsor, String> emailsp;
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
    java.sql.Connection cnx = DataSource.getInstance().getCnx();

    ObservableList<Sponsor> listSp;
    ObservableList<Sponsor> liste2;

    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();

    }

    ServiceSponsor eventcru = ServiceSponsor.getInstance();
    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void afficher() {
        List<Sponsor> listCom = sc.afficher();
        liste2 = FXCollections.observableArrayList(listCom);
        idsp.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomsp.setCellValueFactory(new PropertyValueFactory<>("nom_sp"));
        numsp.setCellValueFactory(new PropertyValueFactory<>("num_sp"));
        emailsp.setCellValueFactory(new PropertyValueFactory<>("email_sp"));
        apprenants.setItems(FXCollections.observableArrayList(liste2));

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
    private void delete(ActionEvent event) throws IOException {
        Sponsor s = apprenants.getSelectionModel().getSelectedItem();
        eventcru.delete(s.getId());

        afficher();
    }

    @FXML
    private void click(ActionEvent event) throws IOException {
        
        Sponsor e = new Sponsor(apprenants.getSelectionModel().getSelectedItem().getId(), txt_nom.getText(),Integer.valueOf(txt_num.getText()),txt_email.getText());
        eventcru.modifier(e);
        afficher();

    }

    @FXML
    private void reload(MouseEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
        if (txt_nom.getText().isEmpty() || txt_num.getText().isEmpty() || txt_email.getText().isEmpty()) {

            System.out.println("erreur");
            // show.setText("Enter all details");

        } else {
            String nom_event = txt_nom.getText();
            int num = parseInt(txt_num.getText());
            String obj = txt_email.getText();

            ZoneId defaultZoneId = ZoneId.systemDefault();

            Sponsor ev = new Sponsor(nom_event, num, obj);
            eventcru.ajouter(ev);

            //ArrayList<String> etud = (ArrayList<String>) pr.displayAllStudnt();
        }
    }
}
