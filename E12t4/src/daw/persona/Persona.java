
package daw.persona;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa una Persona, que tiene un DNI
 *
 * @author rperblac
 */
public class Persona {
    /**
     * Nombre de la persona
     */
    private String nombre;
    
    /**
     * DNI de la persona
     */
    private DNI dni;
    
    /**
     * Sueldo
     */
    private double sueldo;
    
    /**
     * Fecha de nacimiento
     */
    private LocalDate fechaNacimiento;
    
    /**
     * Cuenta corriente
     */
    private CuentaCorriente cuenta;
    
    /**
     * Crea una persona a partir de su nombre, DNI, sueldo y fecha de nacimiento pasadas como parámetros.
     * @param n nombre
     * @param d DNI
     * @param s sueldo
     * @param fn fecha de nacimiento
     */
    public Persona(String n, DNI d, double s, LocalDate fn){
        nombre = n;
        dni = d;
        sueldo = s;
        fechaNacimiento = fn;
        cuenta = new CuentaCorriente();
    }
    
    /**
     * Crea una persona a partir de su nombre, número, letra de DNI, sueldo y fecha de nacimiento pasada como parámetro.
     * @param n nombre
     * @param numDNI número del DNI
     * @param letraDNI letra del DNI
     * @param s sueldo 
     * @param fn fecha de nacimiento
     */
    public Persona(String n, int numDNI, char letraDNI, double s, LocalDate fn){
        nombre = n;
        dni = new DNI(numDNI, letraDNI);
        sueldo = s;
        fechaNacimiento = fn;
        cuenta = new CuentaCorriente();
    }
    
    /**
     * Crea una persona cuyo nombre y DNI se pasan como parámetro, gana 900 euros y ha nacido hace 20 años.
     * @param n nombre
     * @param d DNI
     */
    public Persona(String n, DNI d){
        nombre = n;
        dni = d;
        sueldo = 900;
        fechaNacimiento = LocalDate.now().minusYears(20);
        cuenta = new CuentaCorriente();
    }
    
    /**
     * Crea una persona cuyo nombre, número y letra de DNI se pasan como parámetro, gana 900 euros y ha nacido hace 20 años.
     * @param n nombre
     * @param numDNI número del DNI
     * @param letraDNI letra del DNI
     */
    public Persona(String n, int numDNI, char letraDNI){
        nombre = n;
        dni = new DNI(numDNI, letraDNI);
        sueldo = 900;
        fechaNacimiento = LocalDate.now().minusYears(20);
        cuenta = new CuentaCorriente();
    }
    
    /**
     * Aumenta el sueldo del empleado el porcentaje indicado como parámetro. Por ejemplo, si el sueldo es 1000 y se llama al método pasando un 50, el sueldo final del empleado será 1500.
     * @param porcentaje el porcentaje del sueldo que se añadirá como aumento
     */
    public void aumentarSueldo(int porcentaje) {
        this.sueldo += (sueldo * Math.abs(porcentaje)) / 100;
    }
    
    /**
     * Añade al empleado su sueldo en su cuenta corriente.
     */
    public void cobrarSueldo() {
        this.cuenta.añadirDinero((int) Math.round(this.sueldo));
    }
    
    /**
     * Devuelve el valor nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve el dni de la persona
     * @return dni de la persona
     */
    public DNI getDNI() {
        return dni;
    }
    
    /**
     * Devuelve el valor sueldo de la persona
     * @return sueldo de la persona
     */
    public double getSueldo() {
        return sueldo;
    }
    
    /**
     * Devuelve la fecha de nacimiento de la persona
     * @return fecha de nacimiento de la persona
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Devuelve la cuenta corriente de la persona
     * @return cuenta corriente de la persona
     */
    public CuentaCorriente getCuentaCorriente() {
        return cuenta;
    }
    
    /**
     * Devuelve true si la persona es mayor de 18 años.
     * @return mayoría de edad de la persona
     */
    public boolean esMayorEdad() {        
        return (ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()) >= 18);
    }
    
    /**
     * Devuelve true si la cuenta corriente del empleado tiene saldo positivo.
     * @return saldo positivo en la cuenta corriente
     */
    public boolean tieneDinero() {
        return this.cuenta.saldo > 0;
    }
    
    /**
     * Devuelve true si la persona gana menos de 1200 euros
     * @return sueldo menor de 1200 euros
     */
    public boolean esMileurista() {
        return this.sueldo < 1200;
    }
}
