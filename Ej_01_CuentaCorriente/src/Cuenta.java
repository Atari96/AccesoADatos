public class Cuenta {
    private String dni;
    private String nombre;
    private String numCuenta;
    private Double saldo;
    private Double importeMaxRetiro=10000.0;
    private Double importeMaxIngreso=6000.0;
    private static Double importeRetiro=0.0;
    private static Double importeIngreso=0.0;

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
    public Double getImporteMaxRetiro() {
        return importeMaxRetiro;
    }
    public void setImporteMaxRetiro(Double importeMaxRetiro) {
        this.importeMaxRetiro = importeMaxRetiro;
    }
    public Double getImporteMaxIngreso() {
        return importeMaxIngreso;
    }
    public void setImporteMaxIngreso(Double importeMaxIngreso) {
        this.importeMaxIngreso = importeMaxIngreso;
    }
    public static Double getImporteRetiro() {
        return importeRetiro;
    }
    public static void setImporteRetiro(Double importeRetiro) {
        Cuenta.importeRetiro = importeRetiro;
    }
    public static Double getImporteIngreso() {
        return importeIngreso;
    }
    public static void setImporteIngreso(Double importeIngreso) {
        Cuenta.importeIngreso = importeIngreso;
    }
    public String sacarDinero(double cantidad) {
        try {

            if (importeRetiro + cantidad > importeMaxRetiro) {
                throw new Exception("Se ha superado el importe máximo a retirar en un día.");
            }
            
            if (saldo - cantidad < 0) {
                throw new NumeroNegativoException();
            }
            
            saldo -= cantidad;
            importeRetiro += cantidad;
            
            return "Operación de retiro realizada con éxito";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } 
        /*try {

            if (importeRetiro + cantidad > importeMaxRetiro) {
                throw new Exception("Se ha superado el importe máximo a retirar en un día.");
            }
            
            if (saldo - cantidad < 0) {
                throw new NumeroNegativoException();
            }
            
            saldo -= cantidad;
            importeRetiro += cantidad;
            
            return "Operación de retiro realizada con éxito";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } */
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
            
            return "Operación de ingreso realizada con éxito.";
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
