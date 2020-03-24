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

import model.Salario;

/**
 *
 * @author User
 */
public class SalarioDAO {
    
    private Connection conexao;

    public SalarioDAO() {
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou");
        }
    }
    
    public void inserirCodigo(int c) {
        String sql = "insert into salario(codigo) values(?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c);
       

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 39 salario");
        }

    }
    
       public void inserirSalario(int codigo,String mes) {
        String sql = "UPDATE salario set "+mes+"= 'RC'  WHERE codigo = ? ";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
   
            
            

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro no 78 funDao");
        }

    }
    
    public  ObservableList<Salario> listar() {
        ObservableList<Salario> f = FXCollections.observableArrayList();

        String sql = "SELECT salario,nome,janeiro,fevereiro,marco,abril,maio,"
                + "junho,julho,agosto,setembro,outubro,novembro,dezembro from salario INNER JOIN funcionario on(funcionario.codigo = salario.codigo)";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                

            int total = 0;
            if (rs.getString("janeiro").equalsIgnoreCase("rc")) {
                total++;
            }

            if (rs.getString("fevereiro").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("marco").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("abril").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("maio").equalsIgnoreCase("rc")) {
                total++;
            }

            if (rs.getString("junho").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("julho").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("agosto").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("setembro").equalsIgnoreCase("rc")) {
                total++;
            }

            if (rs.getString("outubro").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("novembro").equalsIgnoreCase("rc")) {
                total++;
            }
            if (rs.getString("dezembro").equalsIgnoreCase("rc")) {
                total++;
            }

//
//        }
//                
                
                
                Salario fu = new Salario(rs.getString("nome"),rs.getString("janeiro"), rs.getString("fevereiro"),
                        rs.getString("marco"), rs.getString("abril"),
                        rs.getString("maio"), rs.getString("junho"),
                        rs.getString("julho"), rs.getString("agosto"),
                        rs.getString("setembro"), rs.getString("outubro"),rs.getString("novembro"),rs.getString("dezembro"),rs.getInt("salario")*total+".00MT");
                        total = 0 ;
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
