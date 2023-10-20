public class Ordenador {
    private int codigo;
    private int ram;
    private String cpu;
    private double precio;

    public Ordenador(int codigo, int ram, String cpu, double precio) {
        this.codigo = codigo;
        this.ram = ram;
        this.cpu = cpu;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCaracteristica(){
        return "Caracteristicas: Codigo= " + codigo + ", ram= " + ram + ", cpu= " + cpu + ", precio= " + precio;
    }

    @Override
    public String toString() {
        return "Ordenador [codigo=" + codigo + ", ram=" + ram + ", cpu=" + cpu + ", precio=" + precio + "]";
    }

}
