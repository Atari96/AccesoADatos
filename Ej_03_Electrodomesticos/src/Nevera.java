public class Nevera extends Electrodomestico{
    private int capacidadFrigorifico;
    private int capacidadCongelador;
    private int sonoridad;
    public Nevera(String marca, String modelo, double precio, String color, int potencia, int horas, int dias,
            double precioEnergia, int capacidadFrigorifico, int capacidadCongelador, int sonoridad) {
        super(marca, modelo, precio, color, potencia, horas, dias, precioEnergia);
        this.capacidadFrigorifico = capacidadFrigorifico;
        this.capacidadCongelador = capacidadCongelador;
        this.sonoridad = sonoridad;
    }
    public int getCapacidadFrigorifico() {
        return capacidadFrigorifico;
    }
    public void setCapacidadFrigorifico(int capacidadFrigorifico) {
        this.capacidadFrigorifico = capacidadFrigorifico;
    }
    public int getCapacidadCongelador() {
        return capacidadCongelador;
    }
    public void setCapacidadCongelador(int capacidadCongelador) {
        this.capacidadCongelador = capacidadCongelador;
    }
    public int getSonoridad() {
        return sonoridad;
    }
    public void setSonoridad(int sonoridad) {
        this.sonoridad = sonoridad;
    }
    @Override
    public String toString() {
        return super.toString()+" Nevera [capacidadFrigorifico=" + capacidadFrigorifico + ", capacidadCongelador=" + capacidadCongelador
                + ", sonoridad=" + sonoridad + "]";
    }

    
}
