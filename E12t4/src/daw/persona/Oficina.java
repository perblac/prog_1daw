
package daw.persona;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Una oficina en la que trabajan varias personas
 *
 * @author rperblac
 */
public class Oficina {
    /**
     * Nombre de la oficia
     */
    public String nombre;
    
    /**
     * Lista de trabajadores
     */
    public ArrayList<Persona> trabajadores;
    
    /**
     * Crea una oficina que se llama como indica el nombre recibido, y la lista de trabajadores está vacía.
     * @param nombre nombre de la oficina
     */
    public Oficina(String nombre){
        this.nombre = nombre;
        trabajadores = new ArrayList<Persona>();
    }
    
    /**
     * Crea una oficina que se llama como indica el nombre recibido, y un tipo
     * @param nombre nombre de la oficina
     * @param tipo 0 o mayor de 3: la lista de trabajadores estará vacía.<br/>
     * 1: la lista de trabajadores solo tiene este trabajador Antonio Pérez Pérez, 11111111H, 900, 28/2/2000.<br/>
     * 2: la lista de trabajadores tendrá al de tipo 1, y también a Luis López López, 22222222J,1000, 10/9/1995.<br/>
     * 3: la lista de trabajadores tendrá a los trabajadores de tipo 2 y a Ana Díaz Díaz. 33333333P, 1200, 21/5/1985
     */
    public Oficina(String nombre, int tipo){
        this.nombre = nombre;
        if ((tipo == 0) || (tipo > 3))
            trabajadores = new ArrayList<>();
        else
        {
            trabajadores = new ArrayList<>();
            switch(tipo)
            {
                case 3:
                    trabajadores.add(new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21)));
                case 2:
                    trabajadores.add(new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10)));
                case 1:
                    trabajadores.add(new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28)));
                    break;
            }
        }
    }
    
    /**
     * Crea una oficina llamada “Industrias DAW”, que es de tipo 3.
     */
    public Oficina(){
        this("Industrias DAW", 3);
    }
    
    /**
     * Añade a la oficina el trabajador pasado como parámetro.
     * @param p persona a añadir como empleado
     */
    public void añadirEmpleado(Persona p) {
        this.trabajadores.add(p);
    }
    
    /**
     * Crea una persona con los parámetros recibidos y la añade a la oficina.
     * @param nombre nombre del nuevo empleado
     * @param DNI dni del nuevo empleado
     * @param sueldo sueldo del nuevo empleado
     * @param fechaNac fecha de nacimiento del nuevo empleado
     */
    public void añadirEmpleado(String nombre, String DNI, double sueldo, LocalDate fechaNac) {
        Persona empleado = new Persona(nombre,new DNI(DNI).numero, new DNI(DNI).letra ,sueldo,fechaNac);
        this.trabajadores.add(empleado);
    }

}
