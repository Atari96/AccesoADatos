public class Rectangulo extends Figura{
    private double ladoA;
    private double ladoB;

    public Rectangulo(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public void calcularArea(){
        total=ladoA*ladoB;
    }
}
