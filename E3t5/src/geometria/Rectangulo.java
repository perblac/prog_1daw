
package geometria;

/**
 * Representa un rectángulo que tiene una base, una altura y un área.
 * @author rperblac
 */
public class Rectangulo {
    /**
     * Base del rectángulo
     */
    private int base;
    /**
     * Altura del rectángulo
     */
    private int altura;
    /**
     * Áre del rectángulo
     */
    private int area;
    /**
     * Crea un rectángulo a partir de una base y una altura. Parámetros negativos se pasan a positivo automáticamente.
     * @param base base del rectángulo a crear
     * @param altura altur del rectángulo a crear
     * @throws Exception si alguno de los parámetros es 0
     */
    public Rectangulo(int base, int altura) throws Exception{
        if (base!=0) this.base = Math.abs(base);
        else throw new Exception("No se acepta base igual a 0");
        if (altura!=0) this.altura = Math.abs(altura);
        else throw new Exception("No se acepta altura igual a 0");
        this.area = this.base * this.altura;
    }
    /**
     * Cambia la base del rectángulo. Un parámetro negativo se pasa a positivo automáticamente.
     * @param b nueva base del rectángulo
     * @throws Exception si la nueva base es 0
     */
    public void setBase(int b) throws Exception {
        if (b!=0) this.base = Math.abs(b);
        else throw new Exception("No se acepta base igual a 0");
        this.area = this.base * this.altura;
    }
    /**
     * Cambia la altura del rectángulo. Un parámetro negativo se pasa a positivo automáticamente.
     * @param a nueva altura del rectángulo
     * @throws Exception si la nueva altura es 0
     */
    public void setAltura(int a) throws Exception {
        if (a!=0) this.altura = Math.abs(a);
        else throw new Exception("No se acepta altura igual a 0");
        this.area = this.base * this.altura;
    }
    /**
     * Devuelve el área del rectángulo.
     * @return área del rectángulo
     */
    public int getArea() {
        return this.area;
    }
    /**
     * Devuelve la base del rectángulo.
     * @return base del rectángulo
     */
    public int getBase() {
        return this.base;
    }
    /**
     * Devuelve la altura del rectángulo.
     * @return altura del rectángulo
     */
    public int getAltura() {
        return this.altura;
    }

}
