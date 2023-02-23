
package loterias;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class SorteoTest {

    public SorteoTest() {
    }

    @Test
    public void testGetPrecioCupon() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        assertEquals(precio, s.getPrecioCupon(),0);
    }

    @Test
    public void testGetPagosRealizados() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        s.registrarPago();
        assertEquals(1, s.getPagosRealizados());
    }

    @Test
    public void testGetPagosPendientes() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        assertEquals(personas, s.getPagosPendientes());
    }

    @Test
    public void testGetDineroRecogido() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        s.registrarPago();
        assertEquals(precio, s.getDineroRecogido(),0);
    }

    @Test
    public void testGetTotalParticipantes() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        assertEquals(personas, s.getTotalParticipantes());
    }

    @Test
    public void testRegistrarPago() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        s.registrarPago();
        assertEquals(precio, s.getDineroRecogido(),0);
        assertEquals(personas - 1, s.getPagosPendientes());
        assertEquals(1, s.getPagosRealizados());
    }

    @Test
    public void testApuntarNuevoParticipante() {
        double precio = 100;
        int personas = 10;
        Sorteo s = new Sorteo(precio,personas);
        s.apuntarNuevoParticipante();
        assertEquals(personas + 1, s.getTotalParticipantes());
    }

}