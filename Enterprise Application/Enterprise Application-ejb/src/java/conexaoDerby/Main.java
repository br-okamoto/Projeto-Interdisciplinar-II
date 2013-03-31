package conexaoDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      String url = "jdbc:derby://localhost:1527/sample";
      Connection con = DriverManager.getConnection(url, "app", "app");
      // faz a consulta no banco
      java.sql.Statement declaracao = con.createStatement();
      ResultSet clientes  = declaracao.executeQuery("SELECT * FROM CUSTOMER");
      while (clientes.next()) {
         System.out.println(clientes.getString("name"));
      }
      System.out.println(con.getCatalog());
   }
}