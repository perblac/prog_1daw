package e41t3;

/** Enunciado: El juego del tesoro
    Usa la capa de texto de la ConsolaDAW para realizar un sencillo juego que consiste en
    encontrar un tesoro oculto, de esta forma:
    - El jugador parte con 0 puntos, nivel 1 y tiene 80 movimientos disponibles. La posición
    inicial del jugador es el punto de coordenadas (40,15)
    - El ordenador calcula las coordenadas (x,y) del tesoro de forma aleatoria, teniendo en
    cuenta el número máximo de filas y columnas de la capa de texto.
    - El jugador es una letra O situada en las coordenadas del jugador, mientras que el
    tesoro no se ve. La pantalla muestra los puntos, nivel y movimientos disponibles.
    - El jugador usa las siguientes teclas para moverse por la pantalla:
            W Arriba
            A Izquierda
            D Derecha
            S Abajo
    - Cada vez que se mueve el jugador, disminuye en uno su número de movimientos
    disponibles. Si éste llega a cero, se acaba la partida y se muestra en pantalla con el
    signo $ la posición del tesoro.
    - Al moverse el jugador, en la parte superior de la pantalla aparecerán las palabras MUY
    FRIO, FRIO, CALIENTE o QUEMANDO, según sea la distancia desde el tesoro hasta el
    jugador, que se calcula con la siguiente fórmula:
            𝑑 = sqr((xj-xt)^2+(yj-yt)^2)
    Donde suponemos que la posición del jugador es (xj,yj) y la del tesoro es (xt,yt). Tras
    calcular la distancia buscamos en la tabla la palabra correspondiente:
            Distancia       Palabra
            Mayor de 35     Muy frio
            Entre 15 y 35   Frio
            Entre 5 y 15    Caliente
            Menos de 5      Quemando
    - Si el jugador se mueve y acierta con la posición del tesoro, se informará al usuario y se
    pasará al siguiente nivel. Los puntos se incrementarán con el número de movimientos
    que le queden. El número de movimientos disponible se incrementará en 10 unidades
    al pasar al siguiente nivel.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.util.Random;

public class E41t3 {
    
    static void imprimeInstrucciones(CapaTexto c, Teclado t)
    {
        int anchop = c.getNumeroColumnas();
        int altop = c.getNumeroFilas();  
        String titulo = "INSTRUCCIONES";
        String par1 = "Encuentre el tesoro antes de que se le acaben los movimientos";
        String par2 = "Cada nivel tiene 10 movimientos más, y ganará 5 puntos x nivel superado";
        String linea1 = "Izquierda/Derecha: A/D";
        String linea2 = "Arriba/Abajo: W/S";
        String linea3 = "Terminar partida: P";
        c.cls();
        imprimeLinea(c, 1);
        c.print(1, (anchop/2)-(titulo.length()/2), titulo);
        c.print(6, (anchop/2)-(par1.length()/2), par1);
        c.print(8, (anchop/2)-(par2.length()/2), par2);
        c.print(altop/2, (anchop/2)-(linea1.length()/2), linea1);
        c.print((altop/2)+2, (anchop/2)-(linea2.length()/2), linea2);
        c.print((altop/2)+4, (anchop/2)-(linea3.length()/2), linea3);            
        t.leerCaracter();
        c.cls();
    }
    
    static void imprimeMenu(CapaTexto c, int puntos, int max)
    {
        String titulo = "EL JUEGO DEL TESORO", opcion1 = "1.- JUGAR", opcion2 = "2.- INSTRUCCIONES", opcion3 = "3.- SALIR";
        String record = "HiSCORE: ";
        int anchop = c.getNumeroColumnas();
        int altop = c.getNumeroFilas();
        imprimeLinea(c, 1);
        c.print(1, (anchop/2)-(titulo.length()/2), titulo);
        c.print(altop/2, (anchop/2)-(opcion2.length()/2), opcion1);
        c.print((altop/2)+2, (anchop/2)-(opcion2.length()/2), opcion2);
        c.print((altop/2)+4, (anchop/2)-(opcion2.length()/2), opcion3);
        c.print(c.getNumeroFilas()-1, 1, "Última puntuación: "+ puntos);
        c.print(c.getNumeroFilas()-1, c.getNumeroColumnas()-(record.length()+Integer.toString(max).length()+1), record + "" + max);
    }
    
    static void imprimeLinea(CapaTexto c, int a)
    {
        // a = 0: linea rápida / a = 1: linea con retardo
        
        for (int l = 0; l < c.getNumeroColumnas(); l++)
                {
                    c.print(2, l, "-");
                    try
                    {
                        if (a == 1)
                        {
                        Thread.sleep(10);
                        }
                    } catch (Exception e)
                    {
                        c.println("Error. " + e);
                    }
                }
    }
    
    static void imprimeMarcador(CapaTexto t, int n, int p, int m, String c)
    {            
            imprimeLinea(t, 0);
            t.print(1, 1, "Nivel: " + n);
            t.print(1,t.getNumeroColumnas()/5, "Puntos: " + p);
            t.print(1, t.getNumeroColumnas()/3 + 4,"Movimientos restantes: " + m);
            t.print(1, (t.getNumeroColumnas()/5)*4, c);
    }
    
    public static void main(String[] args) {
        // Declaracion de variables
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        int anchop = capat.getNumeroColumnas();
        int altop = capat.getNumeroFilas();
        int puntos = 0, ultimapuntuacion, maxpuntos = 0, nivel, nuevomov, movimientos, calcpista;
        String pista = null;
        int xj = 4, yj = 4, xt = 3, yt = 3;
        Random generador = new Random();
        char personaje = '☻', entrada;
        String puntuacion = "PUNTUACIÓN: ", fin = "FIN DE PARTIDA", textogana = "¡TESORO ENCONTRADO!";
        boolean finjuego, gana, salir, menu, buenapos;
        // cheat
        boolean cheat;
        tecl.activarEco(false);
        tecl.setTipoCursor(Teclado.CURSOR_NULO);        
        
        // Empezamos poniendo salir a false
        salir = false;
        // Bucle principal, se sale cuando salir = true
        do
        {            
            // Inicialización de variables cuando no hay partida
            finjuego = false; gana = false;
            ultimapuntuacion = puntos;
            puntos = 0;
            nivel = 1;
            nuevomov = 80;
            movimientos = nuevomov;
            if (ultimapuntuacion > maxpuntos) maxpuntos = ultimapuntuacion;
            // cheat
            cheat = false;
            
            // Imprime menú principal
            capat.cls();
            //imprimeLinea(capat, 1);
            imprimeMenu(capat, ultimapuntuacion, maxpuntos);
                        
            // Entrada de menu. menu = true cuando se ha introducido una
            // opción válida
            do
            {
                entrada = tecl.leerCaracter();
                menu = false;
                switch (entrada)
                        {
                    case '1':
                        menu = true;
                        break;
                    case '2':
                        imprimeInstrucciones(capat, tecl);
                        imprimeMenu(capat, ultimapuntuacion, maxpuntos);
                        break;
                    case '3':
                        menu = true;
                        salir = true;
                        break;
                    case 'ñ':
                        cheat = true;
                        break;
                }
            } while(!menu);
            
            // Si no salimos, jugamos nueva partida
            if (!salir)
            {                
                // Generar posiciones iniciales nuevas
                buenapos = false;
                while (!buenapos)
                {
                    xt = generador.nextInt(anchop) + 1;
                    yt = generador.nextInt(altop - 5) + 4;
                    xj = anchop / 2;
                    yj = altop / 2 + 3;
                    if ((xj != xt) || (yj != yt)) buenapos = true; // Si coinciden ambas coordenadas, repetimos
                }
                
                do // Bucle de juego
                {
                    // Refrescamos la pantalla cada ciclo
                    capat.cls();                    
                    
                    // Comprobamos si se ha ganado, y si es asi reiniciamos valores
                    // para el siguiente nivel
                    if (gana==true)
                    {
                        gana = false;
                        puntos = puntos + movimientos + (5 * nivel);
                        nivel = nivel + 1;
                        nuevomov = nuevomov + 10;
                        movimientos = nuevomov;
                        
                        // Generar posiciones iniciales nuevas
                        buenapos = false;
                        while (!buenapos)
                        {
                            buenapos = false;
                            xt = generador.nextInt(anchop) + 1;
                            yt = generador.nextInt(altop - 5) + 4;
                            xj = anchop / 2;
                            yj = altop / 2 + 3;
                            if ((Math.abs(xj - xt) > 2) || (Math.abs(yj - yt) > 2)) buenapos = true;
                        }
                    }
                    
                    // Cálculo de pista
                    calcpista = (int) Math.sqrt(Math.pow((xj - xt), 2) + Math.pow((yj - yt), 2));
                    if (calcpista < 5) pista = "QUEMANDO";
                    if (calcpista >= 5) pista = "CALIENTE";
                    if (calcpista >= 15) pista = "FRIO";
                    if (calcpista >= 35) pista = "MUY FRIO";

                    // Imprimimos cabecera
                    imprimeMarcador(capat, nivel, puntos,movimientos, pista);
                    
                    // Imprimimos personaje
                    capat.print(yj,xj,String.valueOf(personaje));                    
                    
                    // cheat
                    if (cheat) capat.print(yt,xt,"X");
                    
                    // Entrada de movimiento
                    entrada = tecl.leerCaracter();// encontrado = true; salir = true;
                    switch (entrada)
                    {
                        // Arriba
                        case 'w':
                        case 'W':
                            if (yj > 3) 
                            {
                                yj = yj - 1;
                                movimientos = movimientos - 1;
                            }
                            else yj = 3;                            
                            break;
                            
                        // Abajo
                        case 's':
                        case 'S':
                            if (yj < (altop - 2))
                            {
                                yj = yj + 1;
                                movimientos = movimientos - 1;
                            }
                            else yj = altop - 2;
                            break;
                            
                        // Izquieda
                        case 'a':
                        case 'A':
                            if (xj > 0) 
                            {
                                xj = xj - 1;
                                movimientos = movimientos - 1;
                            }
                            else xj = 0;
                            break;
                            
                        // Derecha
                        case 'd':
                        case 'D':
                            if (xj < (anchop - 1)) 
                            {
                                xj = xj + 1;
                                movimientos = movimientos - 1;
                            }
                            else xj = anchop-1;
                            break;
                            
                        // Salir
                        case 'p':
                        case 'P':
                            finjuego = true;
                            break;
                    }
                    
                    // Comprobamos si se ha encontrado el tesoro
                    if ((xj == xt) & (yj == yt))
                    {
                        gana = true;
                        
                        // Imprimimos el tesoro y el texto de victoria
                        capat.cls();
                        capat.print(yt, xt, "$");
                        capat.print(altop / 2, (anchop / 2) - (textogana.length() / 2), textogana);
                        capat.print(altop / 2 + 2, (anchop / 2) - ((puntuacion.length() + Integer.toString(puntos + movimientos + (5 * nivel)).length()) / 2),
                                    puntuacion + "" + (puntos + movimientos + (5 * nivel)));

                        // Hacemos una breve pausa y continuamos si se pulsa cualquier tecla
                        try
                        {
                        Thread.sleep(1000);
                        } catch (Exception e)
                        {
                            capat.println("Error. " + e);
                        }
                        tecl.leerCaracter();
                    }
                    
                    // Comprobamos si se han acabado los movimientos y no se ha encontrado el tesoro
                    if ((movimientos == 0) && (!gana))
                    {
                        capat.print(altop / 2, (anchop / 2) - (fin.length() / 2), fin);
                        imprimeMarcador(capat, nivel, puntos, movimientos, pista);
                        finjuego = true;
                        capat.print(yt, xt, "$");

                        // Hacemos una breve pausa y continuamos si se pulsa cualquier tecla
                        try
                        {
                        Thread.sleep(1000);
                        } catch (Exception e)
                        {
                            capat.println("Error. " + e);
                        }
                        tecl.leerCaracter();
                    }                                        
                } while (!finjuego);
            }
        } while (!salir);
    }
    
}
