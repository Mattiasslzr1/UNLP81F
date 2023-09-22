package universisdadgrupo81.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "universidadulp"
    private static final String USUARIO="root";
    private static final String PASSWORD = "";             
    private  static  Connection connection;
    
    //Metodo Constructor 
    
    private Conexion () {}
    
   public static Connection getConexion(){
       if (connection == null) {
           try { 
               Class.forName("org.mariadb.jdbc.Driver");             
               connection = DriverManager
                       .getConnection (URL+DB ,USUARIO , PASSWORD );
                                        
           } catch(ClassNotFoundException ex){               
               JOptionPane.showMessageDialog(null, "Error al cargar los Drivers ");
                                         
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al conectarse a la BD ") ;
          
           }
       }
       
       return  connection;
            
   }
      
}
