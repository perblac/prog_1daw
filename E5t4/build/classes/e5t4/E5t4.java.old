
package e5t4;

import daw.persona.Oficina;
import daw.persona.Persona;
import java.time.LocalDate;

/**
 *
 * @author rperblac
 */
public class E5t4 {

    public static void main(String[] args) {
        String nombre = "Prueba";
        Persona p1 = new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28));
        Persona p2 = new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10));
        Persona p3 = new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21));
        Oficina o1 = new Oficina(nombre, 1);
        Oficina o2 = new Oficina(nombre, 2);
        Oficina o3 = new Oficina(nombre, 3);
        System.out.println("o1: [0]" + o1.trabajadores.get(0).nombre);
        System.out.println("o2: [0]" + o2.trabajadores.get(0).nombre);
        System.out.println("o2: [1]" + o2.trabajadores.get(1).nombre);
        System.out.println("o3: [0]" + o3.trabajadores.get(0).nombre);
        System.out.println("o3: [1]" + o3.trabajadores.get(1).nombre);
        System.out.println("o3: [2]" + o3.trabajadores.get(2).nombre);
        System.out.println(p1.nombre.equals(o1.trabajadores.get(0).nombre));
        System.out.println(p2.nombre.equals(o2.trabajadores.get(0).nombre));
        System.out.println(p3.nombre.equals(o3.trabajadores.get(0).nombre));
        System.out.println("dni\n"+p1.dni.numero+" " + o1.trabajadores.get(0).dni.numero+" "+(p1.dni.numero == (o1.trabajadores.get(0).dni.numero)));
    }

}
