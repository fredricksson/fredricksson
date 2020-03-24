/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Funcionario {

    String nome,apelido ,data_nascimento,formada_em,funcao,
            genero,estado_civil,morada;
    int contacto,codigo,salario;

    public Funcionario(String nome, String apelido, String data_nascimento, String formada_em, String funcao, String genero, String estado_cilvil, String morada, int contacto, int codigo, int salario) {
        this.nome = nome;
        this.apelido = apelido;
        this.data_nascimento = data_nascimento;
        this.formada_em = formada_em;
        this.funcao = funcao;
        this.genero = genero;
        this.estado_civil = estado_cilvil;
        this.morada = morada;
        this.contacto = contacto;
        this.codigo = codigo;
        this.salario = salario;
    }

 
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getFormada_em() {
        return formada_em;
    }

    public void setFormada_em(String formada_em) {
        this.formada_em = formada_em;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado_cilvil() {
        return estado_civil;
    }

    public void setEstado_cilvil(String estado_cilvil) {
        this.estado_civil = estado_cilvil;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    
    
}
