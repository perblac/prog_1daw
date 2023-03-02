
package adivinanzas;

import java.time.Instant;

/**
 * Representa una adivinanza que tiene que acertar el usuario. Posee un enunciado, un String con su respuesta correcta y también guarda el instante en que se llama al método “getEnunciado”.
 * @author rperblac
 */
public class Adivinanza {
    /**
     * Enunciado de la adivinanza
     */
    private String enunciado;
    /**
     * Respuesta correcta a la adivinanza
     */
    private String respuestaCorrecta;
    /**
     * Momento en el que se muestra el enunciado
     */
    private Instant inicio;
    /**
     * Crea una adivinanza con un enunciado y una respuesta correcta
     * @param e enunciado de la adivinanza
     * @param rc respuesta correcta
     */
    public Adivinanza(String e, String rc) {
        this.enunciado = e;
        this.respuestaCorrecta = rc;
        this.inicio = null;
    }
    /**
     * Devuelve el enunciado de la adivinanza y guarda el momento para contar los 30 segundos disponibles para acertar
     * @return enunciado de la adivinanza
     */
    public String getEnunciado() {
        this.inicio = Instant.now();
        return this.enunciado;
    }
    /**
     * Comprueba si la respuesta introducida coincide con la de la adivinanza
     * @param respuesta respuesta a comprobar
     * @throws AdivinanzaException TiempoSuperadoException si se superan los 30 segundos. AdivinanzaIncorrectaException si la respuesta no es correcta.
     */
    public void comprobar(String respuesta) throws AdivinanzaException{
        if (inicio.plusSeconds(30).isAfter(Instant.now()))
        {
            if (!(this.respuestaCorrecta.equals(respuesta))) throw new AdivinanzaIncorrectaException();
        }
        else
        {
            throw new TiempoSuperadoException();
        }
    }
}
