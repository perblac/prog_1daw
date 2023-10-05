
package reloj;

/**
 *
 * @author rperblac
 */
public class Programa {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        while (true)
        {
            ventana.update();
        }
    }

}
