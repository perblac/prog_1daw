package e8t4;


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
    private boolean abierto;
    
    /**
     * Mensaje del interior de la caja
     */
    private String mensaje;
    
    /**
    * Construye una caja cerrada con un mensaje
    * @param m mensaje de la caja
    */
    public Caja(String m){
        this(false,m);
    }
    
    /**
    * Construye una caja
    * @param a define si la caja está abierta (true) o cerrada (false)
    * @param m el mensaje de la caja
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
    
    /**
     * Si la caja está abierta, cambia el mensaje de la caja. Si la caja está cerrada, no hace nada.
     * @param m nuevo mensaje para la caja
     */
    public void setMensaje(String m) {
        this.mensaje = (this.abierto)?m:this.mensaje;
    }
    
    /**
     * Reemplaza el mensaje de la caja por su versión en letras mayúsculas.
     */
    public void pasarMayusculas() {
        this.mensaje = this.mensaje.toUpperCase();
    }
    
    /**
     * Abre la caja.
     */
    public void abrir() {
        this.abierto = true;
    }
    
    /**
     * Cierra la caja.
     */
    public void cerrar() {
        this.abierto = false;
    }
    
    /**
     * Devuelve true si la caja está abierta y false si está cerrada
     * @return true si la caja está abierta, false si está cerrada
     */
    public boolean getAbierto() {
        return this.abierto;
    }
    
    /**
     * Si la caja está cerrada, devuelve null, y si la caja está abierta devuelve el mensaje que hay dentro de la caja.
     * @return el mensaje, o null si la caja está cerrada
     */
    public String getMensaje() {
        return this.abierto?this.mensaje:null;
    }

}
