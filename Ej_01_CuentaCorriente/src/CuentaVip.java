public class CuentaVip extends Cuenta{
    
    private String detalle="Cuenta VIP";

    public CuentaVip(String dni, String nombre, String numCuenta, Double saldo) {
        super(dni, nombre, numCuenta, saldo);
        
    }
    @Override
    public String toString() {
        return super.toString()+" "+detalle;
    }
}
