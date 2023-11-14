package actividad4;

public class Cliente implements Comparable<Cliente>{
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private double saldo;

    public Cliente(String nombre, String dni, String fechaNacimiento, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return nombre + ", "+ dni + ", fecha Nacimiento:" + fechaNacimiento + ", saldo: "
                + saldo ;
    }

    @Override
    public int compareTo(Cliente c) {
        return (int) (c.getSaldo()-this.saldo);
    }

    
    
}
