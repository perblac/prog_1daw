
package daw.persona;

/**
 * Clase DNIMejorado, que representa un DNI cuyo número de letra se calcula automáticamente
 * @author rperblac
 */
public class DNIMejorado {
    /**
     * El número del dni
     */
    private int número;
    
    /**
     * La letra del dni
     */
    private char letra;
    
    /**
     * Crea un DNI cuyo número se pasa como parámetro y cuya letra se obtiene llamando al método privado calcularLetra.
     * @param n el número del dni a crear
     */
    public DNIMejorado(int n) {
        this.número = n;
        this.letra = calcularLetra(n);
    }
    
    /**
     * Devuelve el número del DNI.
     * @return número del dni
     */
    public int getNumero() {
        return this.número;
    }
    
    /**
     * Devuelve la letra del DNI.
     * @return letra del dni
     */
    public char getLetra() {
        return this.letra;
    }
    
    /**
     * Recibe un número y nos devuelve la letra que tendría el DNI correspondiente a ese número.
     * @param n número del dni
     * @return letra correspondiente al número n
     */
    private char calcularLetra(int n) {
        int resto = n%23;
        char[] letra = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E','T'};
        return letra[resto];
    }

}
