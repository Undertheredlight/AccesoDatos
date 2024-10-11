
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
    * @Liz FP
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);
        File f = new File("plantilla.txt");

        String archivoEntrada = "plantilla.txt";
        String archivoSalida = "carta.txt";

        if (f.exists()) {
            System.out.println("El fichero existe");
        } else {
            System.out.println("El fichero no existe");
            return; // Si no existe, salir del programa
        }
        System.out.println("__________________________");
        
        
        // Solicitar datos una sola vez al inicio
        System.out.println("Introduce tu nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Introduce tu apellido: ");
        String apellido = teclado.nextLine();

        System.out.println("Introduce nombre de tu jefe: ");
        String jefe = teclado.nextLine();

        System.out.println("Introduce el departamento: ");
        String dpto = teclado.nextLine();
        
         // Leer el archivo de entrada y escribir en el archivo de salida
        BufferedReader texto = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

        String linea;
        while ((linea = texto.readLine()) != null) {
            // Reemplazar los placeholders en la línea actual
            if (linea.contains("$")) {
                linea = linea.replaceFirst("$nombre", nombre);
                linea = linea.replaceFirst("$apellido", apellido);
                linea = linea.replaceFirst("$jefe", jefe);
                linea = linea.replaceFirst("$departamento", dpto);
            }

            // Escribir la línea procesada en el nuevo archivo
            escritor.write(linea);
            escritor.newLine(); // Saltar a la siguiente línea en el archivo de salida
        }

        // Cerrar los flujos de lectura y escritura
        texto.close();
        escritor.close();

        System.out.println("Archivo procesado correctamente. Salida en: " + archivoSalida);
        
        
        
        
    }
}
