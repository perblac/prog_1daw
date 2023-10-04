package e32t3;

/**
 * Enunciado: Calcula la suma de los cuadrados de los números comprendidos entre 5 y 13
 *
 * @author rperblac
 */
public class E32t3 {

    public static void main(String[] args) {
        int cuadrado, suma = 0;
        for (int i = 5; i <= 13; i++) {
            cuadrado = i * i;
            suma = suma + cuadrado;
        }
        System.out.println("La suma de los cuadrados de los números entre 5 y 13 es " + suma);
    }

}
