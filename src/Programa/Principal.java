package Programa;
//programa que me diga si tengo java instalado
//Si es la versión 21 o 22

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        
         File f = new File("C:\\Program Files\\Common Files\\Oracle\\Java\\javapath\\java.exe");
         File f1 = new File("C:\\Program Files\\Java\\jdk-21");
         
         if(f.exists()){
             System.out.println("Si tienes java instalado en el ordenador");
             System.out.println("La version es 21.0.4");
         }else{
             System.out.println("No lo tienes instalado. No existe");
         }
         
          if(f1.exists()){
             System.out.println("Si tienes java instalado en el ordenador");
             System.out.println("La version es 21.0.4");
         }else{
             System.out.println("No lo tienes instalado. No existe");
         }
    }
}

