/**Enunciado: : Realiza un programa que pregunte al usuario su año de nacimiento, si es hombre o mujer, su altura (en metros), peso (en kg) y muestre por pantalla su frecuencia cardiaca máxima, su índice de masa corporal y su estado según la Organización Mundial de la Salud.
	- Frecuencia cardiaca máxima: Si es hombre se calcula como 220 - edad, y si es mujer se calcula como 226 - edad.
	- Índice de masa corporal (IMC): Se calcula dividiendo el peso entre la altura elevada al cuadrado y se muestra con dos cifras decimales.
	- El estado según la OMS se mira en esta tabla:
	IMC 				Estado
	Menor de 16.00 		Infrapeso: delgadez severa
	Entre 16.00 y 16.99 Infrapeso: delgadez moderada
	Entre 17.00 y 18.49 Infrapeso: delgadez aceptable
	Entre 18.50 y 24.99 Peso normal
	Entre 25.00 y 29.99 Sobrepeso
	Entre 30.00 y 34.99 Sobrepeso: tipo I
	Entre 35.00 y 40.00 Sobrepeso: tipo II
	Mayor de 40.00 		Sobrepeso: tipo III
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.System.out;

public class E46t1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int añonacimiento, edad, fCardiacaMax = -1;
        String sexo, estado;
        float altura_m, peso_kg, imc;

        out.println("Año de nacimiento: ");
        añonacimiento = leer.nextInt();
        edad = (2022 - añonacimiento);

        out.println("¿Es hombre o mujer?");
        sexo = leer.next();
        while (!(sexo.equals("hombre")) && !(sexo.equals("mujer"))) {
            out.println("Por favor escriba 'hombre' o 'mujer':");
            sexo = leer.next();
        }

        out.println("Altura en metros: ");
        altura_m = leer.nextFloat();
        out.println("Peso en kilogramos: ");
        peso_kg = leer.nextFloat();

        if (sexo.equals("hombre")) {
            fCardiacaMax = (220 - edad);
        } else if (sexo.equals("mujer")) {
            fCardiacaMax = (226 - edad);
        }

        imc = (peso_kg / (altura_m * altura_m));

        if (imc < 16) {
            estado = "Infrapeso: delgadez severa";
        } else if (imc < 17) {
            estado = "Infrapeso: delgadez moderada";
        } else if (imc < 18.50) {
            estado = "Infrapeso: delgadez aceptable";
        } else if (imc < 25) {
            estado = "Peso normal";
        } else if (imc < 30) {
            estado = "Sobrepeso";
        } else if (imc < 35) {
            estado = "Sobrepeso: Tipo I";
        } else if (imc <= 40) {
            estado = "Sobrepeso: Tipo II";
        } else {
            estado = "Sobrepeso: Tipo III";
        }

        out.println("Edad: " + edad + " Sexo: " + sexo + "\nFrecuencia cardiaca máxima: "
                + fCardiacaMax + "\nÍndice de Masa Corporal: " + imc + "\nEstado: " + estado);
    }
}
