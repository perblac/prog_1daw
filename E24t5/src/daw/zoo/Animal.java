
package daw.zoo;

/**
 * Un animal que tiene un nombre, un peso y puede estar o no encerrado en un contenedor de animales.
 * @author rperblac
 */
public abstract class Animal {
    /**
     * Nombre del animal
     */
    private String nombre;
    /**
     * Peso del animal
     */
    private int peso;
    /**
     * Si está encerrado o no
     */
    private boolean encerrado;
    /**
     * Constructor por defecto de animal, con nombre y peso
     * @param n nombre del animal
     * @param p peso del animal
     */
    public Animal(String n, int p) {
        this.nombre = n;
        this.peso = p;
        this.encerrado = false;
    }
    /**
     * Devuelve el nombre del animal
     * @return nombre del animal
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve el peso del animal
     * @return peso del animal
     */
    public int getPeso() {
        return this.peso;
    }
    /**
     * Devuelve el estado de cautividad del animal
     * @return tru si está encerrado, false si no lo está
     */
    public boolean isEncerrado() {
        return this.encerrado;
    }
    /**
     * Establece el estado de cautividad del animal
     * @param b nuevo estado
     */
    void setEncerrado(boolean b) {
        this.encerrado = b;
    }
    /**
     * Devuelve el nombre y el peso del animal
     * @return cadena de "nombre, peso kg."
     */
    @Override
    public String toString() {
        return this.nombre + ", " + peso + " kg.";
    }
    /**
     * Compara un animal con otro objeto, a través del nombre
     * @param o objeto a comparar con el animal
     * @return true si los dos son animales y tienen el mismo nombre
     */
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Animal);
        {
            Animal a = (Animal) o;
            r = this.getNombre().equals(((Animal) o).getNombre());
        }
        return r;
    }
    /**
     * Devuelve un hashcode generado a partir del nombre y el peso
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return 3 + 7*this.nombre.hashCode() + 11*this.peso;
    }
    public abstract void emitirSonido();
}
