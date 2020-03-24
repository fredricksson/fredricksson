/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author User
 */
public class Crianca {
    String  nome,
            apelido,
            naturidade,
            morada,
           
            data_nascimento,
            nome_pai,
            nome_mae,
             
            sexo,
            profissao_pai,
            profissao_mae,nr_bi;
           int contaco_pai,
            contacto_mae,codigo;

    public String getNr_bi() {
        return nr_bi;
    }

    public void setNr_bi(String nr_bi) {
        this.nr_bi = nr_bi;
    }
         public Crianca(String nome, String apelido, String naturidade, String morada, String data_nascimento, String nome_pai, String nome_mae, int contaco_pai, int contacto_mae,String sexo,String nr_bi,String profissao_pai,String profissao_mae) {
        this.nome = nome;
        this.apelido = apelido;
        this.naturidade = naturidade;
        this.morada = morada;
        this.data_nascimento= data_nascimento;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.contaco_pai = contaco_pai;
        this.contacto_mae = contacto_mae;
        this.sexo =sexo;
        this.profissao_pai = profissao_pai;
        this.profissao_mae  = profissao_mae;
        this.nr_bi = nr_bi;
    }

    public String getProfissao_pai() {
        return profissao_pai;
    }

    public void setProfissao_pai(String profissao_pai) {
        this.profissao_pai = profissao_pai;
    }

    public String getProfissao_mae() {
        return profissao_mae;
    }

    public void setProfissao_mae(String profissao_mae) {
        this.profissao_mae = profissao_mae;
    }
         public Crianca(String nome, String apelido, String naturidade, String morada, String data_nascimento, String nome_pai, String nome_mae, int contaco_pai, int contacto_mae,String sexo,int codigo,String profissao_pai,String profissao_mae,String nr_bi) {
        this.nome = nome;
        this.apelido = apelido;
        this.naturidade = naturidade;
        this.morada = morada;
        this.data_nascimento= data_nascimento;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.contaco_pai = contaco_pai;
        this.contacto_mae = contacto_mae;
        this.sexo =sexo;
        this.codigo = codigo;
        this.profissao_pai = profissao_pai;
        this.profissao_mae  = profissao_mae;
        this.nr_bi = nr_bi;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNaturidade() {
        return naturidade;
    }

    public void setNaturidade(String naturidade) {
        this.naturidade = naturidade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public int getContaco_pai() {
        return contaco_pai;
    }

    public void setContaco_pai(int contaco_pai) {
        this.contaco_pai = contaco_pai;
    }

    public int getContacto_mae() {
        return contacto_mae;
    }

    public void setContacto_mae(int contacto_mae) {
        this.contacto_mae = contacto_mae;
    }

    
}
