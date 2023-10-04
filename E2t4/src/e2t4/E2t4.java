
package e2t4;

/**
 *
 * @author rperblac
 */
public class E2t4 {

    public static void main(String[] args) {
        Caja c1 = new Caja("Mensaje de la caja 1");
        Caja c2 = new Caja(true, "Mensaje de la caja 2");
        Caja c3 = new Caja();
        System.out.println("Caja 1\nMensaje: " + c1.mensaje +"\nEstado: " + (c1.abierto?"abierta":"cerrada"));
        System.out.println("Caja 2\nMensaje: " + c2.mensaje +"\nEstado: " + (c2.abierto?"abierta":"cerrada"));
        System.out.println("Caja 3\nMensaje: " + c3.mensaje +"\nEstado: " + (c3.abierto?"abierta":"cerrada"));
    }

}
