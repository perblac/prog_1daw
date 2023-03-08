
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
 * Tests de la clase TransportistaOrdenado
 * @author rperblac
 */
public class TransportistaOrdenadoTest {

    long tiempo = 500;
    TransportistaOrdenado to = new TransportistaOrdenado(tiempo);
    String producto = "cosa normal";
    String destino = "una casa";
    int prioridad = Paquete.MEDIA;
    Paquete p1 = new Paquete(producto, destino, prioridad);
    String producto2 = "cosa importante";
    String destino2 = "una casa";
    int prioridad2 = Paquete.ALTA;
    Paquete p2 = new Paquete(producto2, destino2, prioridad2);
    
    public TransportistaOrdenadoTest() {
    }    
    
    @Test
    public void testTransportistaOrdenado_long() {
        assertEquals("paqueteria.TransportistaOrdenado", to.getClass().getName());
    }

    @Test
    public void testSubirCamion() {
        to.subirCamion(p1);
        ArrayList<Paquete> lista = (ArrayList) to.getPaquetes();
        assertTrue(lista.contains(p1));
    }

    @Test
    public void testEnviar() {
        to.subirCamion(p1); // cosa normal
        to.subirCamion(p2); // cosa importante
        String esperada1 = "El paquete " + p2.getProducto() + " con prioridad "
                    + p2.getPrioridad() + " ha llegado a: " + p2.getDireccionDestino();
        String esperada2 = "El paquete " + p1.getProducto() + " con prioridad "
                    + p1.getPrioridad() + " ha llegado a: " + p1.getDireccionDestino();
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
        to.enviar();
        String cadena1 = "";
        String cadena2 = "";
        try {
            Scanner s = new Scanner(test);
            cadena1 = s.nextLine();
            cadena2 = s.nextLine();
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(esperada1, cadena1);
        assertEquals(esperada2, cadena2);    
        salida.close();
        test.delete();
    }

    @Test
    public void testGetPaquetes() {
    }

}