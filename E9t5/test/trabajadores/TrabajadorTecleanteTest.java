
package trabajadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase TrabajadorTecleante
 * @author rperblac
 */
public class TrabajadorTecleanteTest {
    
    String nombre = "Paco";
    int sueldo = 1000;
    int numDNI = 12345678;
    char letraDNI = 'Z';
    int ppm = 150;
    Teclado tj = new TecladoJava();
    TrabajadorTecleante tt = new TrabajadorTecleante(nombre, sueldo, numDNI, letraDNI, ppm);

    public TrabajadorTecleanteTest() {
    }
    
    @Test
    public void testTrabajadorTecleante_String_int_int_char_int() {
        assertEquals("trabajadores.TrabajadorTecleante", tt.getClass().getName());
    }

    @Test
    public void testSetTeclado() {
        tt.setTeclado(tj);
        assertEquals(tj, tt.getTeclado());
    }

    @Test
    public void testGetTeclado() {
        assertEquals(null, tt.getTeclado());
        tt.setTeclado(tj);
        assertEquals(tj, tt.getTeclado());
    }

    @Test
    public void testGetPulsacionesMinuto() {
        assertEquals(ppm, tt.getPulsacionesMinuto());
    }

    @Test
    public void testEscribirTexto() {
        String mensaje = "prueba";
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
        tt.escribirTexto(mensaje);
        String cadena = "";
        try {
            cadena = new Scanner(test).nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(cadena, mensaje);
        tt.escribirTexto(mensaje);
        salida.close();
        test.delete();
    }

}