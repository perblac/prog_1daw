
package trabajadores;

import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase TecladoJava
 * @author rperblac
 */
public class TecladoJavaTest {

    public TecladoJavaTest() {
    }
    
    @Test
    public void testTecladoJava() {
        TecladoJava tj = new TecladoJava();
        assertEquals("trabajadores.TecladoJava", tj.getClass().getName());
    }

    @Test
    public void testEscribirTexto() {
        String mensaje = "prueba";        
        TecladoJava tj = new TecladoJava();
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
        tj.escribirTexto(mensaje);
        String cadena = "";
        try {
            cadena = new Scanner(test).nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(cadena, mensaje);
        tj.escribirTexto(mensaje);
        salida.close();
        test.delete();
    }

}