/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.DispesasDAO;
import eee.EEE;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Dispesas;
import conect.DispesasDAO;
import static conect.DispesasDAO.mes1;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DispesasController extends Application implements Initializable {

    /**
     * Initializes the controller class.
     */
    static Stage stagedispesa;
    static Stage sd = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.
                load(getClass().getResource("dispesas.fxml"));
        Scene scene = new Scene(parent);
        sd.setScene(scene);
        sd.setMaximized(true);
        sd.show();
    }

    double xOffset = 0;
    double yOffset = 0;

    @FXML
    TextField produto, quantidade, preco;
    @FXML
    ComboBox mesT;
    @FXML
    Button resgistar;
    @FXML
    BarChart grafico;
    @FXML
    private TableColumn<TableGetterSetterdispesas, String> mes;
    @FXML
    private TableColumn<TableGetterSetterdispesas, String> gasto;
    @FXML
    TableView<TableGetterSetterdispesas> tabelabalanco;
     public static    String mes4,total4 ;
    ObservableList<TableGetterSetterdispesas> list = FXCollections.observableArrayList();

    DispesasDAO dd = new DispesasDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        System.out.println("total  "+dd.listarT()[0]+"  v"+mes1[0]);
//        System.out.println("tos "+dd.listarT()[1]+  mes1[1]);
//    
//        System.out.println("tos "+dd.listarT()[2]+  mes1[2]);
//        System.out.println("tos "+dd.listarT()[3]+  mes1[3]);
//        System.out.println("tos "+dd.listarT()[4]+  mes1[4]);
//        System.out.println("tos "+dd.listarT()[5]+  mes1[5]);

        resgistar.setOnAction((ActionEvent e) -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            try {
                int prec = Integer.parseInt(preco.getText());
                int quantidad = Integer.parseInt(quantidade.getText());
                String mes = mesT.getSelectionModel().getSelectedItem().toString();

                Dispesas d = new Dispesas(produto.getText(), mes, quantidad, prec);
                if (!mes.isEmpty() && !produto.getText().isEmpty()) {
                    dd.inserir(d);
                    a.setContentText("produto Registado");
                    produto.setText("");
                    quantidade.setText("");
                    preco.setText("");
                    mesT.getSelectionModel().clearSelection();
                    dd.i = 0;
                    list.clear();
                    for (int i = 0; i < 12; i++) {

                        int total4 = dd.listarT()[i];
                        String mes2 = mes1[i];
                        if (mes1[i] == null) {
                            continue;
                        }
                        list.add(new TableGetterSetterdispesas(mes2, total4 + ".00MT"));

                    }
                    a.show();
                } else {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Campo/s vazio/s");
                    a.show();
                }
            } catch (NumberFormatException ee) {
                a.setAlertType(Alert.AlertType.ERROR);
                preco.setStyle("-fx-border-color: red");
                quantidade.setStyle("-fx-border-color: red");
                a.setContentText("Coloque valores numericos, nos campos 'quantidade' e 'preco'!");
                a.show();
            }

        });

        mesT.getItems().add("Janeiro");
        mesT.getItems().add("Fevereiro");
        mesT.getItems().add("marco");
        mesT.getItems().add("abril");
        mesT.getItems().add("maio");
        mesT.getItems().add("junho");
        mesT.getItems().add("julho");
        mesT.getItems().add("agosto");
        mesT.getItems().add("setembro");
        mesT.getItems().add("outubro");
        mesT.getItems().add("novembro");
        mesT.getItems().add("dezembro");
     
        grafico.setCategoryGap(20);
        grafico.
                setTitle("grafico de gastos mensais 2020");
        XYChart.Data<String, Number> janeiro
                = new XYChart.Data<String, Number>("Janeiro", dd.listarT()[0]);
        XYChart.Data<String, Number> fev
                = new XYChart.Data<String, Number>("fevereiro", dd.listarT()[1]);
        XYChart.Data<String, Number> mar
                = new XYChart.Data<String, Number>("marco", dd.listarT()[2]);
        XYChart.Data<String, Number> abr
                = new XYChart.Data<String, Number>("Abril", dd.listarT()[3]);
        XYChart.Data<String, Number> mai
                = new XYChart.Data<String, Number>("Maio", dd.listarT()[4]);
        XYChart.Data<String, Number> jun
                = new XYChart.Data<String, Number>("Junho", dd.listarT()[5]);
        XYChart.Data<String, Number> jul
                = new XYChart.Data<String, Number>("Julho", dd.listarT()[6]);
        XYChart.Data<String, Number> ago
                = new XYChart.Data<String, Number>("Agosto", dd.listarT()[7]);
        XYChart.Data<String, Number> set
                = new XYChart.Data<String, Number>("Setembro", dd.listarT()[8]);
        XYChart.Data<String, Number> out
                = new XYChart.Data<String, Number>("Outubro",dd.listarT()[9]);
        XYChart.Data<String, Number> nov
                = new XYChart.Data<String, Number>("Novembro", dd.listarT()[10]);
        XYChart.Data<String, Number> dez
                = new XYChart.Data<String, Number>("Dezembro", dd.listarT()[11]);
        XYChart.Series<String, Number> seriesData
                = new XYChart.Series<String, Number>();
        seriesData.setName("Porcentagem (%)");
        seriesData.getData().addAll(janeiro, fev, mar, abr, mai, jun, jul, ago, set, out, nov, dez);
        grafico.getData().add(seriesData);
       dd.i=0;
        for (int i = 0; i < 12; i++) {
            int total = dd.listarT()[i];
            String mes = mes1[i];
            if (mes1[i] == null) {
                continue;
            }
            list.add(new TableGetterSetterdispesas(mes, total + ".00MT"));

        }

        tabelabalanco.setItems(list);
        mes.setCellValueFactory(new PropertyValueFactory<TableGetterSetterdispesas, String>("mes"));
        gasto.setCellValueFactory(new PropertyValueFactory<TableGetterSetterdispesas, String>("gasto"));

        tabelabalanco.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<TableGetterSetterdispesas>() {
                    @Override
                    public void changed(ObservableValue<? extends TableGetterSetterdispesas> observable, TableGetterSetterdispesas oldValue, TableGetterSetterdispesas newValue) {

                        stagedispesa = new Stage();
                        DetalhesGastos t = new DetalhesGastos();

//                           
                        try {
                          
                             mes4 = tabelabalanco.getItems().get(tabelabalanco.getSelectionModel().getSelectedIndex()).mes;
                             total4 = tabelabalanco.getItems().get(tabelabalanco.getSelectionModel().getSelectedIndex()).gasto;
                              
                            stagedispesa.initModality(Modality.WINDOW_MODAL);
                            stagedispesa.initStyle(StageStyle.UNDECORATED);
                            //  new EEE().start(s);
                            stagedispesa.initOwner(sd);
                            Scene c = new Scene(t.s());
                            stagedispesa.setScene(c);
                            t.start(stagedispesa);
                            stagedispesa.showAndWait();

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage() + "  sim");
                        }
                    }

                });

    }

    public class DetalhesGastos extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("detalhesGastos.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("detalhesGastos.fxml"));
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
            stage.show();
        }
    }

}
