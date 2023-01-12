
package daw.persona;

/**
 *
 * @author rperblac
 */
public class DNI {
    public int numero;
    public char letra;
    public DNI(int n, char l){
        numero = n;
        letra = l;
    }
    public DNI(String dni){
        numero = Integer.parseInt(dni.substring(0, 8));
        letra = dni.charAt(8);
    }
       
}
