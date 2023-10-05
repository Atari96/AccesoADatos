public class Punto3D extends Punto{

    private int coordenadaZ;

    public Punto3D(int coordenadaX, int coordenadaY, int coordenadaZ) {
        super(coordenadaX, coordenadaY);
        this.coordenadaZ=coordenadaZ;
    }

    public int getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(int coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public static double distancia3D(Punto3D p1, Punto3D p2){
        double distancia=0;
        int xP3=p1.getCoordenadaX()-p2.getCoordenadaX();
        int yP3=p1.getCoordenadaY()-p2.getCoordenadaY();
        int zP3=p1.getCoordenadaZ()-p2.getCoordenadaZ();
        distancia=Math.cbrt((xP3*xP3)+(yP3*yP3)+(zP3*zP3));
        return distancia;
    }

    public boolean equals(Punto3D p1, Punto3D p2){
        boolean iguales=false;
        if (p1.getCoordenadaX()==p2.getCoordenadaX() && 
                p1.getCoordenadaY()==p2.getCoordenadaY() && 
                    p1.getCoordenadaZ()==p2.getCoordenadaZ()){
            iguales=true;
        }
        return iguales;
    }

    @Override
    public String toString() {
        return super.toString()+", coordenadaZ=" + coordenadaZ;
    }

}
