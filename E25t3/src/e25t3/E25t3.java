package e25t3;

/** Enunciado: Consulta el pdf de arrays y haz un programa en el que haya un array rellenado
con 5000 ceros. A continuación el programa modificará las posiciones impares y guardará un 1
en ellas. Al terminar, se mostrará el array en pantalla indicando el número que hay en cada
posición.
 *
 * @author rperblac
 */
import java.util.Arrays;

public class E25t3 {

    public static void main(String[] args) {
        byte[] miarray = new byte[5000];
        Arrays.fill(miarray, (byte) 0);
        for (int i = 0; i < miarray.length; i++)
        {
            if (!(i % 2 == 0)) miarray[i] = 1;
        }
        for (int i = 0; i < miarray.length; i++)
        {
            if (i % 8 == 0) System.out.println();
            System.out.print("Pos["+i+"]: " + miarray[i] + "\t");
            
        }
        
    }
    
}
