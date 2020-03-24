/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.FuncionarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import model.Funcionario;
import static view.FuncionarioController.codigoTabela;
import static view.FuncionarioController.ss;

/**
 *
 * @author User
 */
public class DadosFuncionarioController implements Initializable{
     
    
    @FXML
    Label salario;
    @FXML
    TextField codigo,nome,apelido,genero,funcao,data_nascimento,formado_em,cell,morada,estado_civil;
    
    @FXML
    Button editar,actualizar;
    @FXML
    ImageView close;
        FuncionarioDAO fd = new FuncionarioDAO();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    
        ObservableList<Funcionario> fu =fd.listarPersonalizado(codigoTabela);
        
        codigo.setText(""+fu.get(0).getCodigo());
        nome.setText(""+fu.get(0).getNome());
        apelido.setText(""+fu.get(0).getApelido());
        genero.setText(""+fu.get(0).getGenero());
        funcao.setText(""+fu.get(0).getFuncao());
        data_nascimento.setText(""+fu.get(0).getData_nascimento());
        formado_em.setText(""+fu.get(0).getFormada_em());
        cell.setText(""+fu.get(0).getContacto());
        morada.setText(""+fu.get(0).getMorada());
        estado_civil.setText(""+fu.get(0).getEstado_cilvil());
        salario.setText(fu.get(0).getSalario()+".00Mt");
        
        close.setOnMouseClicked((MouseEvent event) -> {
            ss.close();

        });
        
    }
    
     @FXML
    private void editarFuncionario(ActionEvent ae) {

        genero.setEditable(true);
      
        morada.setEditable(true);
        data_nascimento.setEditable(true);
        funcao.setEditable(true);
        formado_em.setEditable(true);
        estado_civil.setEditable(true);
        cell.setEditable(true);
        apelido.setEditable(true);
        nome.setEditable(true);
       

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
    private void actualizarFuncionario(){
         actualizar.setStyle("-fx-background-color: transparent ");
         genero.setEditable(false);
      
        morada.setEditable(false);
        data_nascimento.setEditable(false);
        funcao.setEditable(false);
        formado_em.setEditable(false);
        estado_civil.setEditable(false);
        cell.setEditable(false);
        apelido.setEditable(false);
        nome.setEditable(false);
        int cel = Integer.parseInt(cell.getText());
        int cod = Integer.parseInt(codigo.getText());
        
        fd.update(nome.getText(), apelido.getText(), data_nascimento.getText(), 
                
         formado_em.getText(), funcao.getText(),  genero.getText(), estado_civil.getText(), morada.getText(),cel, cod);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Dados actualizados com successo!");
        a.show();
        
    }
    
}
