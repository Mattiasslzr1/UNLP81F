/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.time.LocalDate;

/**
 *
 * @author TheOf
 */
public class UniversisdadGrupo81 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Todo esto es para testear que funcionan los métodos de AlumnoData
        
        Alumno juan = new Alumno(12345678, "Pérez", "Juan", LocalDate.of(1980, 4, 13), true);
        AlumnoData alu=new AlumnoData();
        System.out.println("En el main");
        alu.guardarAlumno(juan);              
//        alu.modificarAlumno(juan);
//        alu.eliminarAlumno(1);
//
//        Alumno alumnoEncontrado=alu.buscarAlumno(1);
//        if(alumnoEncontrado!=null){
//            System.out.println("dni "+alumnoEncontrado.getDni());
//            System.out.println("apellido "+alumnoEncontrado.getApellido());
//            System.out.println("nombre "+alumnoEncontrado.getNombre());
//        }
//        
//        AlumnoData alu= new AlumnoData();
//        for(Alumno alumno:alu.listarAlumnos()){
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechNac());
//        }
//        // Todo esto es para testear que funcionan los métodos de InscripcionData
//
        AlumnoData ad=new AlumnoData();
        MateriaData md=new MateriaData();
        InscripcionData id=new InscripcionData();
//        
//        Alumno ricardo=ad.buscarAlumno(2);  //el 2 es el id que va a buscar
//        Materia mate=md.buscarMateria(2);
//        Inscripcion insc=new Inscripcion(ricardo, mate, 9); //constructor que toma Alumno, Materia (creados mas arriba) y nota
//        id.guardarInscripcion(insc);
//        id.actualizarNota(2, 2, 9);
//        id.eliminarInscripcion(2, 2);
//        for (Inscripcion inscripcion:id.listarInscripciones()){
//            System.out.println("id: "+inscripcion.getIdInscripcion());
//            System.out.println("Nombre: "+inscripcion.getAlumno().getNombre());
//            System.out.println("Apellido: "+inscripcion.getAlumno().getApellido());
//            System.out.println("Materia: "+inscripcion.getMateria().getNombMateria());
//            System.out.println("Nota: "+inscripcion.getNota());
//            
//        }
        
        








}    
}
    

