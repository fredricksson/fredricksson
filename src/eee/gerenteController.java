/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import conect.GerenteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author User
 */
public class gerenteController implements Initializable {

    @FXML
    PasswordField senha, senha2;
    @FXML
    TextField nome, nome_centro;
    @FXML
    Label v1, v2, v3, v4, cv;
    @FXML
    Button cadastrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nome = TextFields.createClearableTextField();
    }

    @FXML
    public void cadastro(ActionEvent ae) {
        v3.setVisible(false);
        v2.setVisible(false);
        v1.setVisible(false);
        v4.setVisible(false);
        cv.setVisible(false);
        if (senha.getText().isEmpty()) {
            v3.setVisible(true);
            cv.setVisible(true);
        }
        if (senha2.getText().isEmpty()) {
            v4.setVisible(true);
            cv.setVisible(true);
        }
        if (nome.getText().isEmpty()) {
            v2.setVisible(true);
            cv.setVisible(true);
        }
        if (nome_centro.getText().isEmpty()) {
            v1.setVisible(true);
            cv.setVisible(true);
        }
        GerenteDAO gd = new GerenteDAO();
        System.out.println("agora "+gd.listar()[0].isEmpty());
        if (gd.listar()[0].isEmpty()) {

            if (!senha.getText().isEmpty() && !senha2.getText().isEmpty() && !nome.getText().isEmpty() && !nome_centro.getText().isEmpty()) {
                if (senha.getText().equals(senha2.getText())) {

                    gd.inserir(nome.getText().trim(), nome_centro.getText().trim(), senha.getText().trim());
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Cadastro succedido!");
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("palavras-passes diferentes");
                    a.show();
                }
            }
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("ja existe um Director!");
            a.show();
        }
    }
}
