package e2t4;


/**
 *
 * @author rperblac
 */
public class Caja {
    /**
     * Estado de la caja.
     * true = abierto,
     * false = cerrado
     */
    public boolean abierto;
    /**
     * Mensaje del interior de la caja
     */
    public String mensaje;
    
    /**
    * Construye una caja cerrada con un mensaje
    * @param m Un String con el mensaje de la caja
    */
    public Caja(String m){
        this(false,m);
    }
    /**
    * Construye una caja
    * @param a Un booleano que define si la caja está abierta (true) o cerrada (false)
    * @param m Un String con el mensaje de la caja
    */
    public Caja(boolean a, String m){
        abierto = a;
        mensaje = m;
    }
    /**
    * Construye una caja cerrada con el mensaje "Viva el tema 7"
    */
    public Caja(){
        this(false,"Viva el tema 7");
    }
}
