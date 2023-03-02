
package trabajadores;

import java.util.Date;

/**
 * Representa un trabajador que escribe un informe en el teclado que está usando. Además, le pone la fecha y hora antes de escribirlo.
 * @author rperblac
 */
public class Administrativo extends TrabajadorTecleante{
    /**
     * Último informe escrito por el administrativo
     */
    private String t;
    /**
     * Fecha del último informe escrito por el administrativo
     */
    Date fecha;
    /**
     * Crea un trabajador administrativo con un nombre, un dni, un sueldo y un número de pulsaciones por minuto.
     * @param n nombre del administrativo
     * @param s sueldo del administrativo
     * @param ndni número del DNI
     * @param ldni letra del DNI
     * @param ppm pulsaciones por minuto del administrativo
     */
    public Administrativo (String n, int s, int ndni, char ldni, int ppm) {
        super(n, s, ndni, ldni, ppm);
        this.t = "";
        this.fecha = null;
    }
    /**
     * Escribe un informe con fecha y hora delante
     * @param t informe a escribir
     */
    public void escribirInforme(String t) {
        this.t = t;
        this.fecha = new Date();
        this.escribirTexto(fecha.toString() + " " + t);
    }
    /**
     * Devuelve la fecha del último informe
     * @return fecha del último informe
     */
    public Date getFechaUltimoInforme() {
        return this.fecha;
    }
}
