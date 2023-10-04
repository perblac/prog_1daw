/**Enunciado:  La siguiente gráfica recoge los ingresos y gastos de una empresa en un año: (tabla)
	Haz un programa que muestre por pantalla:
	a) Si cada mes ha tenido un balance positivo o negativo.
	b) La media de ingresos y gastos anual
	c) El balance final anual y si ha sido positivo o no.
 *
 * @author rperblac
 */
public class E35t1 {

    public static void main(String[] args) {
        int i1 = 15000, i2 = 16000, i3 = 10000, i4 = 9000, i5 = 12000, i6 = 13000, i7 = 7000, i8 = 6000, i9 = 100, i10 = 13000, i11 = 14000, i12 = 15000;
        int g1 = 8000, g2 = 9000, g3 = 11000, g4 = 10000, g5 = 12000, g6 = 10000, g7 = 9000, g8 = 8000, g9 = 9000, g10 = 9000, g11 = 12000, g12 = 14000;
        byte mes;
        int suma;
        System.out.println("Balance\n-------");
        for (mes=1;mes<13;mes++)
        {
            if (mes==1)
            {
                suma=i1-g1;
                System.out.print("Enero :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==2)
            {
                suma=i2-g2;
                System.out.print("Febrero :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==3)
            {
                suma=i3-g3;
                System.out.print("Marzo :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==4)
            {
                suma=i4-g4;
                System.out.print("Abril :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==5)
            {
                suma=i5-g5;
                System.out.print("Mayo :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==6)
            {
                suma=i6-g6;
                System.out.print("Junio :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==7)
            {
                suma=i7-g7;
                System.out.print("Julio :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==8)
            {
                suma=i8-g8;
                System.out.print("Agosto :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==9)
            {
                suma=i9-g9;
                System.out.print("Septiembre :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==10)
            {
                suma=i10-g10;
                System.out.print("Octubre :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==11)
            {
                suma=i11-g11;
                System.out.print("Noviembre :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
            if (mes==12)
            {
                suma=i12-g12;
                System.out.print("Diciembre :");
                if ((suma/2)>=0)
                {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }
        }
        
        int ianual=(i1+i2+i3+i4+i5+i6+i7+i8+i9+i10+i11+i12);
        float mediai= ianual/12;
        int ganual=(g1+g2+g3+g4+g5+g6+g7+g8+g9+g10+g11+g12);
        float mediag= ganual/12;
        System.out.println("\nMedia de ingresos: "+mediai);
        System.out.println("Media de gastos: "+mediag);
        
        int balance= ianual-ganual;
        char balancep;
        if (balance>=0){balancep='+';}else{balancep='-';}
        System.out.println("\nBalance: "+balance+"\n¿Es positivo o negativo? "+balancep);
    }

}
