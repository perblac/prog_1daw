package libro;

/**
 *
 * @author rperblac
 */

import java.util.Scanner;

public class PruebaLibro {

    public static void main(String args[]) {
        Libro libro1 = new Libro();
        Libro libro2 = new Libro("123","El Quijote","Miguel de Cervantes", 500);
        Libro libro3 = new Libro();
        System.out.println("Título de libro 2 es " + libro2.getTitulo() + " pags: "+libro1.getNumPags());
        System.out.println("Título de libro 1 es " + libro1.getNumPags());
        System.out.println("Introduzca nuevo título para libro1: ");
        String nuevotitulo = new Scanner(System.in).nextLine();
        libro1.setTitulo(nuevotitulo);
        System.out.println("Título de libro 1 es " + libro1.getTitulo());
        System.out.print("Libro 3\nISBN? ");
        String isbn = new Scanner(System.in).next();
        System.out.print("Título? ");
        String titulo = new Scanner(System.in).nextLine();
        System.out.print("Autor? ");
        String autor = new Scanner(System.in).nextLine();
        System.out.print("Nº páginas? ");
        int paginas = new Scanner(System.in).nextInt();
        libro3.setIsbn(isbn);
        libro3.setAutor(autor);
        libro3.setTitulo(titulo);
        libro3.setNumPags(paginas);
        System.out.println(libro3);
        System.out.println("fin de programa de clase libro");
    }
}
