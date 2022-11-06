/**Enunciado: Haz un programa que pregunte al usuario por su número de DNI. El programa mostrará la letra que corresponde a dicho DNI, teniendo en cuenta que se obtiene así:
	- Calculamos el resto de dividir el número de DNI entre 23
	- Buscamos en la siguiente lista la letra que corresponde a dicho resto y esa será la letra del DNI
	0>'T',1>'R',2>'W',3>'A',4>'G',5>'M'
	6>'Y',7>'F',8>'P',9>'D',10>'X',11>'B'
	12>'N',13>'J',14>'Z',15>'S',16>'Q',17>'V'
	18>'H',19>'L',20>'C',21>'K',22>'E',23>'T'
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E51t1 {
    public static void main(String args[]) {
        System.out.print("Introduzca DNI: ");
        int dni= new Scanner(System.in).nextInt();
        
        int resto = dni%23;
        char[] letra = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E','T'};
        
        System.out.print("\nLetra -> "+letra[resto]);
        
    }
}
