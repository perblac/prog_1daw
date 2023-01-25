
package e15t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author rperblac
 */
public class MarcadorBaloncesto {
    /**
     * Nombre del equipo local
     */
    private String nombreLocal;
    
    /**
     * Nombre del equipo visitante
     */
    private String nombreVisitante;
    
    /**
     * Puntos del equipo local
     */
    private int puntosLocal;
    
    /**
     * Puntos del equipo visitante
     */
    private int puntosVisitante;
    
    /**
     * Fecha en la que se juega el partido
     */
    private LocalDate fecha;
    
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, ambos tienen 0 puntos y se juega en la fecha actual
     * 
     * @param nL nombre del equipo local
     * @param nV nombre del equipo visitante
     */
    public MarcadorBaloncesto(String nL, String nV){
        this(nL, 0, nV, 0, LocalDate.now());        
    }
    
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, ambos tienen 0 puntos y se juega en la fecha recibida como parámetro
     * 
     * @param nL nombre del equipo local
     * @param nV nombre del equipo visitante
     * @param f fecha del partido
     */
    public MarcadorBaloncesto(String nL, String nV, LocalDate f){
        this(nL, 0, nV, 0, f);
    }
    
    /**
     * Crea un marcador que recibe los nombres del equipo local y visitante, tienen los puntos que se reciben como parámetros y se juega en la fecha recibida como parámetro
     * 
     * @param nL nombre del equipo local
     * @param pL puntos del equipo local
     * @param nV nombre del equipo visitante
     * @param pV puntos del equipo visitante
     * @param f fecha del partido (LocalDate)
     */
    private MarcadorBaloncesto(String nL, int pL, String nV, int pV, LocalDate fecha){
        this.nombreLocal = nL;
        this.puntosLocal = pL;
        this.nombreVisitante = nV;
        this.puntosVisitante = pV;
        this.fecha = fecha;
    }
    
    /**
     * Si recibe una L, añade los puntos indicados al local. Si recibe una V, los añade al visitante. Solo se añadirán los puntos que sean 1,2 o 3.
     * @param equipo equipo al que añadir los puntos: local ('L') o visitante ('V')
     * @param puntos puntos a añadir (1, 2 o 3)
     */
    public void añadirCanasta(char equipo, int puntos) {
        int maspuntos = ((puntos>0)&(puntos<4))?puntos:0;
        switch(equipo){
            case 'L':
                this.puntosLocal += maspuntos;
                break;
            case 'V':
                this.puntosVisitante += maspuntos;
                break;
        }        
    }
    
    /**
     * Hace que el marcador se vuelva a poner a 0.
     */
    public void reset() {
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
    }
    
    /**
     * Devuelve el nombre del equipo local.
     * @return nombre del equipo local
     */
    public String getNombreLocal() {
        return this.nombreLocal;
    }
    
    /**
     * Devuelve el nombre del equipo visitante.
     * @return nombre del equipo visitante
     */
    public String getNombreVisitante() {
        return this.nombreVisitante;
    }
    
    /**
     * Devuelve los puntos que lleva el equipo local
     * @return puntos del equipo local
     */
    public int getPuntosLocal() {
        return this.puntosLocal;
    }
    
    /**
     * Devuelve los puntos que lleva el equipo visitante
     * @return puntos del equipo visitante
     */
    public int getPuntosVisitante() {
        return this.puntosVisitante;
    }
    
    /**
     * Devuelve la fecha del partido.
     * @return fecha del partido
     */
    public LocalDate getFecha() {
        return this.fecha;
    }
    
    /**
     * Devuelve true si está ganando el equipo local.
     * @return si está ganando el equipo local
     */
    public boolean ganaLocal() {
        return this.puntosLocal > this.puntosVisitante;
    }
    
    /**
     * Devuelve true si está ganando el equipo visitante.
     * @return si está ganando el equipo visitante
     */
    public boolean ganaVisitante() {
        return this.puntosVisitante > this.puntosLocal;
    }
    
    /**
     * Devuelve true si ambos equipos tienen los mismos puntos.
     * @return si los equipos están empatados
     */
    public boolean hayEmpate() {
        return this.puntosLocal == this.puntosVisitante;
    }
    
    private String datos() {
        return this.getNombreLocal() + " " + this.getPuntosLocal() + " " + this.getNombreVisitante() + " " + this.getPuntosVisitante() + "\n";
    }
    
    /**
     * Escribe en el archivo de texto cuya ruta se pasa como parámetro el nombre del equipo local, sus puntos, el nombre del equipo visitante y sus puntos.
     * @param ruta el archivo donde se escribiran los datos y su ruta
     * @throws IOException 
     */
    public void guardar(String ruta) throws IOException {
        File archivo = new File(ruta);
        if (!archivo.exists()) archivo.createNewFile();
        if (!archivo.isFile()) new IOException("No es un archivo");
        if (!archivo.canWrite()) new IOException("No hay permisos para escribir");        
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.datos());
        bw.close();
        fw.close();        
    }
    
    public String cargar(String ruta) throws IOException {
        File archivo = new File(ruta);
        if (!archivo.exists()) new IOException("No se encontró el archivo");        
        if (!archivo.isFile()) new IOException("No es un archivo");
        if (!archivo.canWrite()) new IOException("No hay permisos para escribir");   
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        br.close();
        fr.close();
        return linea;
    }
}
