/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo81;

/**
 *
 * @author claux
 */
public class Inscripcion {
    
    private int idInscripcion;
    private Alumnos alumno;
    private Materias materia;
    private double nota;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, Alumnos alumno, Materias materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(Alumnos alumno, Materias materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String insc= idInscripcion + " " + alumno.getApellido() +", "+ alumno.getNombre() +" "+materia.getNombMateria();
        return insc;
    }
    
    
    
}
