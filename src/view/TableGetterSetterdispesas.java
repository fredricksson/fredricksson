/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author User
 */
public class TableGetterSetterdispesas {
    

   String mes;
   String gasto;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getGasto() {
        return gasto;
    }

    public void setGasto(String gasto) {
        this.gasto = gasto;
    }
 

    

    public TableGetterSetterdispesas( String mes, String gasto) {
      
        this.mes= mes;
        this.gasto =gasto;
      
  
    }



    
}
