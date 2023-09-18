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
public class Materias {
    
    private int idMateria;
    private String nombMateria;
    private int anioMateria;
    private boolean activoMateria;

    public Materias() {
    }

    public Materias(int idMateria, String nombMateria, int anioMateria, boolean activoMateria) {
        this.idMateria = idMateria;
        this.nombMateria = nombMateria;
        this.anioMateria = anioMateria;
        this.activoMateria = activoMateria;
    }

    public Materias(String nombMateria, int anioMateria, boolean activoMateria) {
        this.nombMateria = nombMateria;
        this.anioMateria = anioMateria;
        this.activoMateria = activoMateria;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombMateria() {
        return nombMateria;
    }

    public void setNombMateria(String nombMateria) {
        this.nombMateria = nombMateria;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public boolean isActivoMateria() {
        return activoMateria;
    }

    public void setActivoMateria(boolean activoMateria) {
        this.activoMateria = activoMateria;
    }
    
}
