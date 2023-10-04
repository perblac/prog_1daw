/**Enunciado: : Indica cuáles de estas conversiones son posibles y cuáles no, indicando su tipo
 *
 * @author rperblac
 */
public class E32t1 {

    public static void main(String[] args) {

        int a = 8;
        char b = 'x';
        boolean c = true;
        double d = 2.25;

        /* estos no son posibles:
        int conversion1 = d;
        float conversion2 = c;
        boolean conversion3 = (boolean) a;
        float conversion4 = d;
        */

        // estos si:
        double conversion5 = a;
        short conversion6 = (short) a;
        long conversion7 = b;
        int conversion8 = (int) d;
        boolean conversion9 = c;
        char conversion10 = (char) d;

        // programa de prueba que imprime carateres y valor ascii del 1 al 128
        int letra;
        char caracter;

        for (letra = 1; letra < 129; ++letra) {
            caracter = (char) letra;
            System.out.print(letra + " " + caracter + " - ");
        }

    }

}
