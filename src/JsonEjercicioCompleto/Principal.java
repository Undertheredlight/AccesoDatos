package JsonEjercicioCompleto;

import JsonEjercicioCompleto.Especies;
import JsonEjercicioCompleto.Peliculas;
import JsonEjercicioCompleto.PersonajeAvanzado;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.json.JSONException;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) {
        try {

            //Leer el contenido desde un archivo JSON
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("starwars.json")));

            //Leer el contenido del archivo JSON
            String leer = new String(Files.readAllBytes(Paths.get("starwars.json")));

            JSONObject jsonLeido = new JSONObject(contenido);

            //Recuperar datos del proyecto
            String nombreProyecto = jsonLeido.getString("name");
            int heightProyecto = jsonLeido.getInt("height");
            JSONArray jsonPeliculasLeidas = jsonLeido.getJSONArray("films");
            JSONArray jsonEspecieLeidas = jsonLeido.getJSONArray("species");
            
            //Objeto con los datos leídos
            PersonajeAvanzado proyectoLeido = new PersonajeAvanzado(nombreProyecto);
            proyectoLeido.setHeight(heightProyecto);

            //procesamos peliculas recorriendolas
            for (int i = 0; i < jsonPeliculasLeidas.length(); i++) {
                JSONObject jsonStarwars = jsonPeliculasLeidas.getJSONObject(i);
                String tituloPelicula = jsonStarwars.getString("title");
                int episodioId = jsonStarwars.getInt("episode_id");
                String opening_crawl = jsonStarwars.getString("opening_crawl");
                String director = jsonStarwars.getString("director");

                Peliculas filLeido = new Peliculas(tituloPelicula, episodioId, opening_crawl, director);

                //agrego las peliculas al proyecto
                proyectoLeido.agregarPeliculas(filLeido);

            }

            //Imprimo el proyecto
            System.out.println("name: " + proyectoLeido.getNombre());
            System.out.println("height: " + proyectoLeido.getHeight());
            System.out.println("films:");

            //Imprimo peliculas
            for (Peliculas pelicula : proyectoLeido.getPeliculas()) {
                System.out.println("Title: " + pelicula.getTittle()
                        + ",\n Episode_id: " + pelicula.getEpisodio()
                        + ",\n Director: " + pelicula.getDirector());
            }

            //procesamos especies recorriendo
            for (int i = 0; i < jsonEspecieLeidas.length(); i++) {
                JSONObject jsonStarwars = jsonEspecieLeidas.getJSONObject(i);
                String nombreespecie = jsonStarwars.getString("name");
                String classification = jsonStarwars.getString("classification");
                String designation = jsonStarwars.getString("designation");
                int average_height = jsonStarwars.getInt("average_height");
                String skin_colors = jsonStarwars.getString("skin_colors");
                String hair_colors = jsonStarwars.getString("hair_colors");
                int average_lifespan = jsonStarwars.getInt("average_lifespan");
                String language = jsonStarwars.getString("language");

                Especies filLeido = new Especies(nombreespecie, classification, designation, i, contenido, contenido, average_lifespan, language);

                //agrego las especies al proyecto
                proyectoLeido.agregarEspecies(filLeido);
            }

            //Imprimo especies
            System.out.println("species: ");

            for (Especies especie : proyectoLeido.getEspecies()) {
                System.out.println("name " + especie.getNombre()
                        + " classification: " + especie.getClasificacion()
                        + " designation : " + especie.getDesignacion()
                        + "average_height: " + especie.getAverage_lifespan()
                        + "skin_colors: " + especie.getColorpiel()
                        + " hair_colors: " + especie.getColorpelo()
                        + " average_lifespan: " + especie.getAverage_lifespan()
                        + " language: " + especie.getLenguaje()
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}
