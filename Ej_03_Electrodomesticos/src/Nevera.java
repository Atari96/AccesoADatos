public class Nevera extends Electrodomestico{
    private int capacidadFrigorifico;
    private int capacidadCongelador;
    private int sonoridad;
    public Nevera() {
        this.capacidadFrigorifico = 100;
        this.capacidadCongelador = 50;
    }
    public Nevera(String marca, String modelo, double precio, String color, int potencia, int horas, int dias,
            double precioEnergia, int capacidadFrigorifico, int capacidadCongelador, int sonoridad) {
        super(marca, modelo, precio, color, potencia, horas, dias, precioEnergia);
        this.capacidadFrigorifico = capacidadFrigorifico;
        this.capacidadCongelador = capacidadCongelador;
        this.sonoridad = sonoridad;
    }
    public double consumoAnual(){
        double consumo=super.consumoAnual();
        if (capacidadFrigorifico>300 || capacidadCongelador>200){
            consumo=consumo+50;
        }
        return consumo;
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
        return "Nevera: "+super.toString()+" Frigo: " + capacidadFrigorifico + "L, Cong=" + capacidadCongelador
                + "L, " + sonoridad +"db";
    }
}
