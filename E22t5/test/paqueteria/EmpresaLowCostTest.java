
package paqueteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase EmpresaLowCost
 * @author rperblac
 */
public class EmpresaLowCostTest {
    EmpresaLowCost elc = new EmpresaLowCost(2);
    String producto1 = "cosa sin importancia";
    String direccion1 = "un sitio cerca";
    int prioridad1 = Paquete.BAJA;
    Paquete p1 = new Paquete(producto1, direccion1, prioridad1);
    String producto2 = "cosa normal";
    String direccion2 = "otro sitio a medio camino";
    int prioridad2 = Paquete.MEDIA;
    Paquete p2 = new Paquete(producto2, direccion2, prioridad2);
    String producto3 = "cosa importante";
    String direccion3 = "un sitio lejos";
    int prioridad3 = Paquete.ALTA;
    Paquete p3 = new Paquete(producto3, direccion3, prioridad3); 

    public EmpresaLowCostTest() {
    }
    
    @Test
    public void testEmpresaLowCost_int() {
        assertEquals("paqueteria.EmpresaLowCost", elc.getClass().getName());
    }

    @Test
    public void testRegistrarPedido() {
        elc.registrarPedido(p1);
        elc.registrarPedido(p2);
        elc.registrarPedido(p3);
        assertEquals(p1, elc.getTransportistas().get(0).getPaquetes().get(0));
        assertEquals(p2, elc.getTransportistas().get(1).getPaquetes().get(0));
        assertEquals(p3, elc.getTransportistas().get(0).getPaquetes().get(1));
    }

    @Test
    public void testGetTransportistas() {
        assertEquals(2, elc.getTransportistas().size());
    }

    @Test
    public void testEnviarPaquetes() {
        elc.registrarPedido(p3);
        elc.registrarPedido(p2);
        elc.registrarPedido(p1);
        String esperada1 = "El paquete " + p3.getProducto() + " con prioridad "
                    + p3.getPrioridad() + " ha llegado a: " + p3.getDireccionDestino();
        String esperada2 = "El paquete " + p1.getProducto() + " con prioridad "
                    + p1.getPrioridad() + " ha llegado a: " + p1.getDireccionDestino();
        String esperada3 = "El paquete " + p2.getProducto() + " con prioridad "
                    + p2.getPrioridad() + " ha llegado a: " + p2.getDireccionDestino();
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
        elc.enviarPaquetes();
        String cadena1 = "";
        String cadena2 = "";
        String cadena3 = "";
        try {
            Scanner s = new Scanner(test);
            cadena1 = s.nextLine();
            cadena2 = s.nextLine();
            cadena3 = s.nextLine();
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudo crear el archivo de test" + ex.getMessage());
            fail("Error en el test (creación de archivo test.txt para Scanner)");
        }
        assertEquals(esperada1, cadena1);
        assertEquals(esperada2, cadena2);
        assertEquals(esperada3, cadena3);
        salida.close();
        //test.delete();
    }

}