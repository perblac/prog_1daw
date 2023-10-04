/**Enunciado: Repite el ejercicio 35 usando listas.
 *
 * @author rperblac
 */
public class E36t1 {

    public static void main(String[] args) {
        int[] ingresos = {15000, 16000, 10000, 9000, 12000, 13000, 7000, 6000, 11000, 13000, 14000, 15000};
        int[] gastos = {8000, 9000, 11000, 10000, 12000, 10000, 9000, 8000, 9000, 9000, 12000, 14000};
        String[] mes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        int meses = (mes.length) - 1;
        byte ciclo;
        int sumai = 0, sumag = 0;
        for (ciclo = 0; ciclo <= meses; ciclo++) {

            sumai = sumai + ingresos[ciclo];
            sumag = sumag + gastos[ciclo];

            System.out.print("Balance " + mes[ciclo] + " ");
            if (ingresos[ciclo] - gastos[ciclo] >= 0) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }

        System.out.println("\nMedia ingresos: " + sumai / 12);
        System.out.println("Media gastos: " + sumag / 12);

        System.out.print("\nBalance anual: " + (sumai - sumag));
        if ((sumai - sumag) >= 0) {
            System.out.println(" (positivo)");
        } else {
            System.out.println(" (negativo)");
        }
    }

}
