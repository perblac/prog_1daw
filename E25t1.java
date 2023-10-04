/**Enunciado: Realiza “a mano” los siguientes cálculos con las variables booleanas A=true, B=false, C=false y D=true
	a) A || ( B && C)
	b) ( A && !B ) || ! (D && A)
	c) A || (B && ( D && C || (! (A || B) && C) ) )
	d) ! ( A || B) || (!A && !B)
	e) ( !C && ( !A || !B ) ) || ( D && ( ! (C && B) ) )
 *
 * @author rperblac
 */
public class E25t1 {

    public static void main(String[] args) {
        boolean A = true, B=false, C=false, D=true;
        System.out.println("a) "+ (A ||(B&&C)));
        System.out.println("b) "+ ((A && !B)||!(D&&A)));
        System.out.println("c) "+ (A||(B&&(D&&C ||(!(A||B)&&C)))));
        System.out.println("d) "+ (!(A||B)||(!A&&!B)));
        System.out.println("e) "+ ((!C&&(!A||!B))||(D&&(!(C&&B)))));
        }
    
}
