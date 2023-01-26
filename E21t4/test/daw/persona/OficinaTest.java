package daw.persona;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class OficinaTest {

    public OficinaTest() {
    }

    @Test
    public void Oficina_String() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre);
        assertEquals("Prueba", o1.getNombre());
        assertEquals(true, o1.getTrabajadores().isEmpty());
    }
    
    @Test
    public void Oficina_String_int(){
        String nombre = "Prueba";
        Oficina o0, o1, o2, o3;
        try 
        {
            o0 = new Oficina(nombre, 0);
            o1 = new Oficina(nombre, 1);
            o2 = new Oficina(nombre, 2);
            o3 = new Oficina(nombre, 3);
            Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
            Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
            Persona p3 = new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21));
            assertEquals("Prueba", o0.getNombre());
            assertEquals("Prueba", o1.getNombre());
            assertEquals("Prueba", o2.getNombre());
            assertEquals("Prueba", o3.getNombre());
            assertEquals(true, o0.getTrabajadores().isEmpty());
            assertEquals(1, o1.getTrabajadores().size());
            assertEquals(2, o2.getTrabajadores().size());
            assertEquals(3, o3.getTrabajadores().size());
            assertEquals(p1.getNombre(), o1.getTrabajadores().get(0).getNombre());
            assertEquals(p2.getNombre(),o2.getTrabajadores().get(0).getNombre());
            assertEquals(p1.getNombre(),o2.getTrabajadores().get(1).getNombre());
            assertEquals(p3.getNombre(),o3.getTrabajadores().get(0).getNombre());
            assertEquals(p2.getNombre(),o3.getTrabajadores().get(1).getNombre());
            assertEquals(p1.getNombre(),o3.getTrabajadores().get(2).getNombre());        
            assertEquals(p1.getDNI().numero, o1.getTrabajadores().get(0).getDNI().numero);
            assertEquals(p2.getDNI().numero, o2.getTrabajadores().get(0).getDNI().numero);
            assertEquals(p1.getDNI().numero, o2.getTrabajadores().get(1).getDNI().numero);
            assertEquals(p3.getDNI().numero, o3.getTrabajadores().get(0).getDNI().numero);
            assertEquals(p2.getDNI().numero, o3.getTrabajadores().get(1).getDNI().numero);
            assertEquals(p1.getDNI().numero, o3.getTrabajadores().get(2).getDNI().numero);        
            assertEquals(p1.getDNI().letra, o1.getTrabajadores().get(0).getDNI().letra);
            assertEquals(p2.getDNI().letra, o2.getTrabajadores().get(0).getDNI().letra);
            assertEquals(p1.getDNI().letra, o2.getTrabajadores().get(1).getDNI().letra);
            assertEquals(p3.getDNI().letra, o3.getTrabajadores().get(0).getDNI().letra);
            assertEquals(p2.getDNI().letra, o3.getTrabajadores().get(1).getDNI().letra);
            assertEquals(p1.getDNI().letra, o3.getTrabajadores().get(2).getDNI().letra);
            assertEquals(p1.getSueldo(), o1.getTrabajadores().get(0).getSueldo(), 0);
            assertEquals(p2.getSueldo(), o2.getTrabajadores().get(0).getSueldo(), 0);
            assertEquals(p1.getSueldo(), o2.getTrabajadores().get(1).getSueldo(), 0);
            assertEquals(p3.getSueldo(), o3.getTrabajadores().get(0).getSueldo(), 0);
            assertEquals(p2.getSueldo(), o3.getTrabajadores().get(1).getSueldo(), 0);
            assertEquals(p1.getSueldo(), o3.getTrabajadores().get(2).getSueldo(), 0);
            assertEquals(p1.getFechaNacimiento(), o1.getTrabajadores().get(0).getFechaNacimiento());
            assertEquals(p2.getFechaNacimiento(), o2.getTrabajadores().get(0).getFechaNacimiento());
            assertEquals(p1.getFechaNacimiento(), o2.getTrabajadores().get(1).getFechaNacimiento());
            assertEquals(p3.getFechaNacimiento(), o3.getTrabajadores().get(0).getFechaNacimiento());
            assertEquals(p2.getFechaNacimiento(), o3.getTrabajadores().get(1).getFechaNacimiento());
            assertEquals(p1.getFechaNacimiento(), o3.getTrabajadores().get(2).getFechaNacimiento());        
        } catch (IllegalArgumentException e)
        {
            fail("El constructor lanzó una excepción con un tipo de oficina válido");
        }
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void Oficina_String_int_Exception() throws IllegalArgumentException{
        String nombre = "Prueba";
        Oficina o = new Oficina(nombre, 4);
        fail("El constructor no lanzó una excepción con un tipo de oficina no válido");
    }
    
    @Test
    public void Oficina_Default() {
        String nombre = "Industrias DAW";
        Oficina o1 = new Oficina();
        Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
        Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
        Persona p3 = new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21));
        assertEquals(nombre, o1.getNombre());
        assertEquals(p3.getNombre(), o1.getTrabajadores().get(0).getNombre());
        assertEquals(p2.getNombre(), o1.getTrabajadores().get(1).getNombre());
        assertEquals(p1.getNombre(), o1.getTrabajadores().get(2).getNombre());
        assertEquals(p3.getDNI().numero, o1.getTrabajadores().get(0).getDNI().numero);
        assertEquals(p2.getDNI().numero, o1.getTrabajadores().get(1).getDNI().numero);
        assertEquals(p1.getDNI().numero, o1.getTrabajadores().get(2).getDNI().numero);        
        assertEquals(p3.getDNI().letra, o1.getTrabajadores().get(0).getDNI().letra);
        assertEquals(p2.getDNI().letra, o1.getTrabajadores().get(1).getDNI().letra);
        assertEquals(p1.getDNI().letra, o1.getTrabajadores().get(2).getDNI().letra);
        assertEquals(p3.getSueldo(), o1.getTrabajadores().get(0).getSueldo(), 0);
        assertEquals(p2.getSueldo(), o1.getTrabajadores().get(1).getSueldo(), 0);
        assertEquals(p1.getSueldo(), o1.getTrabajadores().get(2).getSueldo(), 0);
        assertEquals(p3.getFechaNacimiento(), o1.getTrabajadores().get(0).getFechaNacimiento());
        assertEquals(p2.getFechaNacimiento(), o1.getTrabajadores().get(1).getFechaNacimiento());
        assertEquals(p1.getFechaNacimiento(), o1.getTrabajadores().get(2).getFechaNacimiento());
    }
    
    @Test
    public void añadirEmpleado_Persona() {
        Oficina o1 = new Oficina("Prueba");
        String nombre = "Javier Prueba Pepinillo";
        Persona p4 = new Persona(nombre, 12345678, 'Z', 900, LocalDate.of(1976, 6, 15));
        o1.añadirEmpleado(p4);
        assertEquals(nombre, o1.getTrabajadores().get(0).getNombre());
    }
    
    @Test
    public void añadirEmpleado_4args() {
        Oficina o1 = new Oficina("Prueba");
        String nombre = "Javier Prueba Pepinillo";
        String DNI = "12345678Z";
        double sueldo = 900;
        LocalDate fechaNac = LocalDate.of(1976, 6, 15);
        o1.añadirEmpleado(nombre, DNI, sueldo, fechaNac);
        assertEquals(nombre, o1.getTrabajadores().get(0).getNombre());
        assertEquals(12345678, o1.getTrabajadores().get(0).getDNI().numero);
        assertEquals('Z', o1.getTrabajadores().get(0).getDNI().letra);
        assertEquals(900, o1.getTrabajadores().get(0).getSueldo(), 0);
        assertEquals(fechaNac, o1.getTrabajadores().get(0).getFechaNacimiento());
    }

    @Test
    public void testGetNombre() {
        Oficina o1 = new Oficina("Prueba");
        assertEquals("Prueba", o1.getNombre());
    }

    @Test
    public void testGetTrabajadores() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 1);
        ArrayList lista = new ArrayList();
        lista.add(o1.getTrabajadores().get(0));
        assertEquals(lista, o1.getTrabajadores());
    }

    @Test
    public void testGetTotalEmpleados() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 1);
        assertEquals(1, o1.getTotalEmpleados());
    }

    @Test
    public void testGetTotalEmpleadosMileuristas() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 3);
        assertEquals(2, o1.getTotalEmpleadosMileuristas());
    }

    @Test
    public void testGetMileuristas() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 1);        
        ArrayList lista = new ArrayList();
        lista.add(o1.getTrabajadores().get(0));
        assertEquals( lista, o1.getMileuristas());
    }

    @Test
    public void testTrabaja() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 1);
        Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
        Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
        assertEquals(true, o1.trabaja(p1));
        assertEquals(false, o1.trabaja(p2));
    }

    @Test
    public void testPagarEmpleados() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 1);
        o1.pagarEmpleados();
        assertEquals(900, o1.getTrabajadores().get(0).getCuentaCorriente().saldo,0);
    }

    @Test
    public void testMostrarInformeEmpleados() {
        String nombre = "Prueba";
        Oficina o1 = new Oficina(nombre, 3);
        o1.mostrarInformeEmpleados();
    }
    
    @Test
    public void testgetSueldoMedio() {
        String nombre = "Prueba";        
        Oficina o1 = new Oficina(nombre, 3);
        double sueldomedio = (900.0 + 1000.0 + 1200.0) / 3;
        
        try {
            assertEquals(sueldomedio, o1.getSueldoMedio(), 0);
        } catch (Exception e)
        {
            fail("getSueldoMedio() lanzó una excepción y no debía");
        }
    }
    
    @Test (expected=java.lang.Exception.class)
    public void testgetSueldoMedio_exception() throws Exception {
        String nombre = "Prueba";
        Oficina o2 = new Oficina(nombre);
        assertEquals(0, o2.getSueldoMedio(), 0);
        fail("getSueldoMedio() no lanzó una excepción con la lista de trabajadores vacía");
    }

}