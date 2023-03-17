
package paqueteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Una empresa de paquetería en la que solo hay un transportista (Pepe), que
 * tiene la costumbre de ordenar los paquetes por prioridad antes de enviarlos,
 * y tarda 30 minutos en enviar cada paquete.
 * 
 * @author rperblac
 */
public class PaquetesPepe implements EmpresaPaqueteria {
    /**
     * Único trasportista de la empresa
     */
    private TransportistaOrdenado Pepe;
    /**
     * Crea una empresa PaquetesPepe con su transportista Pepe
     */
    public PaquetesPepe() {
        this.Pepe = new TransportistaOrdenado(30);
    }
    /**
     * Acepta un pedido y lo asigna a un repartidor
     * @param p paquete del pedido
     */
    @Override
    public void registrarPedido(Paquete p) {
        Pepe.subirCamion(p);
    }
    /**
     * Devuelve una lista con los transportistas que trabajan para la empresa de transportes.
     * @return lista de transportistas de la empresa
     */
    @Override
    public List<Transportista> getTransportistas() {
        ArrayList<Transportista> lista = new ArrayList<>();
        lista.add(Pepe);
        return lista;
    }
    /**
     * Recorre la lista de transportistas y les ordena que envíen los paquetes
     * que tienen asignados. Ordena los paquetes antes de enviarlos
     */
    @Override
    public void enviarPaquetes() {
        List lista = Pepe.getPaquetes();
        Collections.sort(lista);
        Pepe.enviar();
    }
    
}
