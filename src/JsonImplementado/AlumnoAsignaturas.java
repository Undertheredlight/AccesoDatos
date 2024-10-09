package JsonImplementado;

/**
 *
 * @author Liz
 */
public class AlumnoAsignaturas {

    private String nombre;
    private int horas;
    private double nota;

    public AlumnoAsignaturas(String nombre, int horas, double nota) {
        this.nombre = nombre;
        this.horas = horas;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
