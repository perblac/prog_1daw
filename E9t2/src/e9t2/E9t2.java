package e9t2;

/**Enunciado: En la librería ObjetosSencillos.jar se encuentra la clase Caja. Haz un programa que cree una caja que contenga el mensaje “Bienvenidos al instituto”. Consultar el mensaje con la caja cerrada y mostrar el resultado. Abrir la caja y consultar el mensaje. Mostrar el resultado.
 *
 * @author rperblac
 */
import bpc.daw.objetos.*;

public class E9t2 {

    public static void main(String[] args) {
        String mensaje = "Bienvenidos al instituto";
        Caja c = new Caja(mensaje);
        if (c.estaAbierta()) {c.cerrarCaja();}
        System.out.println(c.getMensaje());
        c.abrirCaja();
        System.out.println(c.getMensaje());
    }
    
}
