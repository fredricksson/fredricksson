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
public class Mensalidades {
    String 
          
           nome ,
           
            
            
            
            janeiro,
           fevereiro,
           marco,
           abril,
           maio,
           junho,
           julho,
           agosto,
           setembro,
           outubro, 
           novembro,total; 
         int codigo;
    public Mensalidades(String janeiro, String fevereiro, String marco, String abril, String maio, String junho, String julho, String agosto, String setembro, String novembro, int codigo) {
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.novembro = novembro;
        
        this.codigo = codigo;
    }

    public Mensalidades( String nome,String janeiro, String fevereiro, String marco, String abril, String maio, String junho, String julho, String agosto, String setembro, String outubro, String novembro, String total) {
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
        this.nome = nome;
        this.total = total;
    }
    public Mensalidades( String nome,String janeiro, String fevereiro, String marco, String abril, String maio, String junho, String julho, String agosto, String setembro, String outubro, String novembro) {
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
        this.nome = nome;
   
    }

    public Mensalidades(String janeiro, String fevereiro, String marco, String abril, String maio, String junho, String julho, String agosto, String setembro, String outubro, String novembro) {
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
       
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mensalidades() {
    }

    public String getOutubro() {
        return outubro;
    }

    public void setOutubro(String outubro) {
        this.outubro = outubro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getJaneiro() {
        return janeiro;
    }

    public void setJaneiro(String janeiro) {
        this.janeiro = janeiro;
    }

    public String getFevereiro() {
        return fevereiro;
    }

    public void setFevereiro(String fevereiro) {
        this.fevereiro = fevereiro;
    }

    public String getMarco() {
        return marco;
    }

    public void setMarco(String marco) {
        this.marco = marco;
    }

    public String getAbril() {
        return abril;
    }

    public void setAbril(String abril) {
        this.abril = abril;
    }

    public String getMaio() {
        return maio;
    }

    public void setMaio(String maio) {
        this.maio = maio;
    }

    public String getJunho() {
        return junho;
    }

    public void setJunho(String junho) {
        this.junho = junho;
    }

    public String getJulho() {
        return julho;
    }

    public void setJulho(String julho) {
        this.julho = julho;
    }

    public String getAgosto() {
        return agosto;
    }

    public void setAgosto(String agosto) {
        this.agosto = agosto;
    }

    public String getSetembro() {
        return setembro;
    }

    public void setSetembro(String setembro) {
        this.setembro = setembro;
    }

    public String getNovembro() {
        return novembro;
    }

    public void setNovembro(String novembro) {
        this.novembro = novembro;
    }

       
            
}
