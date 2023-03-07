
package contraseñas;

import java.util.Random;

/**
 * Generador de contraseñas únicas que genera una contraseña única y después le
 * cambia todas las letras que estén en mayúsculas por minúsculas, y viceversa.
 *
 * @author rperblac
 */
public class GeneradorContraseñasInvertidas extends GeneradorContraseñasUnicas {
    /**
     * Crea un generador de contraseñas invertidas, creando su Random interno
     */
    public GeneradorContraseñasInvertidas() {
        super();
    }
    /**
     * Crea un generador de contraseñas invertidas con el Random suministrado.
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñasInvertidas(Random r) {
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
        return invertirMayusculas(c);
    }
    /**
     * Método interno para pasar mayúsculas a minúsculas y viceversa
     * @param s cadena de entrada
     * @return cadena invertida
     */
    private String invertirMayusculas(String s) {
        String r = "";
        for (char c:s.toCharArray()) {
            if (Character.isLowerCase(c)) c = Character.toUpperCase(c);
            else if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
            r += c;
        }
        return r;
    }
}
