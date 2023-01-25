
package e15t4;

import e15t4.MarcadorBaloncesto;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class MarcadorBaloncestoTest {

    public MarcadorBaloncestoTest() {
    }

    @Test
    public void testMarcadorBaloncesto_String_String() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        assertEquals("Estudiantes", a.getNombreLocal());
        assertEquals("CB Granada", a.getNombreVisitante());
        assertEquals(0, a.getPuntosLocal());
        assertEquals(0,a.getPuntosVisitante());
        assertEquals(LocalDate.now(), a.getFecha());               
    }

    @Test
    public void testMarcadorBaloncesto_3args() {
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto b = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        assertEquals("Estudiantes", b.getNombreLocal());
        assertEquals("CB Granada", b.getNombreVisitante());
        assertEquals(0, b.getPuntosLocal());
        assertEquals(0,b.getPuntosVisitante());
        assertEquals(fecha, b.getFecha());    
    }
    
    @Test
    public void testAñadirCanasta() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");        
        assertEquals(0, a.getPuntosLocal());
        assertEquals(0, a.getPuntosVisitante());
        a.añadirCanasta('L', 3);
        assertEquals(3, a.getPuntosLocal());
        a.añadirCanasta('V', 2);
        assertEquals(2, a.getPuntosVisitante());
        a.añadirCanasta('L', 1);
        assertEquals(4, a.getPuntosLocal());
        a.añadirCanasta('V', 1);
        assertEquals(3, a.getPuntosVisitante());
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testAñadirCanastaExceptionPuntos() throws Exception{
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 4);
        fail("No se lanzó la excepción IllegalArgumentException con un número de puntos no valido");
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testAñadirCanastaExceptionEquipo() throws Exception{
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('A', 3);
        fail("No se lanzó la excepción IllegalArgumentException con un equipo distinto de 'L' o 'V'");
    }
    
    @Test
    public void testReset() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 3);
        a.añadirCanasta('V', 2);
        a.reset();
        assertEquals(0, a.getPuntosLocal());
        assertEquals(0, a.getPuntosVisitante());        
    }

    @Test
    public void testGetNombreLocal() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        assertEquals("Estudiantes", a.getNombreLocal());
    }

    @Test
    public void testGetNombreVisitante() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        assertEquals("CB Granada", a.getNombreVisitante());
    }

    @Test
    public void testGetPuntosLocal() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 3);
        assertEquals(3, a.getPuntosLocal());
    }

    @Test
    public void testGetPuntosVisitante() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('V', 2);
        assertEquals(2, a.getPuntosVisitante());
    }

    @Test
    public void testGetFecha() {
    }

    @Test
    public void testGanaLocal() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 3);
        a.añadirCanasta('V', 2);
        assertEquals(true, a.ganaLocal());
        a.añadirCanasta('V', 2);
        assertEquals(false, a.ganaLocal());
    }

    @Test
    public void testGanaVisitante() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 3);
        a.añadirCanasta('V', 2);
        assertEquals(false, a.ganaVisitante());
        a.añadirCanasta('V', 3);
        assertEquals(true, a.ganaVisitante());
    }

    @Test
    public void testHayEmpate() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        a.añadirCanasta('L', 3);
        a.añadirCanasta('V', 2);
        assertEquals(false, a.hayEmpate());
        a.añadirCanasta('L', 2);
        a.añadirCanasta('V', 3);
        assertEquals(true, a.hayEmpate());
    }

    @Test
    public void testGuardar1() {
        String ruta = "prueba.txt";
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        a.añadirCanasta('L', 2);
        a.añadirCanasta('V', 3);
        File archivo = null;
        try
        {
            a.guardar(ruta);
            archivo = new File(ruta);
        } catch (IOException e)
        {
            fail("No se pudo guardar el archivo");
        }
        assertEquals(true, archivo.exists());
    }
    
    @Test(expected=java.lang.Exception.class)
    public void testGuardar2() throws IOException{
        String ruta = "./";
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        a.añadirCanasta('L', 2);
        a.añadirCanasta('V', 3);
        a.guardar(ruta);
        fail("No se lanzó la excepcion IOException");
    }

    @Test
    public void testCargar1() {
        String ruta = "prueba.txt";
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        a.añadirCanasta('L', 2);
        a.añadirCanasta('V', 3);
        String datos = "";
        try
        {
            datos = a.cargar(ruta);            
        } catch (IOException e)
        {
            fail("No se pudo leer el archivo");
        }
        assertEquals(a.getNombreLocal() + " " + a.getPuntosLocal() + " " + a.getNombreVisitante() + " " + a.getPuntosVisitante(), datos);
    }
    
    @Test(expected=java.lang.Exception.class)
    public void testCargar2() throws IOException{
        String ruta = "./";
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        a.añadirCanasta('L', 2);
        a.añadirCanasta('V', 3);
        String datos = a.cargar(ruta);          
        fail("No se lanzó la excepcion IOException");
    }

}