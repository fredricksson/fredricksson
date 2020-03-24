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
import model.Crianca;
import model.Funcionario;


/**
 *
 * @author User
 */
public class FuncionarioDAO {
    
    
    private Connection conexao;

    public FuncionarioDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou"+ex.getMessage());
        }
    }
    public void inserir(Funcionario f) {            System.out.println("nao conectouet");

        String sql = "INSERT INTO `funcionario`(`nome`, `apelido`, `data_nascimento`, `codigo`, `formada_em`, `funcao`, `salario`, `genero`,"
                + " `estado_civil`, `morada`, `contacto`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getApelido());
            ps.setString(3, f.getData_nascimento());
            ps.setInt(4, f.getCodigo());
            ps.setString(5, f.getFormada_em());
            ps.setString(6, f.getFuncao());
            ps.setInt(7, f.getSalario());
            ps.setString(8, f.getGenero());
            ps.setString(9, f.getEstado_cilvil());
            ps.setString(10, f.getMorada());
            ps.setInt(11, f.getContacto());
            

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 funDao");
        }

    }
 
    
     public ObservableList<Funcionario> listar() {
        ObservableList<Funcionario> f = FXCollections.observableArrayList();

        String sql = "select * from funcionario";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
                Funcionario fu = new Funcionario(rs.getString("nome"), rs.getString("apelido"),
                        rs.getString("data_nascimento"),
                        rs.getString("formada_em"), rs.getString("funcao"), rs.getString("genero"),
                        rs.getString("estado_civil"), rs.getString("morada"), rs.getInt("contacto"), rs.getInt("codigo"),
                        rs.getInt("salario"));

                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
     
     public ObservableList<Funcionario> listarPersonalizado(int c) {
        ObservableList<Funcionario> f = FXCollections.observableArrayList();

        String sql = "select * from funcionario where codigo = '"+c+"'";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
                Funcionario fu = new Funcionario(rs.getString("nome"), rs.getString("apelido"),
                        rs.getString("data_nascimento"),
                        rs.getString("formada_em"), rs.getString("funcao"), rs.getString("genero"),
                        rs.getString("estado_civil"), rs.getString("morada"), rs.getInt("contacto"), rs.getInt("codigo"),
                        rs.getInt("salario"));

                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
     public int getSalario(String nome,String apelido) {
        ObservableList<Funcionario> f = FXCollections.observableArrayList();
        int salario = 0; 
        String sql = "select salario from funcionario where nome = '"+nome+"' and apelido='"+apelido+"'";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                
                salario = rs.getInt("salario");
          
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return salario;
     
     }
     public int getCodigo(String nome,String apelido) {
        ObservableList<Funcionario> f = FXCollections.observableArrayList();
        int salario = 0; 
        String sql = "select codigo from funcionario where nome = '"+nome+"' and apelido='"+apelido+"'";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                
                salario = rs.getInt("codigo");
          
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return salario;
     }
   
    public void remove(int codigo) {
        String sql = "DELETE FROM `funcionario` WHERE codigo = ? ";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }

    }
    
     public void update(String nome,String apelido,String data_nascimento,String formada_em,
            String funcao,String genero,String estado_civil,
            String morada,int contacto,int codigo) {

        String sql = "UPDATE `funcionario` SET `nome`=?,`apelido`=?,"
                + "`data_nascimento`=?,`formada_em`=?,"
                + "`funcao`=?,`genero`=?,`estado_civil`=?,`"
                + "morada`=?,`contacto`=? WHERE codigo = '"+codigo+"'";
                try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, apelido);
            ps.setString(3, data_nascimento);
            ps.setString(4, formada_em);
            ps.setString(5, funcao);
          
            ps.setString(6, genero);
      
            ps.setString(7, estado_civil);
            ps.setString(8, morada);
            ps.setInt(9, contacto);
           

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 132 update funcionario erro");
        }

    }

}
     
 




    

