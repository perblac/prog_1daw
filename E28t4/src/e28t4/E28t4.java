
package e28t4;

/**
 * Archivo de pruebas
 * @author rperblac
 */
public class E28t4 {

    public static void main(String[] args) {
        
        CajaMejorada c = new CajaMejorada("el mensaje de la caja");
        System.out.println((c.getMensaje().isEmpty()?c.getMensaje().toString():c.getMensaje().get()));
        c.abrir();
        System.out.println((c.getMensaje().isEmpty()?c.getMensaje().toString():c.getMensaje().get()));
        
    }

}
