/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eee;

import eee.*;
import conect.DispesasDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Dispesas;
import static eee.DispesasController.mes4;
import static eee.DispesasController.stagedispesa;
import static eee.DispesasController.total4;

/**
 *
 * @author User
 */
public class DetalhesController implements Initializable{
    
    @FXML
    ImageView close;
    @FXML
    Label total1,mes;
    
     @FXML
    ListView<String> listview;
     
       DispesasDAO dd = new DispesasDAO();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
                              
                            ObservableList<Dispesas> lis =dd.listar(mes4);
                            //ObservableList<String> li =FXCollections.observableArrayList();
                             mes.setText(lis.get(0).getMes());
                             total1.setText(total4);
                           System.out.println(lis.get(0).getMes()+"  "+lis.size());
                           for(int i = 0 ; i  < lis.size();i++){
                           listview.getItems().add(""+lis.get(i).getProduto()+"                              preco:    "+lis.get(i).getPreco()+".00MT"+"        "
                                   + "quatidade:   "+lis.get(i).getQuantidade());

                           
//                           }
                           
                           //  listview.setItems(li);
        
        
        
        
        
             close.setOnMouseClicked((MouseEvent event) -> {

                stagedispesa.close();
            
        });
    }
    
}}
