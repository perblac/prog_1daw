
package daw.persona;

/**
 * Representa una cuenta corriente
 *
 * @author rperblac
 */
public class CuentaCorriente {
    /**
     * Número de cuenta
     */
    public int número;
    
    /**
     * Saldo de la cuenta
     */
    public int saldo;
    
    /**
     * Crea una cuenta con número aleatorio entre 0 y 1000, y saldo 0.
     */
    public CuentaCorriente() {
        número = (int) Math.random()*1000;
        saldo = 0;
    }
    
    /**
     * Crea una cuenta corriente cuyo número de cuenta se pasa como parámetro y tiene saldo 0 euros.
     * @param número el número de la cuenta corriente
     */
    public CuentaCorriente(int número) {
        this.número = número;
        saldo = 0;
    }
    
    /**
     * Crea una cuenta corriente cuyo número de cuenta se pasa como parámetro y tiene el saldo indicado como parámetro.
     * @param número el número de la cuenta corriente
     * @param saldo el saldo que tiene la cuenta
     */
    public CuentaCorriente(int número, int saldo) {
        this.número = número;
        this.saldo = saldo;
    }
    
    /**
     * Añade al saldo la cantidad indicada.
     * @param cantidad la cantidad que se añade al saldo
     */
    public void añadirDinero(int cantidad) {
        saldo = saldo + Math.abs(cantidad);
    }
    
    /**
     * Retira del saldo la cantidad indicada.
     * @param cantidad la cantidad que se retira del saldo
     * @throws Exception 
     */
    public void retirarDinero(int cantidad) throws Exception {
        if (cantidad > this.saldo)
        {
            Exception e = new Exception("No hay saldo suficiente para retirar la cantidad");
            throw e;
        } else
        {
            this.saldo -= cantidad;                    
        }
    }

}
