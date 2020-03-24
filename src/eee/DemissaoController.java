/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import view.*;
import conect.DemissaoDAO;
import conect.FuncionarioDAO;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import static eee.FuncionarioController.ss;

/**
 *
 * @author User
 */
public class DemissaoController implements Initializable{
    @FXML
    ImageView close;
    @FXML
    TextField nome;
    @FXML
    TextArea motivo;
    @FXML
    Button demitir;
    
    FuncionarioDAO fd;
    DemissaoDAO dd;
      Set<String> pws = new HashSet<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fd = new FuncionarioDAO();
        dd = new DemissaoDAO();
        demitir.setOnAction((ActionEvent ae)-> {
             Alert a = new Alert(Alert.AlertType.NONE);
                    String apelido="";
                    String nome1="";
                    if(!nome.getText().isEmpty()){
                   int  p = 0;
                    for(int i = nome.getText().length()-1; i >=0 ; i--){
                        if(nome.getText().charAt(i) != ' '){
                           apelido = apelido+nome.getText().charAt(i) ;
                      
                        }else{
                            p = i;
                            break;}
                    }
                    for(int i = 0; i <= p ;i++){
                      nome1 = nome1+nome.getText().charAt(i);
                    }
                  
                    String apl2 ="";
                    for(int i = apelido.length()-1 ; i >= 0;i--){
                      apl2 = apl2+apelido.charAt(i);
                    }
                    int v1 = fd.getCodigo(nome1, apl2);
                   fd.remove(v1);
                
                    dd.inserir(v1, nome1, apelido, motivo.getText());
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setContentText("A funcionario "+nome1+" foi Demitido com sucesso");
                    a.show();
                    }else{
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("os campos nome do funcionario e/ou mes estam vazios");
                    a.show();
                    }
        
        });
        close.setOnMouseClicked((MouseEvent me) -> {
            ss.close();
                   
            
        });
        
        
             nome.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case ENTER:
                    learning(nome.getText());
                    break;
                default:
                    break;
            }
        });
             for (int i = 0; i < fd.listar().size(); i++) {
            list1[i] = fd.listar().get(i).getNome()+" "+fd.listar().get(i).getApelido();
        }
        Collections.addAll(pws, list1);
        TextFields.bindAutoCompletion(nome, pws);

    }
    
    
        private AutoCompletionBinding<String> auto;
        String[] list1 = new String[200];
    public void learning(String s) {
        pws.add(s);
        if (auto != null) {
            auto.dispose();
        }
        auto = TextFields.bindAutoCompletion(nome, pws);

        auto.setPrefWidth(500);
    }
     
}
