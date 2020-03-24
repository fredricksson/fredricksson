/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import conect.GerenteDAO;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.DispesasController;
import static view.FuncionarioController.sfuncionario;
import view.criancaController;

/**
 *
 * @author User
 */
public class EEE extends Application implements Initializable {

    static Stage s = new Stage();
    @FXML
    Button funcionario;
    @FXML
    Button dis,menu;
    @FXML
    Button inscricao, crianca;
    @FXML
    AnchorPane anchor;
    @FXML
    ImageView imdis,imdis1,imdis11,imdis111;
    @FXML
    Label nome_centro;        
    double xOffset = 0;
    int con = 0;
    double yOffset = 0;
    public static Stage ss;

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.

                load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(parent);
        s.setScene(scene);
        s.initStyle(StageStyle.TRANSPARENT);
        s.getIcons().add(new Image("img/c.png"));
        s.show();
        

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     GerenteDAO gd = new GerenteDAO();
        
//        nome_centro.setText( gd.nome_centro());
       
        // TODO
          menu.setOnAction((ActionEvent event) -> {
          
             if(con%2 == 0){
                 anchor.setVisible(false);
               
                 con++;
             }else{
                 anchor.setVisible(true);
                 
                 con++;
             
             }
          
          });
        funcionario.setOnAction((ActionEvent event) -> {
            
                Thread t1 = new Thread() {
                public void run() {

                    try {
                        imdis11.setVisible(true);
                        sleep(1000);
                        imdis11.setVisible(false);
                        s.show();

                    } catch (Exception e) {
                    }

                }
                   };
                   t1.start();
            
            Funcionario f = new Funcionario();
            try {
                Stage s = new Stage();

                sfuncionario.setMaximized(true);
                f.start(sfuncionario);
            } catch (Exception ex) {
                System.out.println(ex.getCause());
                
            }

        });
        dis.setOnAction((ActionEvent event) -> {
            DispesasController d = new DispesasController();
            Stage s = new Stage();

            try {
                d.start(s);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            Thread t = new Thread() {
                public void run() {

                    try {
                        imdis.setVisible(true);
                        sleep(1000);
                        imdis.setVisible(false);
                        s.show();

                    } catch (Exception e) {
                    }

                }

            };
            t.start();

        });

        crianca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                 
                criancaController l = new criancaController();
                 Stage s = new Stage();
                try {
                    l.start( s);
                } catch (Exception ex) {
                }
                Thread t = new Thread() {
                public void run() {

                    try {
                        imdis1.setVisible(true);
                        sleep(1000);
                        imdis1.setVisible(false);
                        s.show();

                    } catch (Exception e) {
                    }

                }

            };
            t.start();  
            }
        });

        inscricao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                   Thread t1 = new Thread() {
                public void run() {

                    try {
                        imdis111.setVisible(true);
                        sleep(1000);
                        imdis111.setVisible(false);
                        s.show();

                    } catch (Exception e) {
                    }

                }
                   };
                   t1.start();
            
                System.out.println("sim");
                try {
                    ss = new Stage();
                    LoginApplication t = new LoginApplication();

                    ss.initModality(Modality.WINDOW_MODAL);
                    ss.initStyle(StageStyle.UNDECORATED);
                    //  new EEE().start(s);
                    ss.initOwner(s);
                    Scene c = new Scene(t.s());
                    ss.setScene(c);
                    t.start(ss);
                    ss.showAndWait();
                } catch (Exception ex) {
                    System.out.println("nao cosegue");
                    System.out.println(ex.getMessage());
                }
            }

        });

    }

    public class Funcionario extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("Funcionario.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("Funcionario.fxml"));
            Scene scene = new Scene(parent);
            sfuncionario.setScene(scene);

            sfuncionario.show();
        }
    }

    public class LoginApplication extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("incricao.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("incricao.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Tela de Login");

            parent.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }
    }

}
