
package contraseñas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * Tests de la clase GeneradorContraseñasArchivo
 * @author rperblac
 */
public class GeneradorContraseñasArchivoTest {

    public GeneradorContraseñasArchivoTest() {
    }
    
    @Test
    public void testGeneradorContraseñasArchivo_String() {
        String archivo = "temp.txt";
        GeneradorContraseñasArchivo gca = new GeneradorContraseñasArchivo(archivo);
        assertEquals("contraseñas.GeneradorContraseñasArchivo", gca.getClass().getName());
        try {
            Files.deleteIfExists(Path.of(archivo));
        } catch (IOException ex) {
            System.out.println("Error en archivo :" + ex.getMessage());
        }
    }
    
    @Test
    public void testGeneradorContraseñasArchivo_String_Random() {
        String archivo = "temp.txt";
        Random r = new Random();
        GeneradorContraseñasArchivo gca = new GeneradorContraseñasArchivo(archivo, r);
        assertEquals("contraseñas.GeneradorContraseñasArchivo", gca.getClass().getName());
        try {
            Files.deleteIfExists(Path.of(archivo));
        } catch (IOException ex) {
            System.out.println("Error en archivo :" + ex.getMessage());
        }        
    }

    @Test
    public void testGenerarContraseña() {
        String archivo = "temp.txt";
        GeneradorContraseñasArchivo gca = new GeneradorContraseñasArchivo(archivo);
        String contraseña = gca.generarContraseña(8);
        System.out.print(contraseña + " (Se grabó: ");
        String leida = "";
        try {
            // Abrir archivo para lectura
            FileReader fr = new FileReader(archivo);
            Scanner s = new Scanner(fr);
            // Recorrer hasta la ultima linea
            while (s.hasNext()) {
                leida = s.nextLine();
            }
            System.out.println(leida + ")");
            // Comprobar que la contraseña grabada es la misma que la producida por el método GenerarContraseña()
            assertEquals(contraseña, leida);
            // Cerrar archivo
            s.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura de archivo :" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al cerrar el archivo :" + ex.getMessage());
        }
        try {
            Files.deleteIfExists(Path.of(archivo));
        } catch (IOException ex) {
            System.out.println("Error en archivo :" + ex.getMessage());
        }
    }

}