package sample.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author niluxer
 */
public class MySQL {
 private static Connection conn = null;
 private static String hostname = "localhost";
 private static String dbname = "Hospital";
 private static String dbuser = "sistema";  //no usar el usuario root
 private static String dbpass = "TopicosProgra";

 public static void Connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://"+hostname +":3306/" + dbname, dbuser, dbpass);
      System.out.println("La conexion fue exitosa ");
   } catch (ClassNotFoundException ex) {
      Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
   } catch (SQLException ex) {
      Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
   }
 }

 public static Connection getConnection() {
   if(conn == null) Connect();
     return conn;
 }

 public static void Disconnect() {
   try {
        conn.close();
        System.out.println("Se ha finalizado la conexión con el servidor");
   } catch (SQLException ex) {
        Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE,
       null, ex);
   }
   }

}