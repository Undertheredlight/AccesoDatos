package PracticaFicherosXMLDOM;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @Liz FP
 */
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("src\\PracticaFicherosXMLDOM\\productos.xml"));

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Empezamos a leer el documento
        NodeList nList = document.getElementsByTagName("producto"); //trabajaré sobre la nodeList

        System.out.println("-.-");

        for (int prod = 0; prod < nList.getLength(); prod++) {
            Node node = nList.item(prod);
            System.out.println(";;");
            System.out.println("REGISTRO "+prod);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Producto id: " + eElement.getAttribute("id"));
                System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Diseño: " + eElement.getElementsByTagName("diseño").item(0).getTextContent());
                System.out.println("Altura: " + eElement.getElementsByTagName("altura").item(0).getTextContent());
                System.out.println("Material: " + eElement.getElementsByTagName("material").item(0).getTextContent());
                System.out.println("Peso: " + eElement.getElementsByTagName("peso").item(0).getTextContent());

            }

        }
        System.out.println(";;;;");

    }

}
