
package daw.persona;

import java.time.LocalDate;

/**
 *
 * @author rperblac
 */
public class Persona {
    /**
     * Nombre de la persona
     */
    public String nombre;
    /**
     * DNI de la persona
     */
    public DNI dni;
    /**
     * Sueldo
     */
    public double sueldo;
    /**
     * Fecha de nacimiento
     */
    public LocalDate fechaNacimiento;
    /**
     * Crea una persona a partir de su nombre, DNI, sueldo y fecha de nacimiento pasadas como parámetros.
     * @param n nombre
     * @param d DNI
     * @param s sueldo
     * @param fn fecha de nacimiento
     */
    public Persona(String n, DNI d, double s, LocalDate fn){
        nombre = n;
        dni = d;
        sueldo = s;
        fechaNacimiento = fn;
    }
    /**
     * Crea una persona a partir de su nombre, número, letra de DNI, sueldo y fecha de nacimiento pasada como parámetro.
     * @param n nombre
     * @param numDNI número del DNI
     * @param letraDNI letra del DNI
     * @param s sueldo 
     * @param fn fecha de nacimiento
     */
    public Persona(String n, int numDNI, char letraDNI, double s, LocalDate fn){
        nombre = n;
        dni = new DNI(numDNI, letraDNI);
        sueldo = s;
        fechaNacimiento = fn;
    }
    /**
     * Crea una persona cuyo nombre y DNI se pasan como parámetro, gana 900 euros y ha nacido hace 20 años.
     * @param n nombre
     * @param d DNI
     */
    public Persona(String n, DNI d){
        nombre = n;
        dni = d;
        sueldo = 900;
        fechaNacimiento = LocalDate.now().minusYears(20);
    }
    /**
     * Crea una persona cuyo nombre, número y letra de DNI se pasan como parámetro, gana 900 euros y ha nacido hace 20 años.
     * @param n nombre
     * @param numDNI número del DNI
     * @param letraDNI letra del DNI
     */
    public Persona(String n, int numDNI, char letraDNI){
        nombre = n;
        dni = new DNI(numDNI, letraDNI);
        sueldo = 900;
        fechaNacimiento = LocalDate.now().minusYears(20);
    }
}
