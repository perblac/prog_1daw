
package trabajadores;

/**
 * Recibe un mensaje y lo imprime por pantalla.
 * @author rperblac
 */
public class TecladoJava implements Teclado{
    /**
     * Último mensaje que se escribió
     */
    private String mensaje;
    /**
     * Construye un TecladoJava.
     */
    public void TecladoJava() {
        
    }
    /**
     * Escribe un mensaje por consola.
     * @param mensaje mensaje a escribir
     */
    @Override
    public void escribirTexto(String mensaje) {
        this.mensaje = mensaje;
        System.out.println(this.mensaje);
    }
}
