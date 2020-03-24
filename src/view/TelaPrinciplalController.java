/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import eee.EEE;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TelaPrinciplalController implements Initializable {

    @FXML
    Button inscricao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inscricao.setOnAction((ActionEvent event) -> {
            try {
                LoginApplication t = new LoginApplication();
                Stage s = new Stage();
                s.initModality(Modality.WINDOW_MODAL);
                s.initStyle(StageStyle.UNDECORATED);
                //  new EEE().start(s);
                s.initOwner(s);
                Scene c = new Scene(t.s());
                s.setScene(c);
                t.start(s);
                s.showAndWait();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        
        
    } 
      public class LoginApplication extends Application {
      Parent parent;
      public Parent s() throws IOException{
       return parent = FXMLLoader.
                load(getClass().getResource("../view/incricao.fxml"));
      }
    @Override
    public void start(Stage stage) throws Exception {
       parent = FXMLLoader.
                load(getClass().getResource("../view/incricao.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
         stage.setOpacity(0.5);
        
        stage.show();
    }
    }
   
    
}
