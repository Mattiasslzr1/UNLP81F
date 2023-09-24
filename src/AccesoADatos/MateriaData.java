/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;

public class MateriaData {
    private Connection con=null;
    
    public MateriaData(){
        
        con=Conexion.getConexion();
    }
    
    
    public void MateriaData(){}
    
    public void guardarMateria(Materia materia){
            String sql = "INSERT INTO materia (nombre= ?, año= ?, estado= ?)"
                    + "VALUES (?, ?, ?, ?)";
            
        try {
            PreparedStatement ps =con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombMateria());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivoMateria());
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }
    
    public void modificarMateria(Materia materia){
        String sql="UPDATE materia SET nombre= ?, año= ?, estado= ?"
                + "WHERE idMateria= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombMateria());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivoMateria());
            ps.setInt(4, materia.getIdMateria());                        
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Materia modificada");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"); ;
        }
    }
    
    
    public void eliminarMateria(int id){
        String sql="UPDATE materia SET estado=0 WHERE idMateria= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"); ;
        }
    }
    
    
    public Materia buscarMateria(int id){
        String sql="SELECT nombre, año, estado FROM materia WHERE idMateria= ? AND estado=1";
        Materia materia=null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.getGeneratedKeys();
            //int exito=ps.executeUpdate();
            if (rs.next()){
                
                
                materia=new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setNombMateria(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("idMateria"));
                materia.setActivoMateria(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe una materia asociada al id ingresado");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla materia");
        }
        return materia;
    }
    
   public List<Materia> listarMaterias(){
        String sql="SELECT idMateria, nombre, año, estado FROM materia WHERE estado=1";
        ArrayList<Materia> materias=new ArrayList<>();
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setNombMateria(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("idMateria"));
                materia.setActivoMateria(true);
                
                materias.add(materia);
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla materia");
        }
        return materias;
    } 
    
    
    
    
    
    
           
    
    
    
    
    
}
