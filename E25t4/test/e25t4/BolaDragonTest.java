
package e25t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class BolaDragonTest {

    public BolaDragonTest() {
    }

    @Test
    public void testGetNúmero() {
        BolaDragon.reiniciar();
        BolaDragon bola;
        try
        {
            bola = BolaDragon.crearBolaDragon();
            assertEquals(1, bola.getNúmero());
        } catch (Exception e)
        {
            fail("Se lanzó una excepción cuando no debía");
        }        
    }

    @Test
    public void testCrearBolaDragon() throws Exception {
        BolaDragon.reiniciar();
        BolaDragon bola = BolaDragon.crearBolaDragon();
        try
        {
            assertEquals(2, BolaDragon.crearBolaDragon().getNúmero());            
        } catch (Exception e)
        {
            fail("Se lanzó una excepción cuando no debía");
        }
    }
    
    @Test(expected=java.lang.Exception.class)
    public void testCrearBolaDragon_Exception() throws Exception {
        BolaDragon.reiniciar();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        BolaDragon.crearBolaDragon();
        fail("No se lanzó la excepción al crear la octava bola");
    }

}