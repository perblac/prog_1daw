package daw.persona;

import java.time.LocalDate;
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
        assertEquals("Prueba", o1.nombre);
        assertEquals(true, o1.trabajadores.isEmpty());
    }
    
    @Test
    public void Oficina_String_int() {
        String nombre = "Prueba";
        Oficina o0 = new Oficina(nombre, 0);
        Oficina o1 = new Oficina(nombre, 1);
        Oficina o2 = new Oficina(nombre, 2);
        Oficina o3 = new Oficina(nombre, 3);
        Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
        Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
        Persona p3 = new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21));
        assertEquals("Prueba", o0.nombre);
        assertEquals("Prueba", o1.nombre);
        assertEquals("Prueba", o2.nombre);
        assertEquals("Prueba", o3.nombre);
        assertEquals(true, o0.trabajadores.isEmpty());
        assertEquals(1, o1.trabajadores.size());
        assertEquals(2, o2.trabajadores.size());
        assertEquals(3, o3.trabajadores.size());
        assertEquals(true, p1.nombre.equals(o1.trabajadores.get(0).nombre));
        assertEquals(true, p2.nombre.equals(o2.trabajadores.get(0).nombre));
        assertEquals(true, p1.nombre.equals(o2.trabajadores.get(1).nombre));
        assertEquals(true, p3.nombre.equals(o3.trabajadores.get(0).nombre));
        assertEquals(true, p2.nombre.equals(o3.trabajadores.get(1).nombre));
        assertEquals(true, p1.nombre.equals(o3.trabajadores.get(2).nombre));        
        assertEquals(true, p1.dni.numero == (o1.trabajadores.get(0).dni.numero));
        assertEquals(true, p2.dni.numero == (o2.trabajadores.get(0).dni.numero));
        assertEquals(true, p1.dni.numero == (o2.trabajadores.get(1).dni.numero));
        assertEquals(true, p3.dni.numero == (o3.trabajadores.get(0).dni.numero));
        assertEquals(true, p2.dni.numero == (o3.trabajadores.get(1).dni.numero));
        assertEquals(true, p1.dni.numero == (o3.trabajadores.get(2).dni.numero));        
        assertEquals(true, p1.dni.letra == (o1.trabajadores.get(0).dni.letra));
        assertEquals(true, p2.dni.letra == (o2.trabajadores.get(0).dni.letra));
        assertEquals(true, p1.dni.letra == (o2.trabajadores.get(1).dni.letra));
        assertEquals(true, p3.dni.letra == (o3.trabajadores.get(0).dni.letra));
        assertEquals(true, p2.dni.letra == (o3.trabajadores.get(1).dni.letra));
        assertEquals(true, p1.dni.letra == (o3.trabajadores.get(2).dni.letra));
        assertEquals(true, p1.sueldo == (o1.trabajadores.get(0).sueldo));
        assertEquals(true, p2.sueldo == (o2.trabajadores.get(0).sueldo));
        assertEquals(true, p1.sueldo == (o2.trabajadores.get(1).sueldo));
        assertEquals(true, p3.sueldo == (o3.trabajadores.get(0).sueldo));
        assertEquals(true, p2.sueldo == (o3.trabajadores.get(1).sueldo));
        assertEquals(true, p1.sueldo == (o3.trabajadores.get(2).sueldo));
        assertEquals(true, p1.fechaNacimiento.equals(o1.trabajadores.get(0).fechaNacimiento));
        assertEquals(true, p2.fechaNacimiento.equals(o2.trabajadores.get(0).fechaNacimiento));
        assertEquals(true, p1.fechaNacimiento.equals(o2.trabajadores.get(1).fechaNacimiento));
        assertEquals(true, p3.fechaNacimiento.equals(o3.trabajadores.get(0).fechaNacimiento));
        assertEquals(true, p2.fechaNacimiento.equals(o3.trabajadores.get(1).fechaNacimiento));
        assertEquals(true, p1.fechaNacimiento.equals(o3.trabajadores.get(2).fechaNacimiento));
        
    }
    
    @Test
    public void Oficina_Default() {
        String nombre = "Industrias DAW";
        Oficina o1 = new Oficina();
        Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
        Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
        Persona p3 = new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21));
        assertEquals(nombre, o1.nombre);
        assertEquals(true, p3.nombre.equals(o1.trabajadores.get(0).nombre));
        assertEquals(true, p2.nombre.equals(o1.trabajadores.get(1).nombre));
        assertEquals(true, p1.nombre.equals(o1.trabajadores.get(2).nombre));
        assertEquals(true, p3.dni.numero == (o1.trabajadores.get(0).dni.numero));
        assertEquals(true, p2.dni.numero == (o1.trabajadores.get(1).dni.numero));
        assertEquals(true, p1.dni.numero == (o1.trabajadores.get(2).dni.numero));        
        assertEquals(true, p3.dni.letra == (o1.trabajadores.get(0).dni.letra));
        assertEquals(true, p2.dni.letra == (o1.trabajadores.get(1).dni.letra));
        assertEquals(true, p1.dni.letra == (o1.trabajadores.get(2).dni.letra));
        assertEquals(true, p3.sueldo == (o1.trabajadores.get(0).sueldo));
        assertEquals(true, p2.sueldo == (o1.trabajadores.get(1).sueldo));
        assertEquals(true, p1.sueldo == (o1.trabajadores.get(2).sueldo));
        assertEquals(true, p3.fechaNacimiento.equals(o1.trabajadores.get(0).fechaNacimiento));
        assertEquals(true, p2.fechaNacimiento.equals(o1.trabajadores.get(1).fechaNacimiento));
        assertEquals(true, p1.fechaNacimiento.equals(o1.trabajadores.get(2).fechaNacimiento));
    }
    
    @Test
    public void añadirEmpleado_Persona() {
        Oficina o1 = new Oficina("Prueba");
        String nombre = "Javier Prueba Pepinillo";
        Persona p4 = new Persona(nombre, 12345678, 'Z', 900, LocalDate.of(1976, 6, 15));
        o1.añadirEmpleado(p4);
        assertEquals(nombre, o1.trabajadores.get(0).nombre);
    }
    
    @Test
    public void añadirEmpleado_4args() {
        Oficina o1 = new Oficina("Prueba");
        String nombre = "Javier Prueba Pepinillo";
        String DNI = "12345678Z";
        double sueldo = 900;
        LocalDate fechaNac = LocalDate.of(1976, 6, 15);
        o1.añadirEmpleado(nombre, DNI, sueldo, fechaNac);
        assertEquals(nombre, o1.trabajadores.get(0).nombre);
        assertEquals(12345678, o1.trabajadores.get(0).dni.numero);
        assertEquals('Z', o1.trabajadores.get(0).dni.letra);
        assertEquals(900, o1.trabajadores.get(0).sueldo, 0);
        assertEquals(fechaNac, o1.trabajadores.get(0).fechaNacimiento);
    }

}