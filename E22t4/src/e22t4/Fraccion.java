
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
     * @throws Exception si el denominador es cero
     */
    public Fraccion(int numerador, int denominador) throws Exception{
        if (denominador == 0)
        {
            throw new Exception("No se puede definir una fracción con denominador 0");
        }
        else
        {
            this.numerador = numerador;
            this.denominador = denominador;            
        }
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
     * @throws Exception si se pide la inversa de una fracción con numerador cero
     */
    public Fraccion getInversa() throws Exception{
        Fraccion a;
        try
        {
            a = new Fraccion(this.denominador, this.numerador);            
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return a;
    }
    /**
     * Devuelve la suma de las fracciones dadas, sin simplificar.
     * @param a primera fracción
     * @param b segunda fracción
     * @return suma de las fracciones
     */
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        Fraccion s;
        try
        {
            s = new Fraccion(((a.getNumerador()*b.getDenominador())+(a.getDenominador()*b.getNumerador())),(a.getDenominador()*b.getDenominador()));           
        } catch (Exception e)
        { s = null; }
        return s;
    }
    /**
     * Multiplica la primera fracción por la segunda.
     * @param a primera fracción
     * @param b segunda fracción
     * @return producto de las fracciones
     */
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        Fraccion m;
        try
        {
            m = new Fraccion((a.getNumerador()*b.getNumerador()),(a.getDenominador()*b.getDenominador()));
        } catch (Exception e)
        { m = null; }
        return m;
    }
    /**
     * Divide la primer fracción por la segunda.
     * @param a fracción dividendo
     * @param b fracción divisor
     * @return la fracción resultante de la división
     * @throws Exception si se intenta dividir por una fracción con numerador cero
     */
    public static Fraccion dividir(Fraccion a, Fraccion b) throws Exception {
        Fraccion d;
        try
        {
            d = Fraccion.multiplicar(a, b.getInversa());
        } catch (Exception e)
        {
            throw new Exception ("División por cero");
        }
        
        return  d;
    }
}
