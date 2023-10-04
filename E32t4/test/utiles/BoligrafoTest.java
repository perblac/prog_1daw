
package utiles;

import bpc.daw.consola.*;
import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class BoligrafoTest {
    
    public BoligrafoTest() {
    }
    
    /* Con los test independietes me daba errores que no supe resolver
    @Test
    public void testBoligrafo_CapaTexto() {    
        
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Boligrafo b = new Boligrafo(ct);
               
        assertEquals("utiles.Boligrafo", b.getClass().getName());
    }

    @Test
    public void testSetColor() {
        
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Teclado t = co.getTeclado();
        Boligrafo b = new Boligrafo(ct);
                
        b.setColor(1);
        ct.print("El siguiente texto debe ser verde:\n");
        b.escribir("Texto verde");
        assertEquals(ct.getColorTexto(), Color.GREEN);
        t.leerCaracter();
        ct.cls();
        
    }

    @Test
    public void testEscribir() {
        
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Teclado t = co.getTeclado();
        Boligrafo b = new Boligrafo(ct);
        
        Double col = 7.0;
        Double fila = 0.0;
        b.escribir("7letras");
        assertEquals(col,ct.getPosicion().getX(),0);
        assertEquals(fila, ct.getPosicion().getY(),0);        
        t.leerCaracter();
        ct.cls();
    }

    @Test
    public void testEscribirGuay() {
        
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Teclado t = co.getTeclado();
        Boligrafo b = new Boligrafo(ct);
        
        b.escribirGuay("R");
        assertEquals(ct.getColorTexto(), Color.RED);
        b.escribirGuay("V");
        assertEquals(ct.getColorTexto(), Color.GREEN);
        b.escribirGuay("A");
        assertEquals(ct.getColorTexto(), Color.BLUE);
        b.escribirGuay("B");
        assertEquals(ct.getColorTexto(), Color.WHITE);
        b.escribirGuay("A");
        assertEquals(ct.getColorTexto(), Color.YELLOW);        
        t.leerCaracter();
        ct.cls();
    }
    */
    
    @Test
    public void testBoligrafo_CapaTexto() {    
        
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Teclado t = co.getTeclado();
        Boligrafo b = new Boligrafo(ct);
               
        assertEquals("utiles.Boligrafo", b.getClass().getName());
                
        Double col = 7.0;
        Double fila = 0.0;
        b.escribir("7letras");
        assertEquals(col,ct.getPosicion().getX(),0);
        assertEquals(fila, ct.getPosicion().getY(),0);        
        
        ct.print("\n");
        b.escribirGuay("R");
        assertEquals(ct.getColorTexto(), Color.RED);
        b.escribirGuay("V");
        assertEquals(ct.getColorTexto(), Color.GREEN);
        b.escribirGuay("A");
        assertEquals(ct.getColorTexto(), Color.BLUE);
        b.escribirGuay("B");
        assertEquals(ct.getColorTexto(), Color.WHITE);
        b.escribirGuay("A");
        assertEquals(ct.getColorTexto(), Color.YELLOW);        
        
        b.setColor(1);
        ct.setColorTexto(Color.WHITE);
        ct.print("\nEl siguiente texto debe ser verde:\n");
        b.escribir("Texto verde");
        assertEquals(ct.getColorTexto(), Color.GREEN);
        t.leerCaracter();
        ct.cls();
    }

}