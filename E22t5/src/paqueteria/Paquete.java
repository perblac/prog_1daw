
package paqueteria;

/**
 * Representa un paquete que tiene un producto, una dirección de destino y un número que indica su prioridad.
 * @author rperblac
 */
public class Paquete implements Comparable<Paquete>{
    /**
     * Valores de prioridad del paquete
     */
    public static final int ALTA = 1;
    public static final int MEDIA = 2;
    public static final int BAJA = 3;
    /**
     * Producto del paquete
     */
    private String producto;
    /**
     * Dirección de destino del paquete
     */
    private String direccionDestino;
    /**
     * Prioridad del paquete
     */
    private int prioridad;
    /**
     * Crea un paquete con un producto, una dirección de destino y una prioridad
     * @param pro producto del paquete
     * @param dd dirección de destino del paquete
     * @param pri prioridad del paquete
     */
    public Paquete(String pro, String dd, int pri) throws IllegalArgumentException{        
        if (pri<1||pri>3) throw new IllegalArgumentException("Prioridad incorrecta");
        else this.prioridad = pri;
        this.producto  = pro;
        this.direccionDestino = dd;
    }
    /**
     * Devuelve el producto de un paquete
     * @return producto del paquete
     */
    public String getProducto() {
        return this.producto;
    }
    /**
     * Devuelve la dirección de destino del paquete
     * @return dirección de destino del paquete
     */
    public String getDireccionDestino() {
        return this.direccionDestino;
    }
    /**
     * Devuelve la prioridad del paquete
     * @return prioridad del paquete
     */
    public int getPrioridad() {
        return this.prioridad;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Paquete)
        {
            Paquete p = (Paquete) o;
            r = (this.getDireccionDestino().equals(p.getDireccionDestino())
                    &&this.getProducto().equals(p.getProducto()));
        }
        return r;
    }
    
    @Override
    public int hashCode() {
        return 3*this.producto.hashCode() + 7*this.direccionDestino.hashCode() + 11*this.prioridad;
    }
    
    /**
     * Compara dos paquetes en base a su prioridad
     * @param p paquete a comparar con el parámetro implícito
     * @return diferencia entre prioridades
     */
    @Override
    public int compareTo(Paquete p) {
        int r;
        r = this.getPrioridad() - p.getPrioridad();
        return r;
    }
}
