
package trabajadores;

/**
 * Representa un empleado que tiene un nombre, sueldo y dni.
 * @author rperblac
 */
public class Trabajador {
    /**
     * DNI del trabajador
     */
    private String dni;
    /**
     * Nombre del trabajador
     */
    private String nombre;
    /**
     * Sueldo del trabajador
     */
    protected int sueldo;
    /**
     * Crea un trabajador empleado con un nombre, un dni y un sueldo.
     * @param nombre nombre del trabajador
     * @param sueldo sueldo del trabajador
     * @param numDNI número del DNI
     * @param letraDNI letra del DNI
     */
    public Trabajador(String nombre, int sueldo, int numDNI, char letraDNI) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.dni = "" + numDNI + letraDNI;
    }
    /**
     * Devuelve el sueldo del trabajador
     * @return sueldo del trabajador
     */
    public int getSueldo() {
        return this.sueldo;
    }
    /**
     * Devuelve el nombre del trabajador
     * @return nombre del trabajador
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el DNI con letra del trabajador
     * @return dni del trabajador
     */
    public String getDNI() {
        return this.dni;
    }
}
