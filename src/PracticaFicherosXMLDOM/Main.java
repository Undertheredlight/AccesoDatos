package PracticaFicherosXMLDOM;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Main {

    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File archivoXML = new File("productos.xml");
            
            // Configuración del parser de XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();
            
            // Obtener la lista de elementos "producto"
            NodeList nList = doc.getElementsByTagName("producto");

            // Escribir en la consola el nombre de la tabla
            System.out.println("Productos");
            System.out.println("-.-");  // Indica que empiezan los registros
            
            // Iterar sobre cada producto y mostrar los datos en consola
            for (int i = 0; i < nList.getLength(); i++) {
                Element producto = (Element) nList.item(i);
                
                // Obtener los valores de los campos
                String id = producto.getElementsByTagName("id").item(0).getTextContent();
                String nombre = producto.getElementsByTagName("nombre").item(0).getTextContent();
                String diseno = producto.getElementsByTagName("diseno").item(0).getTextContent();
                String altura = producto.getElementsByTagName("altura").item(0).getTextContent();
                String material = producto.getElementsByTagName("material").item(0).getTextContent();
                String peso = producto.getElementsByTagName("peso").item(0).getTextContent();
                
                // Formatear el registro en una línea
                System.out.println(id + "," + nombre + "," + diseno + "," + altura + "," + material + "," + peso);
                
                // Agregar el separador ;;
                if (i < nList.getLength() - 1) {
                    System.out.println(";;");  // Si no es el último registro, usa ;;
                } else {
                    System.out.println(";;;;");  // Si es el último registro, usa ;;;;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
