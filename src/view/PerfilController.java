/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.criancaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static view.criancaController.pnome;
import static view.criancaController.posicao;
import static view.criancaController.ss;

/**
 * FXML Controller class q
 *
 * @author User
 */
public class PerfilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView close;
    @FXML
    Label nome;
    @FXML
    TextField sexo, morada, data_nascimento, naturalidade, nome_pai, nome_mae, contacto_pai, contacto_mae, profissao_pai, profissao_mae, nr_bi;
    @FXML
    Button actualizar;
    int codigo, posicao; 
    String apelido,nome1;
    criancaDAO cd;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        close.setOnMouseClicked((MouseEvent event) -> {
            ss.close();

        });

        cd = new criancaDAO();
        posicao = 0;

        for (int i = 0; i < cd.listar().size(); i++) {
            if (cd.listar().get(i).getNome().contains(pnome)) {
                posicao = i;

            }
        }
        apelido = cd.listar().get(posicao).getApelido();
        nome1 = cd.listar().get(posicao).getNome();
        
        nome.setText(cd.listar().get(posicao).getNome() + " " + cd.listar().get(posicao).getApelido());
        sexo.setText(cd.listar().get(posicao).getSexo());
        morada.setText(cd.listar().get(posicao).getMorada());
        data_nascimento.setText(cd.listar().get(posicao).getData_nascimento());
        naturalidade.setText(cd.listar().get(posicao).getNaturidade());
        nome_pai.setText(cd.listar().get(posicao).getNome_pai());
        nome_mae.setText(cd.listar().get(posicao).getNome_mae());
        naturalidade.setText(cd.listar().get(posicao).getNaturidade());
        profissao_mae.setText(cd.listar().get(posicao).getProfissao_mae());
        profissao_pai.setText(cd.listar().get(posicao).getProfissao_pai());
        contacto_mae.setText(String.valueOf(cd.listar().get(posicao).getContacto_mae()));
        nr_bi.setText(String.valueOf(cd.listar().get(posicao).getNr_bi()));
        contacto_pai.setText(String.valueOf(cd.listar().get(posicao).getContaco_pai()));
    }

    @FXML
    private void editarCrianca(ActionEvent ae) {

        sexo.setEditable(true);
        codigo = cd.listar().get(posicao).getCodigo();
        morada.setEditable(true);
        data_nascimento.setEditable(true);
        naturalidade.setEditable(true);
        nome_pai.setEditable(true);
        nome_mae.setEditable(true);
        profissao_pai.setEditable(true);
        profissao_mae.setEditable(true);
        contacto_mae.setEditable(true);
        contacto_pai.setEditable(true);
        nr_bi.setEditable(true);
        actualizar.setStyle("-fx-background-color:cadetblue ");
        FadeTransition transition = new FadeTransition(
                Duration.millis(300), actualizar);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition. setCycleCount(9);
       // transition.setAutoReverse(true);
        transition.play();
    }
    @FXML
    private void actualizarCrianca(){
         actualizar.setStyle("-fx-background-color: transparent ");
          sexo.setEditable(true);

        morada.setEditable(false);
        data_nascimento.setEditable(false);
        naturalidade.setEditable(false);
        nome_pai.setEditable(false);
        nome_mae.setEditable(false);
        profissao_pai.setEditable(false);
        profissao_mae.setEditable(false);
        contacto_mae.setEditable(false);
        contacto_pai.setEditable(false);
        nr_bi.setEditable(false);
        
        int con_mae = Integer.parseInt(contacto_mae.getText());
        int con_pai = Integer.parseInt(contacto_pai.getText());
        
        cd.update(nome1, apelido, naturalidade.getText(), morada.getText(),data_nascimento.getText(), nome_pai.getText()
                , nome_mae.getText(), con_pai, con_mae, sexo.getText(), nr_bi.getText(), profissao_pai.getText()
                , profissao_mae.getText(),codigo);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Dados actualizados com successo!");
        a.show();
        
    }
    }



