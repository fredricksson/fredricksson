/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class DemissaoDAO {
    
     private Connection conexao;

    public DemissaoDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }

    public void inserir(int codigo,String nome, String apelido,String motivo) {
        String sql = "INSERT INTO `demissao`(`codigo`, `nome`, `apelido`, `motivo`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
         
            ps.setInt(1, codigo);
            ps.setString(2, nome);
            ps.setString(3, apelido);
            ps.setString(4, motivo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 44 demissaoDao");
        }

    }

    
}
