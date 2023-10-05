public class Punto {
    
    private int coordenadaX;
    private int coordenadaY;
   
    public Punto(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public boolean equals(Punto p1, Punto p2){
        boolean iguales=false;
        if (p1.getCoordenadaX()==(p2.getCoordenadaX()) && p1.getCoordenadaY()==(p2.getCoordenadaY())){
            iguales=true;
        }
        return iguales;
    }

    public static double distancia(Punto p1, Punto p2){
        double distancia=0;
        int xP3=p1.getCoordenadaX()-p2.getCoordenadaX();
        int yP3=p1.getCoordenadaY()-p2.getCoordenadaY();
        distancia=Math.sqrt((xP3*xP3)+(yP3*yP3));
        return distancia;
    }

    @Override
    public String toString() {
        return "Punto: coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY ;
    }

}
