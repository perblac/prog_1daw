
package construccion;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Es un edificio que tiene una capacidad máxima de clientes. También tiene una lista con los nombres de los clientes que están en el hotel.
 * @author rperblac
 */
public class Hotel extends Edificio{
    /**
     * Lista de clientes del hotel
     */
    private List<String> clientes;
    /**
     * Máximo número de clientes del hotel
     */
    private int maximo;
    /**
     * Construye un nuevo hotel con una dirección, un número de plantas y un máximo de clientes.
     * @param d dirección
     * @param np número de plantas
     * @param m máximo de clientes
     * @throws IllegalArgumentException si el máximo de clientes es negativo.
     */
    public Hotel(String d, int np, int m) throws IllegalArgumentException {
        super(d,np);
        if (m<0) throw new IllegalArgumentException("Capacidad máxima de clientes negativa");
        this.maximo = m;
        this.clientes = new ArrayList();
    }
    /**
     * Añade un cliente a la lista de clientes del hotel
     * @param c cliente a añadir
     * @throws IllegalStateException si ya se alcanzó el máximo de clientes del hotel
     */
    public void añadirCliente(String c) throws IllegalStateException {
        if (this.clientes.size() == this.maximo) throw new IllegalStateException("Máximo número de clientes alcanzado");
        this.clientes.add(c);
    }
    /**
     * Retira un cliente de la lista de clientes del hotel
     * @param c cliente a retirar
     * @throws NoSuchElementException si el cliente no está en la lista de clientes
     */
    public void retirarCliente(String c) throws NoSuchElementException {
        if (this.clientes.contains(c)) this.clientes.remove(c);
        else throw new NoSuchElementException("El cliente " + c +" no está en el hotel");
    }
    /**
     * Devuelve el número de clientes que hay en el hotel
     * @return número de clientes
     */
    public int getNumeroClientes() {
        return this.clientes.size();
    }
}
