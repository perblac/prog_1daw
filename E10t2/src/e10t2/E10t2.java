package e10t2;

/**Enunciado: Haz otro programa que cree una caja con un mensaje cualquiera. Abrir la caja, consultar el mensaje y mostrarlo por pantalla. Sustituir el mensaje por otro. Volver a consultarlo y mostrar el resultado.
 *
 * @author rperblac
 */
import bpc.daw.objetos.*;

public class E10t2 {

    public static void main(String[] args) {
        String mensaje="Un mensaje cualquiera", otromensaje = "Distinto mensaje al anterior",leer;
        Caja c = new Caja(mensaje);
        c.abrirCaja();
        leer = c.getMensaje();
        System.out.println(leer);
        c.cambiarMensaje(otromensaje);
        leer = c.getMensaje();
        System.out.println(leer);
    }
    
}
