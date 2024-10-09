//Objeto donde se trabajará el JSon
//Va a ser un arraylist
package Json;

/**
 *
 * @author Liz
 */
public class UsuarioAvanzado {
    private String nombre;
    private int edad;

    public UsuarioAvanzado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
