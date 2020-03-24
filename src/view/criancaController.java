/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesimplements
 * and open the template in the editor.
 */
package view;

import conect.MensalidadeDAO;
import conect.PrecoMensalidadeDAO;
import conect.criancaDAO;
import eee.EEE;
import static eee.EEE.ss;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.Crianca;
import model.Mensalidades;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author User
 */
public class criancaController extends Application implements Initializable {

    //para que seja possivel fechar o stage em outras classes
    static Stage ss;
    static Stage s = new Stage();
    double xOffset = 0;
    double yOffset = 0;
    static int posicao;
    static String pnome;
    @FXML
    TextField pesquisa;
    Set<String> pws = new HashSet<>();
    @FXML
    Label time;
    @FXML
    Button lista, definir, pagar, actualizar;
    @FXML
    ComboBox categoria;

    @FXML
    private TableColumn<TableGetterSetter, Integer> id;

    @FXML
    private TableColumn<TableGetterSetter, String> nome;
    @FXML
    private TableColumn<TableGetterSetter, String> apelido;
    @FXML
    private TableColumn<TableGetterSetter, Integer> ano;
    @FXML
    private TableColumn<TableGetterSetter, CheckBox> select;
    @FXML
    TableView<TableGetterSetter> tabela;

    @FXML
    public TableView<Mensalidades> tabela_mensalidades;

    @FXML
    TableColumn<Mensalidades, String> nome2, jan, fev, mar, abr, mai, jun, jul, ago, set, out, nov, total;

