
package e3t4;

import java.time.LocalDate;

/**
 *
 * @author rperblac
 */
public class MarcadorBaloncesto {
    /**
     * Nombre del equipo local
     */
    public String nombreLocal;
    /**
     * Nombre del equipo visitante
     */
    public String nombreVisitante;
    /**
     * Puntos del equipo local
     */
    public int puntosLocal;
    /**
     * Puntos del equipo visitante
     */
    public int puntosVisitante;
    /**
     * Fecha en la que se juega el partido
     */
    public LocalDate fecha;
    
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, ambos tienen 0 puntos y se juega en la fecha actual
     * 
     * @param nL nombre del equipo local
     * @param nV nombre del equipo visitante
     */
    public MarcadorBaloncesto(String nL, String nV){
        MarcadorBaloncesto(nL, 0, nV, 0, LocalDate.now());        
    }
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, ambos tienen 0 puntos y se juega en la fecha recibida como parámetro
     * 
     * @param nL nombre del equipo local
     * @param nV nombre del equipo visitante
     * @param f fecha del partido
     */
    public MarcadorBaloncesto(String nL, String nV, LocalDate f){
        MarcadorBaloncesto(nL, 0, nV, 0, f);
    }
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, tienen los puntos que se reciben como parámetros y se juega en la fecha recibida como parámetro
     * 
     * @param nL nombre del equipo local
     * @param pL puntos del equipo local
     * @param nV nombre del equipo visitante
     * @param pV puntos del equipo visitante
     * @param f fecha del partido (LocalDate)
     */
    private void MarcadorBaloncesto(String nL, int pL, String nV, int pV, LocalDate fecha){
        this.nombreLocal = nL;
        this.puntosLocal = pL;
        this.nombreVisitante = nV;
        this.puntosVisitante = pV;
        this.fecha = fecha;
    }
}
