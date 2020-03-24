/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import eee.*;
import conect.MensalidadeDAO;
import conect.criancaDAO;
import eee.EEE;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.Crianca;

/**
 * FXML Controller class
 *
 * @author User
 */
public class IncricaoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView close;
    @FXML
    ComboBox provincia, sexo;
    @FXML
    TextField nome;
    @FXML
    TextField apelido;
    @FXML
    TextField bairro,
            nome_pai,
            nome_mae,
            contacto_pai,
            contacto_mae
            ,codigo,
            profissao_mae,
            profissao_pai,nr_bi;
    @FXML
    DatePicker data_nascimento;
    @FXML
    Button cadastrar;
    criancaDAO cd = new criancaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        provincia.getItems().add("Maputo");
        provincia.getItems().add("Gaza");
        provincia.getItems().add("Inhambane");
        provincia.getItems().add("Beira");
        provincia.getItems().add("sofala");
        provincia.getItems().add("Tete");
        provincia.getItems().add("Zambezia");
        provincia.getItems().add("Pemba");
        provincia.getItems().add("Cabo Delgado");
       
        if(cd.listar().size() > 0){
        int b=cd.listar().get(cd.listar().size()-1).getCodigo()+1;
      
        codigo.setText(""+b);
        }
        sexo.getItems().add("Masculino");
        sexo.getItems().add("Femenino");

        Alert a = new Alert(AlertType.NONE);
        close.setOnMouseClicked((MouseEvent event) -> {
            new EEE().ss.close();
        });
        cadastrar.setOnAction((ActionEvent event) -> {
            int cp = Integer.parseInt(contacto_pai.getText());
            int cm = Integer.parseInt(contacto_mae.getText());
             String bi =nr_bi.getText();
            Crianca crianca = new Crianca(nome.getText(), apelido.getText(), provincia.getSelectionModel().getSelectedItem().toString(), bairro.getText(), data_nascimento.getEditor().getText(), nome_pai.getText(), nome_mae.getText(), cp, cm, sexo.getSelectionModel().getSelectedItem().toString(),bi,profissao_pai.getText(),profissao_mae.getText());
            cd.inserir(crianca);
            int b1=cd.listar().get(cd.listar().size()-1).getCodigo();
            MensalidadeDAO md = new MensalidadeDAO();
            md.inserirCodigo(b1);
            a.setAlertType(AlertType.INFORMATION);

            a.setContentText("  Inscricao succedida!");

            a.show();

        });
    }

}
