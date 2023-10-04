package libro;

/** Declaración de clase Libro
 *
 * @author rperblac
 */
public class Libro {    
    private String isbn;
    private String titulo;
    private String autor;
    private int numPags;
 
    public Libro() 
    {
        
    }
    
    public Libro(String isbn, String titulo, String autor, int numPags)
    {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.numPags = numPags;
    }

// titulo
    public void setTitulo (String titulo)
    {
        this.titulo = titulo;
    }

    public String getTitulo ()
    {
        try
        {
            titulo.isEmpty();
        } catch (NullPointerException npe)
        {
            return "[Título no establecido]";
        }
        return titulo;
        
    }
    
// isbn
    public void setIsbn (String isbn)
    {
        this.isbn = isbn;
    }

    public String getIsbn ()
    {
        try
        {
            isbn.isEmpty();
        } catch (NullPointerException npe)
        {
            return "[ISBN no establecido]";
        }
        return isbn;
        
    }

// autor    
    public void setAutor (String autor)
    {
        this.autor = autor;
    }

    public String getAutor ()
    {
        try
        {
            autor.isEmpty();
        } catch (NullPointerException npe)
        {
            return "[Autor no establecido]";
        }
        return autor;
        
    }

// numPags    
    public void setNumPags (int numPags)
    {
        this.numPags = numPags;
    }

    public int getNumPags ()
    {
        /* Esto no hace falta porque un int no puede declararse como null (es un tipo de datos primitivo)
        String cadena = Integer.toString(numPags);
        if (cadena.equals(null))
        {
            return -1;
        } else
        {
            return numPags;        
        }
        */
        return numPags;
    }
    
    public String toString ()
    {
        return "ISBN:" + isbn + " - " + titulo + ", de " + autor + ". Tiene " + numPags + " páginas.";
    }
    
    public void mostrarlibro()
    {
        /*
        System.out.println("ISBN: "+ this.getIsbn());
        System.out.println("Título: "+ this.getTitulo());
        System.out.println("Autor: "+ this.getAutor());
        System.out.println("Nº páginas: "+ this.getNumPags());
        */
        /*
        System.out.println("ISBN: "+ getIsbn());
        System.out.println("Título: "+ getTitulo());
        System.out.println("Autor: "+ getAutor());
        System.out.println("Nº páginas: "+ getNumPags());
        */
        System.out.println("----------------");
        System.out.println("ISBN: "+ isbn);
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Nº páginas: "+ numPags);
    }
}  