//creamos un participantes y un proyecto de usuarioAvanzado
package Json;


import java.util.ArrayList;

/**
 *
 * @author Liz
 */
public class Proyecto {

    private String nombre;
    private ArrayList<UsuarioAvanzado> participantes;

    public String getNombre() {
        return nombre;
    }

    public ArrayList<UsuarioAvanzado> getParticipantes() {
        return participantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setParticipantes(ArrayList<UsuarioAvanzado> participantes) {
        this.participantes = participantes;
    }

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<UsuarioAvanzado>();
    }

    //este método delegado añade un usuario al arraylist
    public boolean agregarParticipante(UsuarioAvanzado e) {
        return participantes.add(e);
    }

}
