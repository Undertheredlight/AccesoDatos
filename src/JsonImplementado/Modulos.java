package JsonImplementado;

import java.util.ArrayList;

/**
 *
 * @author Liz
 */
public class Modulos {

    private String nombre;
    private ArrayList<AlumnoAsignaturas> asignaturas;

    public String getNombre() {
        return nombre;
    }

    public ArrayList<AlumnoAsignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignaturas(ArrayList<AlumnoAsignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Modulos(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList<AlumnoAsignaturas>();
    }

    //este método delegado añade un usuario al arraylist
    public boolean agregarAsignaturas(AlumnoAsignaturas e) {
        return asignaturas.add(e);
    }

}
