
package daw.zoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Animal
 * @author rperblac
 */
public class AnimalTest {
    String nombre = "Michi";
    int peso = 100;
    Leon a = new Leon(nombre, peso);

    public AnimalTest() {
    }

    @Test
    public void testGetNombre() {
        assertEquals(nombre, a.getNombre());
    }

    @Test
    public void testGetPeso() {
        assertEquals(peso, a.getPeso());
    }

    @Test
    public void testIsEncerrado() {
        assertFalse(a.isEncerrado());
    }

    @Test
    public void testSetEncerrado() {
        a.setEncerrado(true);
        assertTrue(a.isEncerrado());
    }

    @Test
    public void testToString() {
        String s = nombre + ", " + peso + " kg.";
        assertEquals(s, a.toString());
    }

    @Test
    public void testEquals() {
        int peso2 = 90;
        Leon b = new Leon(nombre, peso2);
        assertTrue(a.equals(b));
    }

    @Test
    public void testHashCode() {
        int h = 3 + 7*nombre.hashCode() + 11*peso;
        assertEquals(h, a.hashCode());
    }

    @Test
    public void testEmitirSonido() {
        // Mensaje esperado en consola
        String mensaje = "aaa";
        
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
        AnimalImpl ai = new AnimalImpl();
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

    public class AnimalImpl extends Animal {

        public AnimalImpl() {
            super("", 0);
        }

        public void emitirSonido() {
            System.out.println("aaa");
        }
    }

}