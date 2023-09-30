public class CuentaHipoteca extends Cuenta{
    private String detalle="Hipoteca";

    public CuentaHipoteca(String dni, String nombre, String numCuenta, Double saldo) {
        super(dni, nombre, numCuenta, saldo);
        
    }
    @Override
    public String toString() {
        return super.toString()+" "+detalle;
    }
    
}
