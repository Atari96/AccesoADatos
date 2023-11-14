package transportesPabloMorato.pojoPablo;

public class Empleado {

    private static int codigoId;
    private int id;
    private String nombre;
    private String dni;
    private String fechaNac;
    private String telefono;
    private double salario;

    public Empleado(String nombre, String dni, String fechaNac, String telefono, double salario) {
        this.id = codigoId;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.salario = salario;
        codigoId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", " + nombre + ", dni=" + dni + ", fechaNac=" + fechaNac + ", telefono="
                + telefono + ", salario=" + salario;
    }

    
    
    
}
