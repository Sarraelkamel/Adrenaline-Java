package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.Evenement;
import Entities.Sponsor;
import Services.ServiceEvenement;
import Services.ServiceSponsor;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author GhAlone
 */
public class Main {


    
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say Hello World");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //ServiceSponsor sp = new ServiceSponsor();
        //System.out.println(sp.ajouter(new Sponsor("ghassen",22343444,"HGHGH@gmail.com")));
        //sp.modifier(new Sponsor(2,"ghassen",545646,"ljk@hj"));
        //sp.ajouter(new Sponsor("gahssen",45644,"dqjksh@qsdb"));
        //sp2.changer_pass(new Utilisateur(2,"ghassen"));
      //System.out.println(sp.afficher());
        //ServiceAdmin sa2= new ServiceAdmin();
        //System.out.println(sa2.connecter(new Utilisateur("ghassen","ghg","Admin")));
        //sa2.modifier(new Utilisateur(1,"lmcwxklmk","wcvx",545646,"ljdkaz","wom","ljk@hj","bgbb","azdhjkahzdlkjazm"));
        //System.out.println(sa2.afficher());
        //sp.delete(new Sponsor(2));
        /////////////////////////////////////////
        ServiceEvenement e = new ServiceEvenement();
        //System.out.println(e.ajouter(new Sponsor("ghassen",22343444,"HGHGH@gmail.com")));
        System.out.println(e.afficherEvenement());
        //e.ajouterEvent(new Evenement("turki","12/02/2000","12:00:00","13:00:00"));
      //  e.modifierEvent(new Evenement(2,"ghassen","13/02/2018","15:00:00","17:00:00"));
        
    }
    
}