    ObservableList<TableGetterSetter> list = FXCollections.observableArrayList();
    ObservableList<Mensalidades> list2 = FXCollections.observableArrayList();
    ObservableList<Mensalidades> list3 = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.
                load(getClass().getResource("criancas.fxml"));
        Scene scene = new Scene(parent);
        s.setScene(scene);
        s.setMaximized(true);
        s.show();
    }

    public class list extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("listaMensalidades.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("listaMensalidades.fxml"));

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
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            s.setMaximized(true);
            stage.show();
        }
    }

    public class def extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("DefinirMensalidade.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("DefinirMensalidade.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Tela de Login");
            stage.show();
        }
    }

    public class pag extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("pagamentos.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("pagamentos.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.show();
        }
    }

    ///metodo pra apagar na lista de crincas
    @FXML
    private void deleteSelectedRow(ActionEvent ae) {
        int contador = 0;
        Alert a = new Alert(Alert.AlertType.NONE);
      
        for (int i = 0; i < tabela.getItems().size(); i++) {
            if (tabela.getItems().get(i).getCheckbox().isSelected()) {
                int h = tabela.getItems().get(i).id;
                cd.delete(h);
                tabela.getItems().remove(tabela.getItems().get(i));
                contador++;
            }
        }
        if (contador > 0) {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Foram eliminadas " + contador + " criancas!");
            a.show();
            
            contador = 0;
        }else{
             a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Nenhuma crianca elimidada, clique na caixa da coluna 'MARK' ");
            a.show();
        }

    }

    public void learning(String s) {
        pws.add(s);
        if (auto != null) {
            auto.dispose();
        }
        auto = TextFields.bindAutoCompletion(pesquisa, pws);

        auto.setPrefWidth(500);
    }

    String[] list1 = new String[200];

    private AutoCompletionBinding<String> auto;
    criancaDAO cd = new criancaDAO();

    private ObservableList<TableGetterSetter> findItems() {
        ObservableList<TableGetterSetter> itensEncontrados = FXCollections
                .observableArrayList();
        for (Crianca itens : cd.listar()) {
            if (itens.getNome().contains(pesquisa.getText())) {

                itensEncontrados.add(new TableGetterSetter(itens.getCodigo(), itens.getNome(), itens.getApelido(), 4, new CheckBox()));
            }
        }
        return itensEncontrados;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pesquisa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!pesquisa.getText().equals("")) {
                    tabela.setItems(findItems());
                } else {
                    list.clear();                   
                    for (int i = 0; i < cd.listar().size(); i++) {
                        CheckBox ch = new CheckBox("" + i);

                        list.add(new TableGetterSetter(cd.listar().get(i).getCodigo(), cd.listar().get(i).getNome(), cd.listar().get(i).getApelido(), 4, ch));
                    }
                    tabela.setItems(list);
                }
            }
        });
        for (int i = 0; i < cd.listar().size(); i++) {
            list1[i] = cd.listar().get(i).getNome();
        }
        Collections.addAll(pws, list1);
        TextFields.bindAutoCompletion(pesquisa, pws);

        pesquisa.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case ENTER:
                    learning(pesquisa.getText());
                    break;
                default:
                    break;
            }
        });

        for (int i = 0; i < cd.listar().size(); i++) {
            CheckBox ch = new CheckBox("" + i);
            String date = "";
            String idade = cd.listar().get(i).getData_nascimento();
            int it = 0;
            int tamanho = idade.length() - 4;
            while (it < 4) {

                date = date + idade.charAt(tamanho);

                it++;
                tamanho++;

            }
            it = 0;
            int dat = Integer.parseInt(date);

            list.add(new TableGetterSetter(cd.listar().get(i).getCodigo(), cd.listar().get(i).getNome(), cd.listar().get(i).getApelido(), 2020 - dat, ch));
        }
        //tabela MEnsalidades
        MensalidadeDAO md = new MensalidadeDAO();
        PrecoMensalidadeDAO pm = new PrecoMensalidadeDAO();
        int mens = pm.getMensalidade();

        for (int i = 0; i < md.listar().size(); i++) {

            int total = 0;
            if (md.listar().get(i).getJaneiro().equalsIgnoreCase("pago")) {
                total++;
            }

            if (md.listar().get(i).getFevereiro().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getMarco().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getMaio().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getAbril().equalsIgnoreCase("pago")) {
                total++;
            }

            if (md.listar().get(i).getJulho().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getJunho().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getAgosto().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getSetembro().equalsIgnoreCase("pago")) {
                total++;
            }

            if (md.listar().get(i).getOutubro().equalsIgnoreCase("pago")) {
                total++;
            }
            if (md.listar().get(i).getNovembro().equalsIgnoreCase("pago")) {
                total++;
            }

            list2.add(new Mensalidades(md.listar().get(i).getNome(),
                    md.listar().get(i).getJaneiro(),
                    md.listar().get(i).getFevereiro(),
                    md.listar().get(i).getMarco(),
                    md.listar().get(i).getAbril(),
                    md.listar().get(i).getMaio(),
                    md.listar().get(i).getJunho(),
                    md.listar().get(i).getJulho(),
                    md.listar().get(i).getAgosto(),
                    md.listar().get(i).getSetembro(),
                    md.listar().get(i).getOutubro(),
                    md.listar().get(i).getNovembro(), mens * total+".00MT"));
            total = 0;

        }
      //  for (int i = 0; i < 1; i++) {
