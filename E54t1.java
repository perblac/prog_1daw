/**Enunciado: Repite el ejercicio 42 usando el if corto
 *
 * @author rperblac
 */
public class E54t1 {

    public static void main(String args[]) {
        String[] equipo = {"Pedro", "Luis", "Miguel", "Jorge", "Juan", "Manolo", "Pepe"};
        int[] dedos = {4, 5, 1, 0, 3, 2, 3};
        int totaldedos, resto, elegido;
        totaldedos = dedos[0] + dedos[1] + dedos[2] + dedos[3] + dedos[4] + dedos[5] + dedos[6];
        resto = (totaldedos % 7);
        elegido = resto == 0 ? 6 : resto - 1;
        System.out.println(equipo[elegido]);
    }
}
