public class ImpresoraTinta implements Impresora{

    private double velocidad;

    public ImpresoraTinta(double velocidad) {
        this.velocidad=velocidad;
    }

    @Override
    public String imprimir(String texto) {
        return texto; 
    }

    @Override
    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "ImpresoraTinta [velocidad=" + velocidad + "]";
    }
    
}