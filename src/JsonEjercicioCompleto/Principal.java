
package JsonEjercicioCompleto;


import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) {
        try {
            //Leer el contenido desde un archivo JSON
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("starwars.json")));
            JSONObject jsonLeido = new JSONObject(contenido);

            //Creamos proyecto de participantes
            PersonajeAvanzado proyecto = new PersonajeAvanzado("StarWars");

            //Recuperear datos del proyecto
            String nombreProyecto = jsonLeido.getString("name");
            String heightProyecto = jsonLeido.getString("height");
            JSONArray jsonPeliculasLeidas = jsonLeido.getJSONArray("films");

            //Creamos un proyecto con los datos leídos
            PersonajeAvanzado proyectoLeido = new PersonajeAvanzado(nombreProyecto);

            for (int i = 0; i < jsonPeliculasLeidas.length(); i++) {
                JSONObject jsonStarwars = jsonPeliculasLeidas.getJSONObject(i);
                String tituloPelicula = jsonStarwars.getString("title");
                int episodioId = jsonStarwars.getInt("episode_id");
                String opening_crawl = jsonStarwars.getString("opening_crawl");
                String director = jsonStarwars.getString("director");

                Peliculas filLeido = new Peliculas(tituloPelicula, episodioId, opening_crawl, director);

                //Agrego el ArrayList
                proyectoLeido.agregarPeliculas(filLeido);

                
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
