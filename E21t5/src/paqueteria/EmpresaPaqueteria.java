
package paqueteria;

import java.util.List;

/**
 * Interfaz EmpresaPaqueteria
 * @author rperblac
 */

public interface EmpresaPaqueteria {
    public void registrarPedido(Paquete p);
    public List<Transportista> getTransportistas();
    public default void enviarPaquetes() {};
}
