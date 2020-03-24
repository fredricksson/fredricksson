/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conect.FuncionarioDAO;
import conect.SalarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Funcionario;
import model.Salario;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FuncionarioController implements Initializable {

    public static int codigoTabela;
    public static Stage ss;
    public static Stage sfuncionario = new Stage();
    @FXML
    TextField nome, apelido,
            morada, contacto, codigo, salario, pesquisa;
    double xOffset = 0;
    double yOffset = 0;

    @FXML
    Button actualizar;
    @FXML
    ComboBox funcao, estado_civil;
    @FXML
    RadioButton masculino, femenino;
    @FXML
    Button contratar, salariob,demissao;
    @FXML
    DatePicker data_nascimento;
    @FXML
    TextArea formado_em;

    @FXML
    TableView<Funcionario> tabela_funcionario;
    @FXML
    TableColumn<Funcionario, Integer> codigo1;
    @FXML
    TableColumn<Funcionario, String> nome1, funcao1, apelido1;

    @FXML
    public TableView<Salario> tabela_salario;

    @FXML
    TableColumn<Salario, String> nome2, jan, fev, mar, abr, mai, jun, jul, ago, set, out, nov, dez, total;

    Set<String> pws = new HashSet<>();

    ObservableList<Funcionario> listFuncionario;
    ObservableList<Salario> listSalario;

    FuncionarioDAO fd;
    SalarioDAO sd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //inicializacao de objectos
        fd = new FuncionarioDAO();
        sd = new SalarioDAO();
        listFuncionario = FXCollections.observableArrayList();
        listSalario = FXCollections.observableArrayList();

        salariob.setOnAction((ActionEvent event) -> {
            ss = new Stage();
            PagamentoSal t = new PagamentoSal();
            try {
                ss.initModality(Modality.WINDOW_MODAL);
                ss.initStyle(StageStyle.UNDECORATED);
                //  new EEE().start(s);
                ss.initOwner(sfuncionario);
                Scene c = new Scene(t.s());
                ss.setScene(c);
                t.start(ss);
                ss.showAndWait();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        demissao.setOnAction((ActionEvent event) -> {
            ss = new Stage();
            Demissao t = new Demissao();
            try {
                ss.initModality(Modality.WINDOW_MODAL);
                ss.initStyle(StageStyle.UNDECORATED);
                //  new EEE().start(s);
                ss.initOwner(sfuncionario);
                Scene c = new Scene(t.s());
                ss.setScene(c);
                t.start(ss);
                ss.showAndWait();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        //Pesqsuisa
        pesquisa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!pesquisa.getText().equals("")) {
                    tabela_funcionario.setItems(findItems());
                } else {
//                    for (int i = 0; i < fd.listar().size(); i++) {
//                        listFuncionario.add(fd.listar().get(i));
//                    }

                    tabela_funcionario.setItems(listFuncionario);
                }
            }
        });

        tabela_funcionario.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Funcionario>() {
                    @Override
                    public void changed(ObservableValue<? extends Funcionario> observable, Funcionario oldValue, Funcionario newValue) {

                        ss = new Stage();
//                        posicao = tabela.getSelectionModel().getSelectedIndex();
//                        pnome = tabela.getSelectionModel().getSelectedItem().nome;

                        codigoTabela = tabela_funcionario.getItems().get(tabela_funcionario.getSelectionModel().getSelectedIndex()).getCodigo();

                        Dados t = new Dados();
                        try {
                            ss.initModality(Modality.WINDOW_MODAL);
                            ss.initStyle(StageStyle.UNDECORATED);
                            //  new EEE().start(s);
                            ss.initOwner(sfuncionario);
                            Scene c = new Scene(t.s());
                            ss.setScene(c);
                            t.start(ss);
                            ss.showAndWait();

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                });

        for (int i = 0; i < fd.listar().size(); i++) {
            list1[i] = fd.listar().get(i).getNome();
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

        // Salario de Funcionario
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
        dez.setCellValueFactory(new PropertyValueFactory<>("dezembro"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        for (int i = 0; i < sd.listar().size(); i++) {
         
            
            listSalario.add(sd.listar().get(i));
           
        }

        tabela_salario.setItems(listSalario);

        actualizar.setOnAction((ActionEvent ae) -> {
            listSalario.clear();
            for (int i = 0; i < sd.listar().size(); i++) {
                listSalario.add(sd.listar().get(i));
            }

        });

        // Funcionario em 
        for (int i = 0; i < fd.listar().size(); i++) {
            listFuncionario.add(fd.listar().get(i));
        }

        funcao.getItems().add("Educarora");
        funcao.getItems().add("Cozinheira");
        estado_civil.getItems().add("Solteiro/a");
        estado_civil.getItems().add("casado/a");
        estado_civil.getItems().add("Divorciado/a");

        nome1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        codigo1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        funcao1.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        apelido1.setCellValueFactory(new PropertyValueFactory<>("apelido"));

        tabela_funcionario.setItems(listFuncionario);

        contratar.setOnAction((ActionEvent e) -> {
            //  public Funcionario(String nome, String apelido, String data_nascimento, String formada_em, String funcao, String genero, String estado_cilvil, String morada, int contacto, int codigo, int salario) {
            int cod = Integer.parseInt(codigo.getText());
            int sal = Integer.parseInt(salario.getText());
            int cont = Integer.parseInt(contacto.getText());
            String estado = estado_civil.getSelectionModel().getSelectedItem().toString();
            String func = funcao.getSelectionModel().getSelectedItem().toString();
            Funcionario f = new Funcionario(nome.getText(), apelido.getText(), data_nascimento.getEditor().getText(), formado_em.getText(), func,
                    "", estado,
                    morada.getText(), cont, cod, sal);
            fd.inserir(f);
            SalarioDAO sd = new SalarioDAO();
            sd.inserirCodigo(cod);
            listFuncionario.clear();
            for (int i = 0; i < fd.listar().size(); i++) {

                listFuncionario.add(fd.listar().get(i));
            }

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Funcionario contratado!");
            a.show();

        });

    }

    public void learning(String s) {
        pws.add(s);
        if (auto != null) {
            auto.dispose();
        }
        auto = TextFields.bindAutoCompletion(pesquisa, pws);
        auto.setMinWidth(600);
        auto.setPrefWidth(500);
    }

    String[] list1 = new String[200];

    private AutoCompletionBinding<String> auto;

    private ObservableList<Funcionario> findItems() {
        ObservableList<Funcionario> itensEncontrados = FXCollections
                .observableArrayList();
        for (Funcionario itens : fd.listar()) {
            if (itens.getNome().contains(pesquisa.getText())) {

                itensEncontrados.add(itens);

            }
        }
        return itensEncontrados;
    }

    public class Dados extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("../view/DadosFuncionario.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("../view/DadosFuncionario.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);

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

    public class PagamentoSal extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("../view/Salario.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("../view/Salario.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);

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
    public class Demissao extends Application {

        Parent parent;

        public Parent s() throws IOException {
            return parent = FXMLLoader.
                    load(getClass().getResource("../view/demissao.fxml"));
        }

        @Override
        public void start(Stage stage) throws Exception {
            parent = FXMLLoader.
                    load(getClass().getResource("../view/demissao.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);

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
