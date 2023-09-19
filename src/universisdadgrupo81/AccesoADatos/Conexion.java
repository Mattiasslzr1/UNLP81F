
package universisdadgrupo81.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL="jdbc:mysql://localhost";
    private static final String DB="universidadulp"
    private static final String Usuario="root";
    private static String PASSWORD="";        
    
    
    private  static  Connection connection;
    
    //Metodo Constructor 
    
    private Conexion () {}
    
   public static Connection getConexion(){
       if (connection == null) {
           try { 
               Class.forName("org.mariadb.jdbc.Driver");
               // Setup the connection with the Db
               connection = DriverManager
                       .getConnection (URL+DB + "?useLegacyDatetimeCode=flase&serverTimezone=UTC"
                                        + "&user="+ USUARIO + "password=" + ¨PASSWORD);
                                        
                                        
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al conectarse a la BD "+ex.getMessage());
           }catch(ClassNotFoundException ex){
               
               JOptionPane.showMessageDialog(null,"Error al cargar los Drivers "+ex.getMesagge());
               
           }
       }
       
       return  connection;
            
   }
      
}
