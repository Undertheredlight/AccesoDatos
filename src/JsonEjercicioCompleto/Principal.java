
import JsonEjercicioCompleto.Especies;
import JsonEjercicioCompleto.Peliculas;
import JsonEjercicioCompleto.PersonajeAvanzado;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.json.JSONException;

public class Principal {

    public static void main(String[] args) {
        try {
            //Leer el contenido del archivo JSON
            String contenido = new String(Files.readAllBytes(Paths.get("starwars.json")));
            JSONObject jsonLeido = new JSONObject(contenido);

            //Recuperar datos del proyecto
            String nombreProyecto = jsonLeido.getString("name");
            int heightProyecto = jsonLeido.getInt("height");  // Asegúrate de que es un número
            JSONArray jsonPeliculasLeidas = jsonLeido.getJSONArray("films");

            //Objeto con los datos leídos
            PersonajeAvanzado proyectoLeido = new PersonajeAvanzado(nombreProyecto);
            proyectoLeido.setHeight(heightProyecto);  // Asignar el height leído

            //procesamos peliculas recorriendolas
            for (int i = 0; i < jsonPeliculasLeidas.length(); i++) {
                JSONObject jsonStarwars = jsonPeliculasLeidas.getJSONObject(i);
                String tituloPelicula = jsonStarwars.getString("title");
                int episodioId = jsonStarwars.getInt("episode_id");
                String opening_crawl = jsonStarwars.getString("opening_crawl");
                String director = jsonStarwars.getString("director");

                Peliculas filLeido = new Peliculas(tituloPelicula, episodioId, opening_crawl, director);

                //agurego las peliculas al proyecto
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

          
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}
