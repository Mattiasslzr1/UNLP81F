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
//        AlumnoData ad=new AlumnoData();
//        MateriaData md=new MateriaData();
//        InscripcionData id=new InscripcionData();
//        Alumno alu=new Alumno();
//        Materia mate=new Materia();
//        Inscripcion insc=new Inscripcion();
//          
        

        Alumno juan = new Alumno(32245678, "Registrode", "Pruebasincontraseña", LocalDate.of(1980, 4, 13), true);
        AlumnoData alu=new AlumnoData();
//        Alumno diego = new Alumno(32245648, "Salguero", "Diego", LocalDate.of(1980, 4, 13), true);
//        AlumnoData alu=new AlumnoData();


        //  ABM ALUMNOS
//       alu.guardarAlumno(diego);              //chequeado
//        alu.modificarAlumno();            //chequeado
//        alu.eliminarAlumno();             //chequeado
//
        //  BUSCAR ALUMNO
//        Alumno alumnoEncontrado=alu.buscarAlumno(9);                  //chequeado
//        if(alumnoEncontrado!=null){
//            System.out.println("dni "+alumnoEncontrado.getDni());
//            System.out.println("apellido "+alumnoEncontrado.getApellido());
//            System.out.println("nombre "+alumnoEncontrado.getNombre());
//        }
//        
        //  LISTAR ALUMNOS
//        for(Alumno alumno:alu.listarAlumnos()){           //chequeado
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getFechNac());
//        }
//
//        
        Materia materia= new Materia(7, "Programachion", 1, true);
        MateriaData md=new MateriaData();

        //  ABM MATERIAS
 //       md.guardarMateria(materia);          //chequeado
//        md.modificarMateria();                //chequeado
//        md.eliminarMateria();                 //chequeado

        //  BUSCAR MATERIA
//        Materia materiaEncontrada=md.buscarMateria(7);        //chequedao
//        if(materiaEncontrada!=null){
//            System.out.println("id  "+materiaEncontrada.getIdMateria());
//            System.out.println("año "+materiaEncontrada.getAnioMateria());
//            System.out.println("nombre "+materiaEncontrada.getNombMateria());
//        }

        InscripcionData id=new InscripcionData();
        Inscripcion insc=new Inscripcion(juan, materia, 9); //constructor que toma Alumno, Materia y nota

        //  ABM INSCRIPCIONES
//        id.guardarInscripcion(insc);      //chequeado
//        id.actualizarNota(9, 7, 4);       //chequeado
//        id.eliminarInscripcion(9, 7);     //chequeado

//        //  LISTAR INSCRIPCIONES 
//        for (Inscripcion inscripcion:id.listarInscripciones()){       //chequeado
//            System.out.println("id: "+inscripcion.getIdInscripcion());
//            System.out.println("Nombre: "+inscripcion.getAlumno().getNombre());
//            System.out.println("Apellido: "+inscripcion.getAlumno().getApellido());
//            System.out.println("Materia: "+inscripcion.getMateria().getNombMateria());
//            System.out.println("Nota: "+inscripcion.getNota());
//            
//        }
//        
        








}    
}
    

