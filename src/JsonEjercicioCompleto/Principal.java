package JsonEjercicioCompleto;

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
            String contenido = new String(Files.readAllBytes(Paths.get("starwars.json")));

            //Crea un objeto JSONObject a partir de una cadena de texto que representa un objeto JSON.
            JSONObject jsonLeido = new JSONObject(contenido);

            //Recuperar datos del proyecto
            String nombreProyecto = jsonLeido.getString("name");
            int heightProyecto = jsonLeido.getInt("height");
            JSONArray jsonPeliculasLeidas = jsonLeido.getJSONArray("films");
            JSONArray jsonEspecieLeidas = jsonLeido.getJSONArray("species");

            //Objeto con los datos leídos
            PersonajeAvanzado proyectoLeido = new PersonajeAvanzado(nombreProyecto);
            proyectoLeido.setHeight(heightProyecto);

            //Procesamos películas recorriéndolas
            for (int i = 0; i < jsonPeliculasLeidas.length(); i++) {
                JSONObject jsonPelicula = jsonPeliculasLeidas.getJSONObject(i);
                String tituloPelicula = jsonPelicula.getString("title");
                int episodioId = jsonPelicula.getInt("episode_id");
                String openingCrawl = jsonPelicula.getString("opening_crawl");
                String director = jsonPelicula.getString("director");
                
                Peliculas peliculaLeida = new Peliculas(tituloPelicula, episodioId, openingCrawl, director);

                //Agrego las películas al proyecto
                proyectoLeido.agregarPeliculas(peliculaLeida);
            }

            //Imprimo el proyecto
            System.out.println("name: " + proyectoLeido.getNombre());
            System.out.println("height: " + proyectoLeido.getHeight());
            System.out.println("films:");

            //Imprimo películas
            for (Peliculas pelicula : proyectoLeido.getPeliculas()) {
                System.out.println("Title: " + pelicula.getTittle()
                        + ",\n Episode_id: " + pelicula.getEpisodio()
                        +",\n Opening_crawl:" + pelicula.getOpening_crawl()
                        + ",\n Director: " + pelicula.getDirector()+"\n");
            }

            //Procesamos especies recorriendo
            for (int i = 0; i < jsonEspecieLeidas.length(); i++) {
                JSONObject jsonEspecie = jsonEspecieLeidas.getJSONObject(i);
                String nombreEspecie = jsonEspecie.getString("name");
                String classification = jsonEspecie.getString("classification");
                String designation = jsonEspecie.getString("designation");
                int averageHeight = jsonEspecie.getInt("average_height");
                String skinColors = jsonEspecie.getString("skin_colors");
                String hairColors = jsonEspecie.getString("hair_colors");
                int averageLifespan = jsonEspecie.getInt("average_lifespan");
                String language = jsonEspecie.getString("language");

                Especies especieLeida = new Especies(nombreEspecie, classification, designation, averageHeight, skinColors, hairColors, averageLifespan, language);

                //Agrego las especies al proyecto
                proyectoLeido.agregarEspecies(especieLeida);
            }

            //Imprimo especies
            System.out.println("species: ");
            for (Especies especie : proyectoLeido.getEspecies()) {
                System.out.println("name: " + especie.getNombre()
                        + ",\n classification: " + especie.getClasificacion()
                        + ",\n designation: " + especie.getDesignacion()
                        + ",\n average_height: " + especie.getAltura()
                        + ",\n skin_colors: " + especie.getColorpiel()
                        + ",\n hair_colors: " + especie.getColorpelo()
                        + ",\n average_lifespan: " + especie.getAverage_lifespan()
                        + ",\n language: " + especie.getLenguaje());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}
