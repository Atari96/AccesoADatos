public class CuentaJunior extends Cuenta{
    private String detalle="Cuent Junior";

    public CuentaJunior(String dni, String nombre, String numCuenta, Double saldo) {
        super(dni, nombre, numCuenta, saldo);
    }
    @Override
    public String toString() {
        return super.toString()+" "+detalle;
    }
    
}
