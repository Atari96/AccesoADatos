public class Electrodomestico {
    private String marca;
    private String modelo;
    private double precio;
    private String color;
    private int potencia;
    private int horas;
    private int dias;
    private double precioEnergia;

    public Electrodomestico() {
        this.marca = "Bosch";
        this.modelo = "7200";
        this.precio = 400;
        this.color = "gris";
        this.potencia = 2300;
        this.horas = 1;
        this.dias = 3*52;
        this.precioEnergia = 0.40397;
    }

    public Electrodomestico(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = "gris";
        this.potencia = 2300;
        this.horas = 1;
        this.dias = 3*52;
        this.precioEnergia = 0.40397;
    }

    public Electrodomestico(String marca, String modelo, double precio, String color, int potencia, int horas, int dias,
            double precioEnergia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.potencia = potencia;
        this.horas = horas;
        this.dias = dias*52;
        this.precioEnergia = precioEnergia;
    }

    public double consumoAnual(Electrodomestico electrodomestico){
        double consumo=0;
        consumo=potencia*horas*dias/1000;
        return consumo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getPrecioEnergia() {
        return precioEnergia;
    }

    public void setPrecioEnergia(double precioEnergia) {
        this.precioEnergia = precioEnergia;
    }

    @Override
    public String toString() {
        return "Electrodomestico [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", color=" + color
                + ", potencia=" + potencia + ", horas=" + horas + ", dias=" + dias + ", precioEnergia=" + precioEnergia
                + "]";
    }
    
    

    
}
