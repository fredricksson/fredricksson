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

import model.Mensalidades;

/**
 *
 * @author User
 */
public class MensalidadeDAO {

    private Connection conexao;

    public MensalidadeDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }

    public void inserir(Mensalidades c) {
        String sql = "insert into mensalidades(janeiro, fevreiro, marco,abril,"
                + " maio, junho, julho, agosto, setembro,"
                + " outubro, novembro, codigo_crianca) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getJaneiro());
            ps.setString(2, c.getFevereiro());
            ps.setString(3, c.getMarco());
            ps.setString(4, c.getAbril());
            ps.setString(5, c.getMaio());
            ps.setString(6, c.getJunho());
            ps.setString(7, c.getJulho());
            ps.setString(8, c.getAgosto());
            ps.setString(9, c.getSetembro());
            ps.setString(10, c.getOutubro());
            ps.setString(11, c.getNovembro());
            ps.setInt(12, c.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 MensaDao");
        }

    }
    public void inserirCodigo(int c) {
        String sql = "insert into mensalidades(codigo_crianca) values(?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c);
       

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 MensaDao");
        }

    }
    public void inserirMensalidade(int c,String mes) {
        String sql = "UPDATE mensalidades SET "+mes+" = ? WHERE codigo_crianca = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(2, c);
            ps.setString(1,"pago");

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 MensaDao");
        }

    }

    public  ObservableList<Mensalidades> listar() {
        ObservableList<Mensalidades> f = FXCollections.observableArrayList();

        String sql = "SELECT nome,janeiro,fevreiro,marco,abril,maio,"
                + "junho,julho,agosto,setembro,outubro,novembro from criancas INNER JOIN mensalidades on(criancas.codigo = mensalidades.codigo_crianca)";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                Mensalidades fu = new Mensalidades(rs.getString("nome"),rs.getString("janeiro"), rs.getString("fevreiro"),
                        rs.getString("marco"), rs.getString("abril"),
                        rs.getString("maio"), rs.getString("junho"),
                        rs.getString("julho"), rs.getString("agosto"),
                        rs.getString("setembro"), rs.getString("outubro"),rs.getString("novembro"));
                
                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }
}
