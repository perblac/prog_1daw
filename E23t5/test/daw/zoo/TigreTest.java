
package daw.zoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase Tigre
 * @author rperblac
 */
public class TigreTest {

    public TigreTest() {
    }

    @Test
    public void testTigre_String_int() {
        Tigre ai = new Tigre("",0);
        assertEquals("daw.zoo.Tigre", ai.getClass().getName());
    }
    
    @Test
    public void testEmitirSonido() {
        // Mensaje esperado en consola
        String mensaje = "RUAAAH!";
        
        // Redirigir salida de consola a un archivo de prueba
        File test = null;
        try {
            test = File.createTempFile("test", "txt");
        } catch (IOException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt temporal");
        }
        PrintStream salida = null;
        try {
            salida = new PrintStream(test);
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para PrintStream)");
        }
        System.setOut(salida);
        
        // probar método emitirSonido()
        Tigre ai = new Tigre("",0);
        ai.emitirSonido();
        
        // Leer archivo de prueba para recuperar cadena impresa por el método
        String cadena = "";
        try {
            Scanner s = new Scanner(test);
            cadena = s.nextLine();
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(mensaje, cadena);
        
        // Cerrar y borrar archivo
        salida.close();
        test.delete();
    }

}