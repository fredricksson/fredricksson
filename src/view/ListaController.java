/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.criancaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static view.criancaController.ss;

/**
 *
 * @author User
 */
public class ListaController implements Initializable {

    @FXML
    ComboBox estado, mes;
    @FXML
    Button procurar;
    @FXML
    ImageView close;
    @FXML
    ListView<String> lista;
    @FXML
    Label msg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> nomes = FXCollections.observableArrayList();
        mes.getItems().add("janeiro");
        mes.getItems().add("fevreiro");
        mes.getItems().add("marco");
        mes.getItems().add("abril");
        mes.getItems().add("marco");
        mes.getItems().add("junho");
        mes.getItems().add("julho");
        mes.getItems().add("agosto");
        mes.getItems().add("setembro");
        mes.getItems().add("outubro");
        mes.getItems().add("novembro");

        estado.getItems().add("Que Nao efectuaram pagamento");
        estado.getItems().add("Que  efectuaram pagamento");
        close.setOnMouseClicked((MouseEvent event) -> {
            ss.close();

        });
        procurar.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("yes "+estado.getSelectionModel().isEmpty());
           if(!estado.getSelectionModel().isEmpty() &&! mes.getSelectionModel().isEmpty()){
            nomes.clear();
            if (estado.getSelectionModel().getSelectedItem().toString().equals("Que Nao efectuaram pagamento")) {
                msg.setText(mes.getSelectionModel().getSelectedItem().toString() + "  || Criancas que Nao efectuaram pagamento! ");
                msg.setStyle("-fx-text-fill: red;-fx-font-size:26");
                criancaDAO cd = new criancaDAO();
                ArrayList<Integer> indice = cd.listarMes(mes.getSelectionModel().getSelectedItem().toString(), "N.P");

                for (int i = 0; i < indice.size(); i++) {
                    for (int j = 0; j < cd.listar().size(); j++) {

                        if (cd.listar().get(j).getCodigo() == indice.get(i)) {
                            nomes.add(cd.listar().get(j).getNome() + " " + cd.listar().get(j).getApelido());
                        }

                    }

                }
                lista.setItems(nomes);
            } else {
                nomes.clear();
                 msg.setText(mes.getSelectionModel().getSelectedItem().toString() + "  || Criancas ue  efectuaram pagamento ");
                msg.setStyle("-fx-text-fill: blue;-fx-font-size:26");
                criancaDAO cd = new criancaDAO();
                ArrayList<Integer> indice = cd.listarMes(mes.getSelectionModel().getSelectedItem().toString(), "pago");

                for (int i = 0; i < indice.size(); i++) {
                    for (int j = 0; j < cd.listar().size(); j++) {

                        if (cd.listar().get(j).getCodigo() == indice.get(i)) {
                            nomes.add(cd.listar().get(j).getNome() + " " + cd.listar().get(j).getApelido());
                        }

                    }

                }
                lista.setItems(nomes);

            }
           }
        });
    }

}
