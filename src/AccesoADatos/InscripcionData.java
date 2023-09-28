package AccesoADatos;

import Entidades.Alumno;
import Entidades.Materia;
import Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {
    
    private Connection con=null;
    private final AlumnoData ad=new AlumnoData();
    private final MateriaData md=new MateriaData();
    
    public InscripcionData() {
        con=Conexion.getConexion();
    }
    

    public void guardarInscripcion(Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria)"
                    + "VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            System.out.println("idalumno: "+inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción guardada");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera la tabla inscripciones");
            System.out.println(ex);
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int exito=ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }else if(exito<1){JOptionPane.showMessageDialog(null, "Se actualizó más de una nota");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera la tabla inscripciones");
        }
    }
        
    public void eliminarInscripcion(int idAlumno, int idMateria){
        String sql="DELETE FROM inscripcion WHERE idAlumno= ? AND idMateria= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Inscripción eliminada");
            } else if(exito>1){
                JOptionPane.showMessageDialog(null, "Se eliminó más de una inscripción");
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno"); ;
        }
    }
    
    public List<Inscripcion> listarInscripciones(){
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        String sql="SELECT idInscripcion, nota, idAlumno, idMateria FROM inscripcion";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            
            while (rs.next()){
                Inscripcion insc=new Inscripcion();
                Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                
                inscripciones.add(insc);
                }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return inscripciones;
    }
    
    public List<Inscripcion> listarInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        String sql="SELECT idInscripcion, nota, idAlumno, idMateria FROM inscripcion WHERE idAlumno= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            
            
            while (rs.next()){
                Inscripcion insc=new Inscripcion();
                Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                
                inscripciones.add(insc);
                }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return inscripciones;
    }
    
    public List<Materia> listarMateriasCursadas(int idAlumno){
        ArrayList<Materia> materias=new ArrayList<>();
        String sql="SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia "
                + "WHERE inscripcion.idMateria= materia.idMateria"
                + "AND inscripcion.idAlumno= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombMateria(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        
        return materias;
                
    }
    
    public List<Materia> listarMateriasNoCursadas(int idAlumno){
        ArrayList<Materia> materias=new ArrayList<>();
        String sql="SELECT * FROM materia WHERE estado=1 AND idMateria not in"
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno= ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombMateria(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        
        return materias;
                
    }
    
    public List<Alumno> listarAlumnosPorMateria(int idMateria){
        ArrayList<Alumno> alumnos=new ArrayList<>();
        String sql="SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
                + "FROM inscripcion i, alumno a WHERE i.idAlumno=a.idAlumno AND idMateria= ? AND a.estado=1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre("nombre");
                alumno.setApellido("apellido");
                alumno.setFechNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla");
        }
        return alumnos;
        
    }
    
    }
    
    

