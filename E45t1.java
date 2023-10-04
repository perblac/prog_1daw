/**Enunciado: Haz un programa que nos diga el tipo de triángulo que forman tres longitudes A, B y C:
	- Rectángulo: A² = B² + C²
	- Acutángulo: A² < B² + C²
	- Obtusángulo: A² > B² + C²
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E45 {
	
	public static void main(String[] args){
		float A, B, C;
		System.out.println("A? ");
		A = new Scanner(System.in).nextFloat();
		System.out.println("B? ");
		B = new Scanner(System.in).nextFloat();
		System.out.println("C? ");
		C = new Scanner(System.in).nextFloat();
		System.out.println("A^2="+A*A+" B^2="+B*B+" C^2="+C*C);
		if ((((B*B)+(C*C))==(A*A))){
			System.out.println("Es un triángulo rectángulo");
		} else if ((((B*B)+(C*C))>(A*A))){
			System.out.println("Es un triángulo acutángulo");
		} else if ((((B*B)+(C*C))<(A*A))){
			System.out.println("Es un triángulo obtusángulo");
		}
	}
}