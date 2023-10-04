package e41t2;

/** Enunciado: Haz un programa que calcule el valor de (0.38*4.93)^-0.36 y lo muestre por pantalla. Redondea el resultado al entero más cercano y muéstralo también por pantalla.
 *
 * @author rperblac
 */
public class E41t2 {

    public static void main(String[] args) {
        double numero = 0.38*4.93;
        double potencia = Math.pow(numero, -0.36);
        System.out.println("(0.38*4.93)^-0.36 = " + potencia);
        int redondeado = (int) Math.round(potencia);
        System.out.println("Redondeado: " + redondeado);
    }
    
}
