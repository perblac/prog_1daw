
package e27t4;

/**
 * Un equipo de música que tiene varios altavoces
 * @author rperblac
 */
public class EquipoMusica {
    /**
     * Un array en el que se guardan los altavoces del equipo.
     */
    private Altavoz[] altavoces;
    
    /**
     * Crea un equipo de musica. Inicializa la propiedad “altavoces”, creando un array con la cantidad de altavoces pasada como parámetro, y rellenándola con objetos altavoz.
     * @param numeroAltavoces número de altavoces del equipo
     */
    public EquipoMusica(int numeroAltavoces) {
        // Inicializa array de altavoces al tamaño dado
        this.altavoces = new Altavoz[Math.abs(numeroAltavoces)];
        
        // Crea cada uno de los altavoces
        for (int i = 0;i < this.altavoces.length; i++)
        {
            this.altavoces[i] = new Altavoz();
        }        
    }
    
    /**
     * Devuelve el altavoz que se encuentra en la posicion indicada, dentro del array de altavoces.
     * @param posicion posicion del altavoz a devolver en el array
     * @return altavoz de la posicion indicada
     */
    public Altavoz getAltavoz(int posicion) {
        Altavoz r;
        if (this.altavoces.length!=0)
            r = (posicion<0|posicion>this.altavoces.length)?null:this.altavoces[posicion];
        else
            r = null;
        return r;
    }
    
    /**
     * Cambia el volumen del altavoz cuya posición se pasa como parámetro.
     * @param numeroAltavoz posicion en el array del altavoz cuyo volumen se cambiará
     * @param volumen nuevo volumen
     */
    public void setVolumen(int numeroAltavoz, int volumen) {
        this.altavoces[numeroAltavoz].setVolumen(volumen);
    }


}
