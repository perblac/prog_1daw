
package e25t4;

/**
 * Representa una Bola de Dragón. La clase está diseñada para que solo se puedan crear en la memoria RAM un máximo de 7 bolas. Al intentar crear la octava, se lanzará una excepción.
 * @author rperblac
 */
public class BolaDragon {
    /**
     * Indica la cantidad máxima de bolas que se pueden crear.
     */
    private static final int MAXIMO_BOLAS;
    
    /**
     * El número de la siguiente bola de dragón que se generará. Por defecto, valdrá 1.
     */
    private static int siguienteBola;
    
    /**
     * El número que tiene la bola de dragón.
     */
    private int numero;
    static {
        MAXIMO_BOLAS = 7;
        siguienteBola = 1;
    }
    
    /**
     * Crea una bola de dragón con el número introducido.
     * @param numero el número de la bola
     */
    private BolaDragon(int numero) {
        this.numero = numero;
        siguienteBola++;
    }
    
    /**
     * Devuelve el número de la bola de dragón.
     * @return el número de la bola
     */
    public int getNúmero() {
        return this.numero;
    }
    
    /**
     * Si se ha alcanzado la cantidad máxima de bolas creadas, el método lanzará una excepción con el mensaje “Ya se han creado 7 bolas de dragón”. En caso contrario, se creará una nueva bola de dragón con el número que indique la propiedad “siguienteBola”.
     * 
     * @return una nueva bola de dragón con el siguiente número libre
     * @throws Exception si se ha alcanzado la cantidad máxima de bolas creadas
     */
    public static BolaDragon crearBolaDragon() throws Exception {
        Exception e = new Exception("Ya se han creado 7 bolas de dragón");
        BolaDragon bola;
        if (siguienteBola > MAXIMO_BOLAS) throw e;
        else
        {
            bola = new BolaDragon(siguienteBola);            
        }
        return bola;
    }
    
    /**
     * Reinicia la creación de bolas de dragón
     */
    public static void reiniciar() {
        siguienteBola = 1;
    }

}
