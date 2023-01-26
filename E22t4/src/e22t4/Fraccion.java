
package e22t4;

/**
 * Representa una Fracción que tiene un numerador y un denominador.
 * @author rperblac
 */
public class Fraccion {
    /**
     * el numerador de la fracción
     */
    private int numerador;
    /**
     * el denominador de la fracción
     */
    private int denominador;
    /**
     * Crea una Fracción que tiene un numerador y un denominador.
     * @param numerador el valor dividendo
     * @param denominador el valor divisor
     */
    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }
    /**
     * Devuelve el numerador de la fracción.
     * @return numerador de la fracción
     */
    public int getNumerador() {
        return this.numerador;
    }
    /**
     * Devuelve el denominador de la fracción.
     * @return denominador de la fracción
     */
    public int getDenominador() {
        return this.denominador;
    }
    /**
     * Devuelve un double con el valor real de la fracción.
     * @return resultado de dividir el numerador entre el denominador
     */
    public double getValorReal() {
        return ((double) this.getNumerador()) / ((double) this.getDenominador());
    }
    /**
     * Devuelve la fracción inversa de la fracción.
     * @return una fracción con numerador el denominador de la fracción de entrada, y denominador el numerador
     */
    public Fraccion getInversa() {
        return new Fraccion(this.denominador, this.numerador);
    }
    /**
     * Devuelve la suma de las fracciones dadas, sin simplificar.
     * @param a primera fracción
     * @param b segunda fracción
     * @return suma de las fracciones
     */
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        return new Fraccion(((a.getNumerador()*b.getDenominador())+(a.getDenominador()*b.getNumerador())),(a.getDenominador()*b.getDenominador()));
    }
    /**
     * Multiplica la primera fracción por la segunda.
     * @param a primera fracción
     * @param b segunda fracción
     * @return producto de las fracciones
     */
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        return new Fraccion((a.getNumerador()*b.getNumerador()),(a.getDenominador()*b.getDenominador()));
    }
    /**
     * Divide la primer fracción por la segunda.
     * @param a fracción dividendo
     * @param b fracción divisor
     * @return la fracción resultante de la división
     */
    public static Fraccion dividir(Fraccion a, Fraccion b) {
        return Fraccion.multiplicar(a, b.getInversa());
    }
}
