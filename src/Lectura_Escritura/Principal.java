//REVISAR EL CÓDIGO, NO FUNCIONA BIEN. DEBE DE APARECER EN  CARTA.TXT EL LOS VALORES QUE SE HAN SUSTITUIDOS POR LOS $, ES DECIR, EL NOMBRE, APELLIDO
package Lectura_Escritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);
        File f = new File("plantilla.txt");//Lo que hago es abrir el fichero con el que voy a trabajar. Previamente existe el txt en la carpeta donde trabajo

        String archivoEntrada = "plantilla.txt";
        String archivoSalida = "carta.txt";

        if (f.exists()) {
            System.out.println("El fichero existe");
        } else {
            System.out.println("El fichero no existe");
        }
        System.out.println("__________________________");

        BufferedReader texto = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

        String linea;
        while ((linea = texto.readLine()) != null) {
            if (linea.contains("$")) {
                System.out.println("Introduce tu nombre: ");
                String nombre = teclado.nextLine();
                linea = linea.replaceFirst("\\$", nombre);

                System.out.print("Introduce tu apellido: \n");
                String apellido = teclado.nextLine();
                linea = linea.replaceFirst("\\$", apellido);

                System.out.print("Introduce nombre de tu Jefe: \n");
                String jefe = teclado.nextLine();
                linea = linea.replaceFirst("\\$", apellido);

                System.out.print("Introduce el departamento: \n");
                String dpto = teclado.nextLine();
                linea = linea.replaceFirst("\\$", apellido);
            }

            //Escribir la línea procesada en el nuevo archivo
            escritor.write(linea);
            escritor.newLine(); // Saltar a la siguiente línea en el archivo de salida
            break;
        }
        

        texto.close();
        escritor.close();

    }

}
