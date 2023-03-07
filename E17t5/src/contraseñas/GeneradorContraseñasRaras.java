package contraseñas;

import java.util.Random;

/**
 * Generador de contraseñas únicas que genera una contraseña única, y sustituye
 * cada uno de sus caracteres por el que se obtiene sumando 122 a su código
 * ascii.
 *
 * @author rperblac
 */
public class GeneradorContraseñasRaras extends GeneradorContraseñasUnicas{
    /**
     * Crea un generador de contraseñas raras, creando su Random interno
     */
    public GeneradorContraseñasRaras() {
        super();
    }
    /**
     * Crea un generador de contraseñas raras con el Random suministrado.
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñasRaras(Random r) {
        super(r);
    }
    /**
     * Genera una contraseña usando el total de caracteres pasado como parámetro.
     * @param longitud longitud de la contraseña deseada
     * @return cadena de contraseña generada
     */
    @Override
    public String generarContraseña(int longitud) {
        String c = super.generarContraseña(longitud);        
        return transCaracter(c);
    }
    /**
     * Método interno para sumar 122 a cada caracter
     * @param s cadena de entrada
     * @return cadena invertida
     */
    private String transCaracter(String s) {
        String r = "";
        for (char c:s.toCharArray()) {
            c += 122;
            r += c;
        }
        return r;
    }
}
