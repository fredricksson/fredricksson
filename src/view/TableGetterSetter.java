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
public class TableGetterSetter {
    
   int id;
   String nome;
   String apelido;
    int ano;
   CheckBox checkbox;

    public int getId() {
        return id;
    }


    public TableGetterSetter(int id, String nome, String apelido, int ano,CheckBox ch) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.ano = ano;
        checkbox = ch;
   
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    
    public String getApelido() {
        return apelido;
    }

    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(CheckBox checkbox) {
        this.checkbox = checkbox;
    }
    
}
