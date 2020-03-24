/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.MensalidadeDAO;
import conect.criancaDAO;
import static eee.LoginController.operador;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.DateTime;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import static view.criancaController.ss;

/**
 *
 * @author User
 */
public class pagamentosController implements Initializable {

    @FXML
    ImageView close;
    String[] list1 = new String[200];
    String[] list2 = {"janeiro","fevreiro","marco","Abril","Maio","Junho","Julho","Agosto","Setembro","outubro","Novembro"};
    @FXML
    TextField nome,mes,mensalidade,date,operado;
    Set<String> pws = new HashSet<>();
    Set<String> pws2 = new HashSet<>();
    @FXML
    Button confirmar;
    private AutoCompletionBinding<String> auto;
    private AutoCompletionBinding<String> auto2;
    criancaDAO cd = new criancaDAO();
    MensalidadeDAO md = new MensalidadeDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        close.setOnMouseClicked((MouseEvent event) -> {
            ss.close();
        });
        

        for (int i = 0; i < cd.listar().size(); i++) {
            list1[i] = cd.listar().get(i).getNome();
        }
        operado.setText(operador);
        DateTime dt = new DateTime();
        date.setText(dt.getDate());
        Collections.addAll(pws, list1);
        Collections.addAll(pws2, list2);
        TextFields.bindAutoCompletion(nome, pws);
        TextFields.bindAutoCompletion(mes, pws2);

        Alert a = new Alert(Alert.AlertType.NONE);
        nome.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case ENTER:
                    learning(nome.getText());
                    break;
                default:
                    break;
            }
        });
        mes.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case ENTER:
                    learning(mes.getText());
                    break;
                default:
                    break;
            }
        });
        
        confirmar.setOnAction((ActionEvent event) -> {
            int b=0;
            for (int i = 0; i < cd.listar().size(); i++) {
                if(cd.listar().get(i).getNome().contains(nome.getText())){
                   b = i;
                    break;
                }
            }
           // int n = cd.listar().get(cd.listar().indexOf(nome.getText())).getCodigo();
            //JOptionPane.showMessageDialog(null, n);
           md.inserirMensalidade(cd.listar().get(b).getCodigo(),mes.getText());
              a.setAlertType(AlertType.INFORMATION);
                    criancaController cc = new criancaController();
                    
                  
            a.setContentText("Pagamento succedido!");

            a.show();

            
            
            
        });
    }

    public void learning(String s) {
        pws.add(s);
        if (auto != null) {
            auto.dispose();
        }
        auto = TextFields.bindAutoCompletion(nome, pws);

        auto.setPrefWidth(500);
    }
    public void learning2(String s) {
        pws2.add(s);
        if (auto2 != null) {
            auto2.dispose();
        }
        auto2 = TextFields.bindAutoCompletion(mes, pws2);

        auto2.setPrefWidth(500);
    }

}
