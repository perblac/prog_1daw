package e43t2;

/** Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca las clases Math y NumberFormat. Haz un programa que calcule el valor del número pi usando la siguiente fórmula: 𝜋 = 4 ∗ 𝑎𝑟𝑐 𝑡𝑔(1) y muestre el valor usando 4 cifras decimales.
 *
 * @author rperblac
 */
import java.lang.Math;
import java.text.NumberFormat;

public class E43t2 {

    public static void main(String[] args) {
        double pi = 4 * Math.atan(1);
        
        NumberFormat formato = NumberFormat.getInstance();
        formato.setMaximumFractionDigits(4);
        System.out.println("4 x arc tg(1) [con cuatro decimales] = " + formato.format(pi));
        
    }
    
}
