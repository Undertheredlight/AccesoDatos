package ClaseFile;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        File f = new File("WINDOWS\\fornite.xml");
        
        System.out.println("Nombre "+f.getName());
        System.out.println("Ruta absoluta "+f.getAbsolutePath());
        System.out.println("Directorio padre "+f.getParent());
        System.out.println("Directorio padre "+f.getPath());
        
        //utilizar metodos para saber si existe el fichero
        //si es un directorio
        
        //isDirectory()
        if (f.exists()){
            System.out.println("El directorio existe");
        }else{
            System.out.println("No existe el directorio");
        } 
        
    }
}
