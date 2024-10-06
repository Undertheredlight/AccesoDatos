package XMLDOMLECTURA;

import XMLDOMESCRITURA.Empleado;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import org.xml.sax.SAXException;

/**
 *
 * @Liz FP
 */
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Creamos el objeto DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //creamos el objeto document con el archivo xml
        Document document = builder.parse(new File("src\\XMLDOMLECTURA\\empleados.xml")); //Empieza desde la raiz por lo que debo de indicar la ruta de donde se encuentre

        //Validamos la estructura del documento. MUY IMPORTANTE
        document.getDocumentElement().normalize();

        //extraer el nodo/elemento raiz. Si imprime empleado, significa que está bien
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        
        //creamos un arraylist para agregar a los empleados, proveniente de los nodos
        //<Empleado> listaEmpleados = new ArrayList<Empleado>();
        
        //a partir de aqui vamos a leer el documento
        NodeList nList = document.getElementsByTagName("empleado"); //trabajo sobre la nodeList
        System.out.println("===========================");
        
        
 
        for (int emp = 0; emp < nList.getLength(); emp++) {
            Node node = nList.item(emp);
            System.out.println("");

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Empleado id : " + eElement.getAttribute("id"));
                System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Apellidos :" + eElement.getElementsByTagName("apellidos").item(0).getTextContent());
                System.out.println("Ciudad :" + eElement.getElementsByTagName("ciudad").item(0).getTextContent());
            }
        }
    }
}
