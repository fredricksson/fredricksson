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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Crianca;

/**
 *
 * @author User
 */
public class criancaDAO {

    private Connection conexao;

    public criancaDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }

    public void inserir(Crianca c) {
        String sql = "insert into criancas(nome,apelido,naturalidade,morada,data_nascimento,"
                + "nome_pai,nome_mae,contacto_pai,contacto_mae,sexo,nr_bi,profissao_pai,profissao_mae) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getApelido());
            ps.setString(3, c.getNaturidade());
            ps.setString(4, c.getMorada());
            ps.setString(5, c.getData_nascimento());
            ps.setString(6, c.getNome_pai());
            ps.setString(7, c.getNome_mae());
            ps.setInt(8, c.getContaco_pai());
            ps.setInt(9, c.getContacto_mae());
            ps.setString(10, c.getSexo());
            ps.setString(11, c.getNr_bi());
            ps.setString(12, c.getProfissao_pai());
            ps.setString(13, c.getProfissao_mae());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 funDao");
        }

    }

    public ObservableList<Crianca> listar() {
        ObservableList<Crianca> f = FXCollections.observableArrayList();

        String sql = "select * from criancas";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                Crianca fu = new Crianca(rs.getString("nome"), rs.getString("apelido"),
                        rs.getString("naturalidade"), rs.getString("morada"),
                        rs.getString("data_nascimento"), rs.getString("nome_pai"),
                        rs.getString("nome_mae"), rs.getInt("contacto_pai"),
                        rs.getInt("contacto_mae"), rs.getString("sexo"), rs.getInt("codigo"), rs.getString("profissao_pai"), rs.getString("profissao_mae"), rs.getString("nr_bi"));

                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public void delete(int codigo) {
        String sql = "DELETE FROM `criancas` WHERE codigo = ? ";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }

    }

    public void update(String nome,String apelido,String naturalidade,String morada,
            String data,String nome_pai,String nome_mae,int contacto_pai,
            int contacto_mae,String sexo,String nr_bi,String profissao_pai,String profissao_mae,int codigo) {

        String sql = "UPDATE `criancas` SET `nome`=?,`apelido`=?,`naturalidade`=?,`morada`=?,`data_nascimento`=?,"
                + "`nome_pai`=?,`nome_mae`=?,`contacto_pai`=?,`contacto_mae`=?,`sexo`=?,"
                + "`nr_bi`=?,`profissao_pai`=?,`profissao_mae`=? WHERE codigo = '"+codigo+"'";
                try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, apelido);
            ps.setString(3, naturalidade);
            ps.setString(4, morada);
            ps.setString(5, data);
            ps.setString(6, nome_pai);
            ps.setString(7, nome_mae);
            ps.setInt(8, contacto_pai);
            ps.setInt(9, contacto_mae);
            ps.setString(10, sexo);
            ps.setString(11, nr_bi);
            ps.setString(12, profissao_pai);
            ps.setString(13, profissao_mae);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 132 update crianca erro");
        }

    }

    public ArrayList<Integer> listarMes(String mes, String estado) {
        ArrayList<Integer> f = new ArrayList<>();

        String sql = "SELECT codigo_crianca FROM mensalidades WHERE " + mes + "= '" + estado + "' ";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {

                f.add(rs.getInt("codigo_crianca"));
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
}
