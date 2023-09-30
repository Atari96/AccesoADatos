public class Cuenta {
    String dni;
    String nombre;
    String numCuenta;
    Double saldo;
    Double importeMaxRetiro=3000.0;
    Double importeMaxIngreso=6000.0;
    Double importeRetiro=0.0;
    Double importeIngreso=0.0;

    public Cuenta(Double saldo, String numCuenta){
        this.saldo=saldo;
        this.numCuenta=numCuenta;
    }
    public Cuenta(String dni, String nombre, String numCuenta, Double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String sacarDinero(double cantidad){
        try {
            // Validar importe máximo a retirar en un mismo día
            if (importeRetiro + cantidad > importeMaxRetiro) {
                throw new Exception("Se ha superado el importe máximo a retirar en un día.");
            }
            
            // Validar descubiertos
            if (saldo - cantidad < 0) {
                throw new Exception("No tiene fondos suficientes para realizar esta operación.");
            }
            
            // Realizar la operación de retiro
            saldo -= cantidad;
            importeRetiro += cantidad;
            
            return "Operación de retiro realizada con éxito. Nuevo saldo: " + saldo;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } 
    }
        
    public String ingresarDinero(double cantidad) {
        try {
            // Validar importe máximo a ingresar en un mismo día
            if (importeIngreso + cantidad > importeMaxIngreso) {
                throw new Exception("Se ha superado el importe máximo a ingresar en un día.");
            }
            
            // Realizar la operación de ingreso
            saldo += cantidad;
            importeIngreso += cantidad;
            
            return "Operación de ingreso realizada con éxito. Nuevo saldo: " + saldo;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String mostrarSaldo(){
        return "Saldo: "+saldo;
    }

    public String cambioTitular(){
        return "Operación realizada con exito";
    }

    public void cambioTitular(String nombre2){
        setNombre(nombre2);
    }
    @Override
    public String toString() {
        return "Cuenta " + numCuenta + ", dni=" + dni + ", " + nombre + ", saldo=" + saldo
                + ", importeMaxRetiro=" + importeMaxRetiro + ", importeMaxIngreso=" + importeMaxIngreso ;
    }

    
}
