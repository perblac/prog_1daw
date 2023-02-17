
package loterias;

/**
 * Representa un sorteo
 * @author rperblac
 */
public class Sorteo {
    private double dineroCupon;
    private int pagosRealizados;
    private int pagosPendientes;
    private int totalParticipantes;
    private double dineroRecogido;
    
    public Sorteo(double dineroCupon, int totalPersonas) {
        this.setParticipantes(totalPersonas);
        this.setPrecioCupon(dineroCupon);
        this.pagosPendientes = totalPersonas;
        this.pagosRealizados = 0;
    }
    
    private void setParticipantes(int nuevoNumeroParticipantes) {        
        this.totalParticipantes = nuevoNumeroParticipantes;
    }
    
    private void setPrecioCupon(double precioCupon) {
        if (precioCupon < 0) precioCupon = 0;
        this.dineroCupon = precioCupon;
    }
    
    public double getPrecioCupon() {
        return this.dineroCupon;
    }
    
    public int getPagosRealizados() {
        return this.pagosRealizados;
    }
    
    public int getPagosPendientes() {
        return this.pagosPendientes;
    }
    
    public double getDineroRecogido() {
        return this.dineroRecogido;
    }
    
    public int getTotalParticipantes() {
        return this.totalParticipantes;
    }
    
    public void registrarPago() {
        this.pagosRealizados++;
        this.pagosPendientes--;
        this.dineroRecogido += this.dineroCupon;
    }
    
    public void apuntarNuevoParticipante() {
        this.totalParticipantes++;
        this.pagosPendientes++;
    }
}
