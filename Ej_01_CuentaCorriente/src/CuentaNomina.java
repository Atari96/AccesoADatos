public class CuentaNomina extends Cuenta{
    
    private String detalle="Cuenta nómina";

    public CuentaNomina(String dni, String nombre, String numCuenta, Double saldo) {
        super(dni, nombre, numCuenta, saldo);
    }

    @Override
    public String toString() {
        return super.toString()+" "+detalle;
    }

    
}
