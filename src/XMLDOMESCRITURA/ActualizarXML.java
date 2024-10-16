package XMLDOMESCRITURA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Liz
 */
public class ActualizarXML {

    public static void main(String[] args) throws TransformerConfigurationException, ParserConfigurationException, FileNotFoundException, TransformerException {
        //parseamos el archivo XML existente
        String nombreFichero = "curso"; //nombre del archivo
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document doc = dbBuilder.newDocument();//creamos un nuevo documento

        //creamos la raiz del documento y añadimos atributos
        Element root = doc.createElement("empleados");
        doc.appendChild(root);

        //creamos un nuevo modulo y lo añadimos al curso
        Element modulo = doc.createElement("empleado");
        modulo.setAttribute("Id", "10"); //puedo darle tantos atributos quiera
        root.appendChild(modulo);

        //Añadimos caracteristicas al modulo
        Element nombreModulo = doc.createElement("nombre");
        nombreModulo.appendChild(doc.createTextNode("Marc"));
        modulo.appendChild(nombreModulo);

        Element apellidoModulo = doc.createElement("apellido");
        apellidoModulo.appendChild(doc.createTextNode("Zuckerbeg"));
        modulo.appendChild(apellidoModulo);

        Element ciudadModulo = doc.createElement("ciudad");
        ciudadModulo.appendChild(doc.createTextNode("Florida"));
        modulo.appendChild(ciudadModulo);
        
        //CREAMOS OTRO EMPLEADO
        
        Element modulo2 = doc.createElement("empleado");
        modulo2.setAttribute("Id", "11");
        root.appendChild(modulo2);
        //Añadimos caracteristicas al modulo
        Element nombreModulo2 = doc.createElement("nombre");
        nombreModulo2.appendChild(doc.createTextNode("Liz"));
        modulo2.appendChild(nombreModulo2);

        Element apellidoModulo2 = doc.createElement("apellido");
        apellidoModulo2.appendChild(doc.createTextNode("Contreras"));
        modulo2.appendChild(apellidoModulo2);

        Element ciudadModulo2 = doc.createElement("ciudad");
        ciudadModulo2.appendChild(doc.createTextNode("Caracas"));
        modulo2.appendChild(ciudadModulo2);
        
        

        //Transformamos y escribimos los cambios en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(nombreFichero + ".xml"));
        transformer.transform(source, result);
        System.out.println("Datos introducidos en el archivo: "+nombreFichero+".xml");
    }
}
