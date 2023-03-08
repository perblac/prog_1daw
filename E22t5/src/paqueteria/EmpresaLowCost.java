
package paqueteria;

import java.util.List;

/**
 * Una empresa de paquetería en la que guarda una lista de transportistas y los
 * paquetes se asignan de forma cíclica a los transportistas.
 *
 * @author rperblac
 */
public class EmpresaLowCost implements EmpresaPaqueteria {
    /**
     * Array de transportistas de la empresa
     */
    private Transportista[] transportistas;
    /**
     * Índice del siguiente transportista al que se le asignará un paquete
     */
    private int siguienteTransportista;
    /**
     * Crea una empresa low costo con un número de transportistas
     * @param n número de transportistas de la empresa
     */
    public EmpresaLowCost(int n) {
        n = (n<1)?1:n;
        this.transportistas = new Transportista[n];
        for (int i = 0; i < n; i++)
        {
            Transportista t = new Transportista((long) (Math.random()*40) + 40);
            this.transportistas[i] = t;
        }
        this.siguienteTransportista = 0;
    }
    /**
     * Asigna el paquete de un pedido al siguiente transportista de la empresa
     * @param p paquete a asignar
     */
    @Override
    public void registrarPedido(Paquete p) {
        this.transportistas[this.siguienteTransportista].subirCamion(p);
        this.siguienteTransportista = (this.siguienteTransportista == (this.transportistas.length - 1))?0:(this.siguienteTransportista + 1);
    }
    /**
     * Devuelve una lista con los transportistas que trabajan para la empresa de transportes.
     * @return lista de transportistas de la empresa
     */
    @Override
    public List<Transportista> getTransportistas() {
        return List.of(this.transportistas);
    }
    /**
     * Recorre la lista de transportistas y les ordena que envíen los paquetes que tienen asignados.
     */
    @Override
    public void enviarPaquetes() {
        for (Transportista t:this.getTransportistas())
        {
            t.enviar();
        }
    }
    
}