//                  System.out.println(tabela_mensalidades.getItems().get(0).equals("pago"));
                 // System.out.println(tabela_mensalidades.getItems().get(0).getOutubro());
            //tabela.getColumns().get(0).setStyle("-fx-text-fill: red");
      //  } 
        //}

        nome2.setCellValueFactory(new PropertyValueFactory<>("nome"));
        jan.setCellValueFactory(new PropertyValueFactory<>("janeiro"));
        fev.setCellValueFactory(new PropertyValueFactory<>("fevereiro"));
        mar.setCellValueFactory(new PropertyValueFactory<>("marco"));
        abr.setCellValueFactory(new PropertyValueFactory<>("abril"));
        mai.setCellValueFactory(new PropertyValueFactory<>("maio"));
        jun.setCellValueFactory(new PropertyValueFactory<>("junho"));
        jul.setCellValueFactory(new PropertyValueFactory<>("julho"));
        ago.setCellValueFactory(new PropertyValueFactory<>("agosto"));
        set.setCellValueFactory(new PropertyValueFactory<>("setembro"));
        out.setCellValueFactory(new PropertyValueFactory<>("outubro"));
        nov.setCellValueFactory(new PropertyValueFactory<>("novembro"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        total.setStyle("-fx-text-fill: blue");
        tabela_mensalidades.setItems(list2);
        actualizar.setOnAction((ActionEvent event) -> {
            list3.clear();
            for (int i = 0; i < md.listar().size(); i++) {
                int total = 0;
                if (md.listar().get(i).getJaneiro().equalsIgnoreCase("pago")) {
                    total++;
                }

                if (md.listar().get(i).getFevereiro().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getMarco().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getMaio().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getAbril().equalsIgnoreCase("pago")) {
                    total++;
                }

                if (md.listar().get(i).getJulho().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getJunho().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getAgosto().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getSetembro().equalsIgnoreCase("pago")) {
                    total++;
                }

                if (md.listar().get(i).getOutubro().equalsIgnoreCase("pago")) {
                    total++;
                }
                if (md.listar().get(i).getNovembro().equalsIgnoreCase("pago")) {
                    total++;
                }
                list3.add(new Mensalidades(md.listar().get(i).getNome(),
                        md.listar().get(i).getJaneiro(),
                        md.listar().get(i).getFevereiro(),
                        md.listar().get(i).getMarco(),
                        md.listar().get(i).getAbril(),
                        md.listar().get(i).getMaio(),
                        md.listar().get(i).getJunho(),
                        md.listar().get(i).getJulho(),
                        md.listar().get(i).getAgosto(),
                        md.listar().get(i).getSetembro(),
                        md.listar().get(i).getOutubro(),
                        md.listar().get(i).getNovembro(), mens * total+".00MT"));
                total = 0;
            }

            tabela_mensalidades.setItems(list3);
        });

        // System.out.println(tabela_mensalidades.getItems().get(0).);
        //tabela de Crincas 
        tabela.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<TableGetterSetter, String>("nome"));
        apelido.setCellValueFactory(new PropertyValueFactory<TableGetterSetter, String>("apelido"));
        ano.setCellValueFactory(new PropertyValueFactory<TableGetterSetter, Integer>("ano"));
        select.setCellValueFactory(new PropertyValueFactory<TableGetterSetter, CheckBox>("checkbox"));

        categoria.setTooltip(new Tooltip("Ano estudantil"));
        categoria.setValue("Ano ");
        categoria.getItems().add("1* Ano");
        categoria.getItems().add("2* Ano");
        categoria.getItems().add("3* Ano");
        categoria.getItems().add("4* Ano");
        categoria.getItems().add("5* Ano");

        lista.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                list l = new list();
                ss = new Stage();
                try {

                    ss.initModality(Modality.WINDOW_MODAL);
                    ss.initStyle(StageStyle.UNDECORATED);
                    //  new EEE().start(s);
                    ss.initOwner(s);
                    Scene c = new Scene(l.s());
                    ss.setScene(c);
                    l.start(ss);
                    ss.showAndWait();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        definir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                def d = new def();

                ss = new Stage();
                try {

                    ss.initModality(Modality.WINDOW_MODAL);
                    ss.initStyle(StageStyle.UNDECORATED);

                    ss.initOwner(s);
                    Scene c = new Scene(d.s());
                    ss.setScene(c);
                    d.start(ss);
                    ss.showAndWait();

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        pagar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pag d = new pag();

                ss = new Stage();
                try {

                    ss.initModality(Modality.WINDOW_MODAL);
                    ss.initStyle(StageStyle.UNDECORATED);

                    ss.initOwner(s);
                    Scene c = new Scene(d.s());
                    ss.setScene(c);
                    d.start(ss);
                    ss.showAndWait();

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        tabela.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<TableGetterSetter>() {
                    @Override
                    public void changed(ObservableValue<? extends TableGetterSetter> observable, TableGetterSetter oldValue, TableGetterSetter newValue) {

                        ss = new Stage();
                        posicao = tabela.getSelectionModel().getSelectedIndex();
                        pnome = tabela.getSelectionModel().getSelectedItem().nome;

                        perfil t = new perfil();
                        try {
                            ss.initModality(Modality.WINDOW_MODAL);
                            ss.initStyle(StageStyle.UNDECORATED);
                            //  new EEE().start(s);
                            ss.initOwner(s);
                            Scene c = new Scene(t.s());
                            ss.setScene(c);
                            t.start(ss);
                            ss.showAndWait();

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                });

    }

    public class perfil extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("perfil.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("perfil.fxml"));
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
