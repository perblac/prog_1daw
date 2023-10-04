package libro;

/**
 *
 * @author rperblac
 */
import java.util.Scanner;

public class MenuLibro {

    public static void main(String args[]) {
        Libro libro1 = new Libro("9788499890944", "1984", "George Orwell", 352);
        Libro libro2 = new Libro("9788499890951", "Rebelión en la Granja", "George Orwell", 144);
        Libro libro3 = new Libro("9788497594257", "Un Mundo Feliz", "Aldous Huxley", 256);
        Libro libro4 = new Libro();
        Libro coleccion[] = {libro1, libro2, libro3, libro4};
        int tamaño = coleccion.length;
        int entrada = 0;
        boolean opcioncorrecta = false;
        boolean terminar = false;
        do{
            do
            {
                System.out.println("\n0:Mostrar todos\n1-4:Mostrar libro\n5:Terminar");
                try
                {
                    entrada = new Scanner(System.in).nextInt();
                    if (entrada<0||entrada>5)
                    {
                        System.out.println("Introduzca un valor entre 0 y 5");
                    } else
                    {
                        opcioncorrecta= true;
                    }
                } catch (Exception error)
                {
                    System.out.println("Introduzca un valor numérico");
                    opcioncorrecta = false;
                }
            } while (!opcioncorrecta);


            switch (entrada)
            {
                case 0:
                    for (int i=0;i<tamaño;++i)
                    {
                        coleccion[i].mostrarlibro();
                    }
                break;
                case 5:
                    terminar = true;
                break;
                default:
                    coleccion[entrada-1].mostrarlibro();
                break;
            }
        } while (!terminar);
    }
}
