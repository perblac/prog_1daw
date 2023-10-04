/**Enunciado: Un equipo de 7 amigos futbolistas llamados Pedro, Luis, Miguel, Jorge, Juan, Manolo y Pepe echa a suerte quien se pone de portero. Para eso, todos sacan a la vez la mano y se cuenta el número de dedos que ha sacado cada uno. Entonces, se va contando de uno en uno y al que le toque, se pone de portero. Si al llegar al último jugador no se ha terminado, se sigue contando comenzando por el primero.
	Realiza un programa que muestre por pantalla el nombre del jugador que se pone de portero si el número de dedos que ha sacado cada amigo es:
	4 5 1 0 3 2 3
 *
 * @author rperblac
 */

public class E53t1 {

    public static void main(String args[]) {
        String[] equipo = {"Pedro", "Luis", "Miguel", "Jorge", "Juan", "Manolo", "Pepe"};
        int[] dedos = {4, 5, 1, 0, 3, 2, 3};
        int totaldedos, resto;
        totaldedos = dedos[0] + dedos[1] + dedos[2] + dedos[3] + dedos[4] + dedos[5] + dedos[6];
        resto = totaldedos % 7;
        if (resto == 0) {
            System.out.println(equipo[6]);
        } else {
            System.out.println(equipo[resto - 1]);
        }
    }
}
