
package trabajadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Administrativo
 * @author rperblac
 */
public class AdministrativoTest {
    
    String nombre = "Paco";
    int sueldo = 1000;
    int numDNI = 12345678;
    char letraDNI = 'Z';
    int ppm = 150;
    Teclado tj = new TecladoJava();
    Administrativo a = new Administrativo(nombre, sueldo, numDNI, letraDNI, ppm);

    public AdministrativoTest() {
    }
    
    @Test
    public void testAdministrativo_String_int_int_char_int() {
        assertEquals("trabajadores.Administrativo", a.getClass().getName());        
    }

    @Test
    public void testEscribirInforme() {
        a.setTeclado(tj);
        String informe = "informe de prueba";
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
        a.escribirInforme(informe);
        String infCompleto = a.getFechaUltimoInforme().toString() + " " + informe;
        String cadena = "";
        try {
            cadena = new Scanner(test).nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(cadena, infCompleto);
        a.escribirInforme(informe);
        salida.close();
        test.delete();
    }

}