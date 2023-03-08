
package paqueteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase PaquetesPepe
 * @author rperblac
 */
public class PaquetesPepeTest {
    PaquetesPepe pp = new PaquetesPepe();
    String producto = "cosa normal";
    String direccion = "un sitio";
    int prioridad = Paquete.MEDIA;
    Paquete p = new Paquete(producto, direccion, prioridad);

    public PaquetesPepeTest() {
    }
    
    @Test
    public void testPaquetesPepe() {
        assertEquals("paqueteria.PaquetesPepe", pp.getClass().getName());
    }

    @Test
    public void testRegistrarPedido() {
        pp.registrarPedido(p);
        assertTrue(pp.getTransportistas().get(0).getPaquetes().contains(p));
    }

    @Test
    public void testGetTransportistas() {
        List<Transportista> lista = pp.getTransportistas();
        assertEquals(1, lista.size());
    }

    @Test
    public void testEnviarPaquetes() {
        pp.registrarPedido(p);
        String esperada = "El paquete " + p.getProducto() + " con prioridad "
                    + p.getPrioridad() + " ha llegado a: " + p.getDireccionDestino();
        File test = null;
        try {
            test = File.createTempFile("test", ".txt");
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
        pp.enviarPaquetes();
        String cadena = "";
        try {
            Scanner s = new Scanner(test);
            cadena = s.nextLine();
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(esperada, cadena);        
        salida.close();
        test.delete();
    }

}