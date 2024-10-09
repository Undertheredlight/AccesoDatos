package JsonEjercicioCompleto;


/**
 *
 * @author Liz
 */
public class Especies {
    private String nombre;
    private String clasificacion;
    private String designacion;
    private int altura;
    private String colorpiel;
    private String colorpelo;
    private int average_lifespan;
    private String lenguaje;

    public Especies(String nombre, String clasificacion, String designacion, int altura, String colorpiel, String colorpelo, int average_lifespan, String lenguaje) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.designacion = designacion;
        this.altura = altura;
        this.colorpiel = colorpiel;
        this.colorpelo = colorpelo;
        this.average_lifespan = average_lifespan;
        this.lenguaje = lenguaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getDesignacion() {
        return designacion;
    }

    public int getAltura() {
        return altura;
    }

    public String getColorpiel() {
        return colorpiel;
    }

    public String getColorpelo() {
        return colorpelo;
    }

    public int getAverage_lifespan() {
        return average_lifespan;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setColorpiel(String colorpiel) {
        this.colorpiel = colorpiel;
    }

    public void setColorpelo(String colorpelo) {
        this.colorpelo = colorpelo;
    }

    public void setAverage_lifespan(int average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
}
