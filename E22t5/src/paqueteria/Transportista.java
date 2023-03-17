
package paqueteria;

import java.util.List;

/**
 * Representa una persona que puede enviar un paquete a su destino. Posee una
 * lista con todos los paquetes que tiene que enviar y además tiene una
 * propiedad que indica el número de minutos que tarda en enviar un paquete.
 *
 * @author rperblac
 */
public class Transportista {
    /**
     * Lista de paquetes a enviar
     */
    private List<Paquete> paquetes;
    /**
     * Minutos que tarda en enviar un paquete
     */
    private long tiempoEntrega;
    /**
     * Crea un transportista que tarda en enviar un paquete el número de minutos
     * que se pasa como parámetro, y no tiene ningún paquete asignado.
     *
     * @param te tiempo que tarda en enviar un paquete
     */
    public Transportista(long te) {
        this.tiempoEntrega = te;
        this.paquetes = new java.util.ArrayList<>();
    }
    /**
     * Recibe un paquete y lo guarda en su camión.
     * @param p paquete recibido
     */
    public void subirCamion(Paquete p) {
        this.paquetes.add(p);
    }
    /**
     * Simula el envío de paquetes por el transportista.
     */
    public void enviar() {
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
        this.paquetes.clear();
    }
    /**
     * Devuelve la lista de paquetes en el camión del transportista
     * @return lista de paquetes
     */
    public List<Paquete> getPaquetes() {
        return this.paquetes;
    }
}
