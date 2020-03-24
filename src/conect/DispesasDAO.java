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
import model.Dispesas;
import model.Funcionario;

/**
 *
 * @author User
 */
public class DispesasDAO {

    private Connection conexao;

    public DispesasDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }

    public void inserir(Dispesas d) {
        String sql = "INSERT INTO `dispesas`(`produto`, `quantidade`, `preco`, `mes`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, d.getProduto());
            ps.setInt(2, d.getQuantidade());
            ps.setInt(3, d.getPreco());
            ps.setString(4, d.getMes());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 44 DispesasDao");
        }

    }

    public ObservableList<Dispesas> listar(String mes) {
        ObservableList<Dispesas> f = FXCollections.observableArrayList();

        String sql = "select * from dispesas where mes = '"+mes+"'";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
              
                Dispesas fu = new Dispesas(rs.getString("produto"), rs.getString("mes"),
                        rs.getInt("quantidade"),
                        rs.getInt("preco"));

                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
    public int i = 0;
    public static int valor[] = new int[12];
    public  static String mes1[] = new String[12];
    int total = 0;
    String mes[] = {"janeiro", "fevereiro","marco","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};

    public int[] listarT() {
  
       
        ObservableList<Dispesas> f = FXCollections.observableArrayList();

        String sql = "select * from dispesas where mes = '" + mes[i] + "'";
        try {
          
            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                total += rs.getInt("preco");
                mes1[i] = rs.getString("mes");
              
                valor[i] = total;
            }
            i++;

            total = 0;

            //if(i>1){
            ps.executeUpdate();
            ps.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
           
        return valor;
    }

}
