package JsonEjercicioCompleto;

import java.util.ArrayList;

/**
 *
 * @author Liz
 */
public class PersonajeAvanzado {
        private String nombre;
    private int height;
    //tengo que meterle el array de peliculas y el de especies para poder trabajar con el 
    private ArrayList<Peliculas> peliculas;
    private ArrayList<Especies> especies;

    public PersonajeAvanzado(String nombre, int height, ArrayList<Peliculas> peliculas, ArrayList<Especies> especies) {
        this.nombre = nombre;
        this.height = height;
        this.peliculas = peliculas;
        this.especies = especies;
    }

    public PersonajeAvanzado() {
    }

    public PersonajeAvanzado(String nombre) {
        this.nombre = nombre;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Peliculas> getPeliculas() {
        return peliculas;
    }

    public ArrayList<Especies> getEspecies() {
        return especies;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPeliculas(ArrayList<Peliculas> peliculas) {
        this.peliculas = peliculas;
    }

    public void setEspecies(ArrayList<Especies> especies) {
        this.especies = especies;
    }

   //estos métodos delegados añade peliculas al arraylist

    public boolean agregarEspecies(Especies e) {
        return especies.add(e);
    }
    
   public boolean agregarPeliculas(Peliculas e) {
        return peliculas.add(e);
    }
}
