/*
 Esta classe é responsavel pela comunicação do Aplicativo com a base de dados MySQL;
 */
package conect;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Manhiça
 */
public class BDconexao implements Serializable {

    private  String Host;
    private  String BD;
    private  String user;
    private  String password;
    private  String porta;

    public BDconexao() {
        this.Host = "localhost"; // 127.0.0.1 = localhost
        this.porta = "3306";
        this.BD = "centro";
        this.user = "root";
        this.password = "";
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        BDconexao bDconexao = new BDconexao();
        return DriverManager.getConnection("jdbc:mysql://" + bDconexao.Host + ":" + bDconexao.porta + "/" + bDconexao.BD + "?user="+bDconexao.user+"&password="+bDconexao.password+"&noAccessToProcedureBodies=true");
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
    
    
    public static void main(String a[]) throws SQLException, ClassNotFoundException{
       Connection conexao =  BDconexao.getConnection();;
      BDconexao bd = new BDconexao();
       String sql="select * from criancas";
       PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rs;
     rs = ps.executeQuery();
            while(rs.next()){   
                  
                System.out.println((rs.getString("nome")));
       
        
                 }
     // ps.executeUpdate();
    ps.close();
       
    }
}
