package JsonImplementado;

import Json.Proyecto;
import Json.UsuarioAvanzado;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) {
        //Creamos asignaturas

        AlumnoAsignaturas asignatura1 = new AlumnoAsignaturas("Acceso a Datos", 6, 8.45);
        AlumnoAsignaturas asignatura2 = new AlumnoAsignaturas("Progrmación PSP", 3, 9.0);

        //Creamos proyecto de asignaturas
        Modulos proyecto = new Modulos("Asignaturas");
        proyecto.agregarAsignaturas(asignatura1);
        proyecto.agregarAsignaturas(asignatura2);

        //Convertir el proyecto a un JSONObject
        JSONObject JsonProyecto = new JSONObject();
        JsonProyecto.put("Nombre", proyecto.getNombre());

        JSONArray jsonParticipantes = new JSONArray();
        for (AlumnoAsignaturas asignatura : proyecto.getAsignaturas()) {
            JSONObject jsonAsignatura = new JSONObject();
            jsonAsignatura.put("nombre", asignatura.getNombre());
            jsonAsignatura.put("horas", asignatura.getHoras());
            jsonAsignatura.put("nota", asignatura.getNota());
            jsonParticipantes.put(jsonAsignatura);
        }
        JsonProyecto.put("participantes", jsonParticipantes);

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("proyecto.json"), JsonProyecto.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
