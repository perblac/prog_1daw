
package trabajadores;

import bpc.daw.consola.CapaTexto;

/**
 * Recibe un mensaje y lo imprime por la capa de texto de una consola DAW
 * @author rperblac
 */
public class TecladoConsolaDAW implements Teclado{
    /**
     * CapaTexto a utilizar
     */
    private CapaTexto ct;
    /**
     * Último mensaje que se escribió
     */
    private String mensaje;
    /**
     * Crea un TecladoConsolaDAW asociado a una CapaTexto
     * @param ct CapaTexto donde escribirá el teclado
     */
    public TecladoConsolaDAW(CapaTexto ct) {
        this.ct = ct;
    }
    /**
     * Escribe un mensaje en la CapaTexto de la consolaDAW
     * @param mensaje mensaje a escribir
     */
    @Override
    public void escribirTexto(String mensaje) {
        this.mensaje = mensaje;
        this.ct.print(this.mensaje);
    }
}
