
package trabajadores;

/**
 * Representa un tipo de empleado que utiliza un teclado para trabajar, y además tiene unas determinadas pulsaciones por minuto.
 * @author rperblac
 */
public class TrabajadorTecleante extends Trabajador implements Teclado{
    /**
     * Pulsaciones por minuto del trabajador tecleante
     */
    private int pulsacionesMinuto;
    /**
     * Objeto Teclado que utiliza el trabajador tecleante
     */
    protected Teclado teclado;
    /**
     * Último mensaje que se escribió
     */
    private String mensaje;
    /**
     * Crea un trabajador tecleante con un nombre, un dni, un sueldo y un número de pulsaciones por minuto.
     * @param n nombre del trabajador
     * @param s sueldo del trabajador
     * @param ndni número del DNI
     * @param ldni letra del DNI
     * @param ppm pulsaciones por minuto del trabajador
     */
    public TrabajadorTecleante(String n, int s, int ndni, char ldni, int ppm) {
        super(n, s, ndni, ldni);
        this.pulsacionesMinuto = ppm;
        this.teclado = null;
    }
    /**
     * Establece el objeto Teclado que utiliza el trabajador
     * @param t Teclado a utilizar
     */
    public void setTeclado(Teclado t) {
        this.teclado = t;
    }
    /**
     * Devuelve el objeto Teclado que utiliza el trabajador (puede ser null si aún no se ha establecido)
     * @return Teclado del trabajador
     */
    public Teclado getTeclado() {
        return this.teclado;
    }
    /**
     * Devuelve las pulsaciones por minuto del trabajador
     * @return pulsaciones por minuto
     */
    public int getPulsacionesMinuto() {
        return this.pulsacionesMinuto;
    }
    /**
     * Escribe un mensaje por consola.
     * @param mensaje mensaje a escribir
     */
    public void escribirTexto(String mensaje) {
        this.mensaje = mensaje;
        System.out.println(this.mensaje);
    }
}
