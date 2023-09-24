package AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Entidades.Alumnos;
import java.util.ArrayList;
import java.util.List;

public class AlumnoData {
    
    private Connection con=null;
    
    public AlumnoData(){
        
        con=Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumnos alumno){
            String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                    + "VALUES (?, ?, ?, ?, ?)";
            
        try {
            PreparedStatement ps =con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechNac()));
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
            
        }
            
    }
    
    public void modificarAlumno(Alumnos alumno){
        String sql="UPDATE alumno SET dni= ?, apellido= ?, nombre= ?, fechaNacimiento= ?"
                + "WHERE idAlumno= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechNac()));
            ps.setInt(5, alumno.getIdAlumno());
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno"); ;
        }
    }
    
    public void eliminarAlumno(int id){
        String sql="UPDATE alumno SET estado=0 WHERE idAlumno= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno"); ;
        }
    }
    
    
    public Alumnos buscarAlumno(int id){
        String sql="SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno= ? AND estado=1";
        Alumnos alumno=null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.getGeneratedKeys();
            //int exito=ps.executeUpdate();
            if (rs.next()){
                
                alumno=new Alumnos();
                alumno.setIdAlumno(rs.getInt(1));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe un alumno asociado al id ingresado");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return alumno;
    }
        public Alumnos buscarAlumnoPorDni(int dni){
        String sql="SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni= ? AND estado=1";
        Alumnos alumno=null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.getGeneratedKeys();
            //int exito=ps.executeUpdate();
            if (rs.next()){
                
                alumno=new Alumnos();
                alumno.setIdAlumno(rs.getInt(1));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe un alumno activo asociado al dni ingresado");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return alumno;
    }
    
    public List<Alumnos> listarAlumnos(){
        String sql="SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado=1";
        ArrayList<Alumnos> alumnos=new ArrayList<>();
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                
                Alumnos alumno=new Alumnos();
                alumno=new Alumnos();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true); 
                
                alumnos.add(alumno);
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return alumnos;
    }
}
