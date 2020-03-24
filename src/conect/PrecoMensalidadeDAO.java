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
import java.util.ArrayList;
import model.Crianca;

/**
 *
 * @author User
 */
public class PrecoMensalidadeDAO {
     private Connection conexao;

    public PrecoMensalidadeDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }
    
       public void inserir(int mensalidade,int inscricao) {
        String sql = "INSERT INTO `precos`(`mensalidade`, `inscricao`) VALUES (?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
         
            ps.setInt(1,  mensalidade);
            ps.setInt(2, inscricao);
         

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 funDao");
        }

    }
       
       public  int getMensalidade() {
           int mensalidade = 0;

        String sql = "SELECT mensalidade FROM precos ";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
       

               mensalidade= rs.getInt("mensalidade");
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mensalidade;
    }
}
