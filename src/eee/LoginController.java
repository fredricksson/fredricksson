/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import conect.GerenteDAO;
import static eee.EEE.s;
import static eee.EEE.ss;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    Label close,lb;
    @FXML
    Button acessar;
    @FXML
    TextField utilizador;
    @FXML
    PasswordField senha;
    public static String operador;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilizador.setFocusTraversable(false);
        senha.setFocusTraversable(false);
        acessar.setOnAction((ActionEvent ae) -> {
               lb.setVisible(false);
            GerenteDAO gd = new GerenteDAO();
            if(senha.getText().equals(gd.listar()[1])&& utilizador.getText().equals(gd.listar()[0])){
          s.close();
        TelaPricipal tp = new TelaPricipal();
        operador = utilizador.getText();
            try {
                tp.start(new Stage());
            } catch (Exception ex) {
               // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            }else{
            lb.setVisible(true);
            }
        
        
        
        });
        
        
        close.setOnMouseClicked((MouseEvent me) -> {
        s.close();
        
        
        });
        
        
    }
    
    @FXML 
    public void registar(ActionEvent ae) throws Exception{
        Registo r = new Registo();
        r.start(new Stage());
    }
    
 public class TelaPricipal extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("TelaPrinciplal.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("TelaPrinciplal.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Tela principal");

         
            
       
            stage.show();
        }
    }
 public class Registo extends Application {
     

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("registo.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("registo.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("");

         
            
       
            stage.show();
        }
    }
    
    
}
