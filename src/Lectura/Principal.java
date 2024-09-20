package Lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {

        //fichero tipo file
        File f = new File("fichero.txt");//Lo que hago es abrir el fichero con el que voy a trabajar. Previamente existe el txt en la carpeta donde trabajo
        //buferedreader + filereader
        BufferedReader texto = new BufferedReader(new FileReader(f));

        //comprobamos si existe el fichero. Para saber si estamos trabajando bien
        if (f.exists()) {
            System.out.println("El fichero existe\n");
        } else {
            System.out.println("No existe el fichero");
        }

        //declaro las variables necesarias para trabajar
        Integer caracteres = 0;
        int veces = 0;
        int caracteresSin = 0;
        double lineasD = 0;
        String parrafoSin;
        String parrafo;
        //empezamos a trabajar en el bucle while
        while ((parrafo = texto.readLine()) != null) {
            veces++;
            caracteres += parrafo.length();
            //trabajo con parrafos sin espacios
            parrafoSin = parrafo;
            parrafoSin = parrafoSin.replace(" ", "");
            caracteresSin += parrafoSin.length();
        }

        lineasD = (double) caracteres / 95;
        System.out.println("Cuantos espacios hay ?? " + lineasD);
        int lineasFinal = (int) Math.ceil(lineasD); //El ceil lo que hace es redondear de 13 a 14
        System.out.println("El total de caracteres en el texto es de: " + caracteres);
        System.out.println("El total de caracteres sin espacios son: " + caracteresSin);
        System.out.println("Numero parrafos: " + veces);
        System.out.println("Numero de lineas: " + lineasFinal);
    }
}
