
package futbol;

/**
 * Tipo de empleado primable que tiene un dorsal en el equipo.
 * @author rperblac
 */
public class Futbolista extends EmpleadoPrimable{
    /**
     * Dorsal del futbolista
     */
    private int dorsal;
    /**
     * Crea un futbolista con un nombre, un sueldo y un dorsal
     * @param n nombre del futbolista
     * @param s sueldo del futbolista
     * @param d dorsal del futbolista
     */
    public Futbolista(String n, double s, int d) {
        super(n, s);
        this.dorsal = d;
    }
}
