
package contraseñas;

import java.util.Random;

/**
 * Representa un objeto que genera contraseñas aleatorias
 * @author rperblac
 */
public class GeneradorContraseñas {
    /**
     *  Objeto que la clase usa internamente para generar números aleatorios que den lugar a las letras de las contraseñas
     */
    private Random random;
    /**
     * Crea un generador de contraseñas, creando su Random interno
     */
    public GeneradorContraseñas() {
        this.random = new Random();
    }
    /**
     * Crea un generador de contraseñas con el Random suministrado.
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñas(Random r) {
        this.random = r;
    }
    /**
     * Genera una contraseña usando el total de caracteres pasado como parámetro.
     * @param longitud longitud de la contraseña deseada
     * @return cadena de contraseña generada
     */
    public String generarContraseña(int longitud) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < longitud; i++){
            int tipo = random.nextInt(3);
            switch (tipo){
                case 0:
                    s.append((char) (random.nextInt(10)+48));
                    break;
                case 1:
                    s.append((char) (random.nextInt(26)+65));
                    break;
                case 2:
                    s.append((char) (random.nextInt(26)+97));
                    break;
            }                
        }
        return s.toString();
    }
    /**
     * Genera una contraseña de 8 caracteres.
     * @return cadena de contraseña generada
     */
    public String generarContraseña() {
        return this.generarContraseña(8);
    }
}
