
package gente;

/**
 * Persona comparable con otras por su altura
 * @author rperblac
 */
public class Persona implements Comparable<Persona> {
    private String nombre;
    private double altura;
    /**
     * Crea una persona con un nombre y una altura aleatoria entre 1.50 y 2.10 metros.
     * @param nombre nombre para la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        this.altura = Math.round((((Math.random()*60)+150)/100)*100d)/100d;
    }
    /**
     * Devuelve el nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Devuelve la altura de la persona
     * @return altura de la persona
     */
    public double getAltura() {        
        return this.altura;
    }
    
    /**
     * Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @param o persona a comparar
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Persona o) {
        int altA = (int) (this.altura*100);
        int altB = (int) (o.getAltura()*100);
        int diferencia = 0;
        if (altA<altB) diferencia = -(altB-altA);
        if (altA>altB) diferencia = altA-altB;
        return diferencia;
    }

}
