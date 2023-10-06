public class ImpresoraLaser implements Impresora{

    private double velocidad;

    public ImpresoraLaser(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String imprimir(String texto) {
        return texto; 
    }

    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "ImpresoraLaser [velocidad=" + velocidad + "]";
    }

    
    
}
