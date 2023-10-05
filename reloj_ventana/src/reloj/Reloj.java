
package reloj;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa un reloj
 * @author rperblac
 */
public class Reloj {
    private int segAcumulados = 0;
    private LocalTime hora;
    /**
     * Crea un reloj que guarda la hora del momento actual.
     */
    public Reloj() {
        this.hora = LocalTime.now();
    }
    
    /**
     * Sirve para añadir la cantidad de segundos indicada a la hora del reloj.
     * @param segundos segundos a añadir a la hora indicada
     */
    public void añadir(int segundos) {
        //this.hora = this.hora.plusSeconds((long) segundos);
        segAcumulados += segundos;
    }
    
    /**
     * Devuelve si es de noche.
     * @return true si la hora está entre las 20:00 y las 8:00
     */
    public boolean esNoche() {
        return (this.hora.isAfter(LocalTime.of(20, 0))||this.hora.isBefore(LocalTime.of(8, 0)));
    }
    
    /**
     * Hace una pausa de la cantidad de segundos pasada como parámetro y después actualizará la propiedad “hora”.
     * @param segundos tiempo de pausa
     */
    public void esperar(int segundos) {
        try
        {
            Thread.sleep((long) segundos*1000);
        } catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        this.hora = LocalTime.now();
    }
    
    /**
     * Devuelve la hora escrita en el siguiente formato: hora:minutos:segundos
     * @return  una cadena con la hora del reloj
     */
    public String toString() {
        this.hora = LocalTime.now();
        this.hora = this.hora.plusSeconds((long) segAcumulados);
        String hora = this.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return hora;
    }
}
