public class Circulo extends Figura{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public void calcularArea(){
        total=Math.PI*radio*radio;
    }
}
