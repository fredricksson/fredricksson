/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.FuncionarioDAO;
import conect.SalarioDAO;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import static view.FuncionarioController.ss;

/**
 *
 * @author User
 */
public class salarioController implements Initializable {

    @FXML
    ComboBox mes;
    @FXML
    ImageView close;
    @FXML
    TextField nome1;
    @FXML
    Label salario;
    @FXML
    Button pagar;        

    Set<String> pws = new HashSet<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FuncionarioDAO fd = new FuncionarioDAO();
        SalarioDAO sd = new SalarioDAO();
        close.setOnMouseClicked((MouseEvent event) -> {
            ss.close();

        });
        
         pagar.setOnAction((ActionEvent) -> {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    String apelido="";
                    String nome="";
                    if(!nome1.getText().isEmpty() && !mes.getSelectionModel().isEmpty()){
                   int  p = 0;
                    for(int i = nome1.getText().length()-1; i >=0 ; i--){
                        if(nome1.getText().charAt(i) != ' '){
                           apelido = apelido+nome1.getText().charAt(i) ;
                      
                        }else{
                            p = i;
                            break;}
                    }
                    for(int i = 0; i <= p ;i++){
                      nome = nome+nome1.getText().charAt(i);
                    }
                  
                    String apl2 ="";
                    for(int i = apelido.length()-1 ; i >= 0;i--){
                      apl2 = apl2+apelido.charAt(i);
                    }
                        System.out.println(nome+" "+apl2);
                    int c = fd.getCodigo(nome, apl2);
                    String mes = this.mes.getSelectionModel().getSelectedItem().toString();
                        System.out.println(c);
                        System.out.println(mes);
                        sd.inserirSalario(c, mes);

                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setContentText("A funcionario "+nome+" foi pago com sucesso");
                    a.show();
                    }else{
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("os campos nome do funcionario e/ou mes estam vazios");
                    a.show();
                    }
        
        });
        
        
        
        
        
        
        
        
        
        
        
        for (int i = 0; i < fd.listar().size(); i++) {
            list1[i] = fd.listar().get(i).getNome()+" "+fd.listar().get(i).getApelido();
        }
        Collections.addAll(pws, list1);
        TextFields.bindAutoCompletion(nome1, pws);

        nome1.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case ENTER:
                    learning(nome1.getText());
                    String apelido="";
                    String nome="";
                    if(!nome1.getText().isEmpty()){
                   int  p = 0;
                    for(int i = nome1.getText().length()-1; i >=0 ; i--){
                        if(nome1.getText().charAt(i) != ' '){
                           apelido = apelido+nome1.getText().charAt(i) ;
                      
                        }else{
                            p = i;
                            break;}
                    }
                    for(int i = 0; i <= p ;i++){
                      nome = nome+nome1.getText().charAt(i);
                    }
                  
                    String apl2 ="";
                    for(int i = apelido.length()-1 ; i >= 0;i--){
                      apl2 = apl2+apelido.charAt(i);
                    }
                   
                    
                    salario.setText(fd.getSalario(nome, apl2)+".00MT");
                    apelido = "";
                    }else
                        salario.setText("00.00MT");
                    break;
                default:
                    break;
            }
        });

        mes.getItems().add("Janeiro");
        mes.getItems().add("Fevereiro");
        mes.getItems().add("Marco");
        mes.getItems().add("Abril");
        mes.getItems().add("Maio");
        mes.getItems().add("Junho");
        mes.getItems().add("Julho");
        mes.getItems().add("Agosto");
        mes.getItems().add("Setembro");
        mes.getItems().add("outubro");
        mes.getItems().add("Novembro");
        mes.getItems().add("Dezembro");
    }
    private AutoCompletionBinding<String> auto;
        String[] list1 = new String[200];
    public void learning(String s) {
        pws.add(s);
        if (auto != null) {
            auto.dispose();
        }
        auto = TextFields.bindAutoCompletion(nome1, pws);

        auto.setPrefWidth(500);
    }

}
