
package dal;
import java.sql.*;

public class ModulodeConexão {
    public static Connection conector(){
       java.sql.Connection conexao = null;
       String driver = "com.mysql.jdbc.Driver";
       
       String url = "jdbc:mysql://localhost:3306/prhotel";
       String user = "root";
       String password = "";
       
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
           
    }
}
