public class Televisor extends Electrodomestico{
    private int resolucion;
    public Televisor(String marca) {
        super();
        
    }
    public Televisor(String marca, String modelo, double precio, String color, int potencia, int horas, int dias,
            double precioEnergia, int resolucion) {
        super(marca, modelo, precio, color, potencia, horas, dias, precioEnergia);
        this.resolucion = resolucion;
    }
    public double consumoAnual(){
        double consumo=super.consumoAnual();
        if (resolucion>50){
            consumo=consumo+30;
        }
        return consumo;
    }
    public int getResolucion() {
        return resolucion;
    }
    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }
    @Override
    public String toString() {
        return "Televisor: "+super.toString()+" resolucion: " + resolucion;
    }
}
