package Json;

import org.json.*;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) {
        //Creamos usuarios
        UsuarioAvanzado usuario1 = new UsuarioAvanzado("Jude Bellingham", 21);
        UsuarioAvanzado usuario2 = new UsuarioAvanzado("Kyliam Mbappe", 25);

        //Creamos proyecto de participantes
        Proyecto proyecto = new Proyecto("Copa de Europa 24/25");
        proyecto.agregarParticipante(usuario1);
        proyecto.agregarParticipante(usuario2);

        //Convertir el proyecto a un JSONObject
        JSONObject JsonProyecto = new JSONObject();
        JsonProyecto.put("Nombre", proyecto.getNombre());

        JSONArray jsonParticipantes = new JSONArray();
        for (UsuarioAvanzado participante : proyecto.getParticipantes()) {
            JSONObject jsonParticipante = new JSONObject();
            jsonParticipante.put("nombre", participante.getNombre());
            jsonParticipante.put("edad", participante.getEdad());
            jsonParticipantes.put(jsonParticipante);
        }
        JsonProyecto.put("participantes", jsonParticipantes);

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("proyecto.json"), JsonProyecto.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //TERMINAMOS ESCRITURA Y EN OTRA CLASE VAMOS A LEER
        try {
            //Leer el contenido desde un archivo JSON
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("proyecto.json")));
            JSONObject jsonLeido = new JSONObject(contenido);

            //Recuperear datos del proyecto
            String nombreProyecto = jsonLeido.getString("Nombre");
            JSONArray jsonParticipantesLeidos = jsonLeido.getJSONArray("participantes");

            //Creamos un proyecto con los datos leídos
            Proyecto proyectoLeido = new Proyecto(nombreProyecto);

            //Agregar participantes al proyecto
            for (int i = 0; i < jsonParticipantesLeidos.length(); i++) {
                JSONObject jsonParticipante = jsonParticipantesLeidos.getJSONObject(i);
                String nombreParticipante = jsonParticipante.getString("nombre");
                int edadParticipante = jsonParticipante.getInt("edad");

                UsuarioAvanzado participanteLeido = new UsuarioAvanzado(nombreParticipante, edadParticipante);

                //Agrego el ArrayList
                proyectoLeido.agregarParticipante(participanteLeido);

            }

            //Realizamos operaciones con el proyecto leído
            System.out.println("Proyecto: " + proyectoLeido.getNombre());
            System.out.println("Participantes: ");
            //Muestro el Arraylist generado para visualizar el Json
            for (UsuarioAvanzado participante : proyectoLeido.getParticipantes()) {
                System.out.println("- " + participante.getNombre()
                        + ", Edad: " + participante.getEdad());
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
