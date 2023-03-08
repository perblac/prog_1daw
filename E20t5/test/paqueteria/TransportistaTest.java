
package paqueteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Transportista
 * @author rperblac
 */
public class TransportistaTest {
    long tiempo = 500;
    Transportista t = new Transportista(tiempo);
    String producto = "cosa";
    String destino = "una casa";
    int prioridad = Paquete.ALTA;
    Paquete p = new Paquete(producto, destino, prioridad);

    public TransportistaTest() {
    }
    
    @Test
    public void testTransportista_long() {
        assertEquals("paqueteria.Transportista", t.getClass().getName());
    }

    @Test
    public void testSubirCamion() {
        t.subirCamion(p);
        ArrayList<Paquete> lista = (ArrayList) t.getPaquetes();
        assertTrue(lista.contains(p));
    }

    @Test
    public void testEnviar() {
        t.subirCamion(p);
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
        t.enviar();
        String cadena = "";
        try {
            Scanner s = new Scanner(test);
            cadena = s.nextLine();
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        String esperada = "El paquete " + p.getProducto() + " con prioridad "
                    + p.getPrioridad() + " ha llegado a: " + p.getDireccionDestino();
        assertEquals(esperada, cadena);        
        salida.close();
        test.delete();
    }

    @Test
    public void testGetPaquetes() {
        t.subirCamion(p);
        assertEquals(1, t.getPaquetes().size());
    }

}