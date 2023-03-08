
package paqueteria;

import java.util.Collections;
import java.util.List;

/**
 * Tipo de transportista, que cuando recibe la orden de enviar los paquetes,
 * primero ordena la lista de paquetes por prioridad.
 *
 * @author rperblac
 */
public class TransportistaOrdenado extends Transportista{
    /**
     * Lista de paquetes a enviar
     */
    private List<Paquete> paquetes;
    /**
     * Minutos que tarda en enviar un paquete
     */
    private long tiempoEntrega;
    /**
     * Crea un transportista que ordena los envios y tarda en enviar un paquete
     * el número de minutos que se pasa como parámetro, y no tiene ningún
     * paquete asignado.
     *
     * @param te tiempo que tarda en enviar un paquete
     */
    public TransportistaOrdenado(long te) {
        super(te);
        this.tiempoEntrega = te;
        this.paquetes = new java.util.ArrayList<>();
    }
    /**
     * Recibe un paquete y lo guarda en su camión.
     * @param p paquete recibido
     */
    @Override
    public void subirCamion(Paquete p) {
        this.paquetes.add(p);
    }
    /**
     * Simula el envío de paquetes por el transportista. Ordena los paquetes antes de enviarlos.
     */
    public void enviar() {
        Collections.sort(this.paquetes);
        for (Paquete p:this.paquetes)
        {
            try {
                Thread.sleep(this.tiempoEntrega);
            } catch (InterruptedException ex) {
                System.out.println("Error en Thread.sleep(long): " + ex.getMessage());
            }
            System.out.println("El paquete " + p.getProducto() + " con prioridad "
                    + p.getPrioridad() + " ha llegado a: " + p.getDireccionDestino());
        }
    }
    /**
     * Devuelve la lista de paquetes en el camión del transportista
     * @return lista de paquetes
     */
    @Override
    public List<Paquete> getPaquetes() {
        return this.paquetes;
    }
}
