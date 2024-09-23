package ArchivosConfiguración;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @Liz FP
 */
public class Lectura {

    public static void main(String[] args) {

        String miUsuario, miContraseña, elServidor;
        Integer elPuerto;

        Properties configuracion = new Properties();

        try {
            configuracion.load(new FileInputStream("config.pass"));
            miUsuario = configuracion.getProperty("user");
            miContraseña = configuracion.getProperty("password");
            elServidor = configuracion.getProperty("server");
            elPuerto = Integer.valueOf(configuracion.getProperty("port"));
            System.out.println(miUsuario);
            System.out.println(miContraseña);
            System.out.println(elServidor);
            System.out.println(elPuerto);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
