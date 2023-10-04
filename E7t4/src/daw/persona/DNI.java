
package daw.persona;

/**
 * Un DNI compuesto por un número y una letra
 *
 * @author rperblac
 */
public class DNI {
    /**
     * Parte numérica del DNI (8 cifras)
     */
    public int numero;
    /**
     * Letra del DNI (en mayúsculas)
     */
    public char letra;
    /**
     * Crea un DNI a partir del número y letra recibidos como parámetros. No se realizará ninguna comprobación de que el DNI sea correcto. 
     * @param n la parte numérica
     * @param l la letra
     */
    public DNI(int n, char l){
        numero = n;
        letra = l;
    }
    /**
     * Crea un DNI a partir de un String que guarda el número con la letra.
     * @param dni el dni completo (ej "12345678A")
     */
    public DNI(String dni){
        numero = Integer.parseInt(dni.substring(0, 8));
        letra = dni.charAt(8);
    }
       
}
