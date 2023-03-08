
package paqueteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Una empresa de paquetería en la que hay tres transportistas que tardan 10
 * minutos, 25 minutos y 50 minutos en enviar un paquete. Los paquetes se
 * asignan a los transportistas según su prioridad, de forma que los paquetes de
 * prioridad alta se asignan al transportista más rápido y así sucesivamente.
 * 
 * @author rperblac
 */
public class EmpresaPremium implements EmpresaPaqueteria {
    /**
     * Transportistas de la empresa
     */
    private Transportista rapido;
    private Transportista medio;
    private Transportista lento;
    /**
     * Crea una empresa de paqueteria premium con tres transportistas
     */
    public EmpresaPremium() {
        this.rapido = new Transportista(10);
        this.medio = new Transportista(25);
        this.lento = new Transportista(50);
    }
    /**
     * Acepta un pedido y lo asigna a un repartidor
     * @param p paquete del pedido
     */
    @Override
    public void registrarPedido(Paquete p) {
        switch(p.getPrioridad()) {
            case Paquete.ALTA:
                this.rapido.subirCamion(p);
                break;
            case Paquete.MEDIA:
                this.medio.subirCamion(p);
                break;
            case Paquete.BAJA:
                this.lento.subirCamion(p);
                break;
        }
    }
    /**
     * Devuelve una lista con los transportistas que trabajan para la empresa de transportes.
     * @return lista de transportistas de la empresa
     */
    @Override
    public List<Transportista> getTransportistas() {
        ArrayList<Transportista> lista = new ArrayList<>();
        lista.add(this.rapido);
        lista.add(this.medio);
        lista.add(this.lento);
        return lista;
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
