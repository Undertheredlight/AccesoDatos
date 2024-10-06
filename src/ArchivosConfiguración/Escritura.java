
package ArchivosConfiguración;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @Liz FP
 */
public class Escritura {
    public static void main(String[] args) {
        //declaramos variables
        String miUsuario = "root";
        String miContraseña ="p@ssword";
        String elServidor = "goldengate.tk";
        String elPuerto = "3306";
        
        Properties configuracion = new Properties();
        configuracion.setProperty("user", miUsuario);
        configuracion.setProperty("password", miContraseña);
        configuracion.setProperty("server", elServidor);
        configuracion.setProperty("port", elPuerto);
        
        
        try{
            configuracion.store(new FileOutputStream("config.pass"),
                    "fichero de configuracion");
            
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(IOException ioe){
           ioe.printStackTrace(); 
        }
        
    }
}
