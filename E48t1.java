/**Enunciado: : Realiza un programa en el que haya una variable entera llamada año inicializada con cualquier valor positivo. El programa mostrará por pantalla si el año guardado en dicha variable es bisiesto. Ten en cuenta que un año es bisiesto cuando se cumple alguna de estas dos condiciones:
	a) Es múltiplo de 400
	b) No es múltiplo de 400, pero es múltiplo de 4 y no es múltiplo de 100
 *
 * @author rperblac
 */
public class E48t1 {
	
    public static void main(String args[]) {
        int año = 2022;
        if ((año%400==0)||((año%4==0)&&(año%100>0)))
        {System.out.println("Es bisiesto");}
        else
        {System.out.println("No es bisiesto");}
    }
}
