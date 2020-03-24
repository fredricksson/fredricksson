/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Funcionario;

/**
 *
 * @author User
 */
public class GerenteDAO {
      private Connection conexao;

    public GerenteDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }
    
    
     public void inserir(String nome,String nome_centro,String senha) {
        String sql =" INSERT INTO `gerente`(`nome`, `nome_centro`, `senha`) VALUES (?,?,?);";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, nome_centro);
            ps.setString(3, senha);
           
            

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("gerente funDao");
        }

    }
     public String nome_centro(){
          String sql = "select * from gerente";
          String nome_centro = "";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                 nome_centro = rs.getString("nome_centro")
              ;
              
               
            }
    
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nome_centro;
         
     
     }
     
     
     public  String[] listar() {
     
        String [] f = new String[2];
        f[0] = "";
        f[1] = "";
        String sql = "select * from gerente";
  
        try {


            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                f[0] = rs.getString("nome");
                f[1] = rs.getString("senha");
              
               
            }
    
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return f;
    }
     
}
