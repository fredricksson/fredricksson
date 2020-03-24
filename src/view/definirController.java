/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.PrecoMensalidadeDAO;
import conect.criancaDAO;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.TextFields;
import static view.criancaController.ss;

/**
 *
 * @author User
 */
public class definirController implements Initializable {

    @FXML
    ImageView close;
    @FXML
    Button definir;
    @FXML
    TextField mensalidade, inscricao;
    @FXML
    Label lb1, lb2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        definir.setOnAction((ActionEvent) -> {
            Alert a = new Alert(Alert.AlertType.NONE);
            lb1.setVisible(false);
            lb2.setVisible(false);
            PrecoMensalidadeDAO pm = new PrecoMensalidadeDAO();
            if(pm.getMensalidade() == 0){
            if (!mensalidade.getText().isEmpty() && !inscricao.getText().isEmpty()) {
                try {

                    int mens = Integer.parseInt(mensalidade.getText());
                    int ins = Integer.parseInt(inscricao.getText());
                    pm.inserir(mens, ins);
                    a.setContentText("Mensalidade defida com sucesso!");
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.show();
                    
                   
                } catch (NumberFormatException e) {
                    lb1.setVisible(true);
                    lb2.setVisible(true);

                }
            }
            }else{
                a.setAlertType(Alert.AlertType.ERROR);
                a.show();
               
            }

        });

        close.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("SIM");
            ss.close();

        });

    }

}
