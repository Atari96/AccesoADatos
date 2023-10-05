public class PuntoTest {
    public static void main(String[] args) {
        Punto punto1=new Punto(0, 0);
        Punto punto2=new Punto(0, 1);
        Punto3D punto3=new Punto3D(0, 0, 0);
        Punto3D punto4=new Punto3D(1, 0, 0);
        System.out.println("Punto 1: "+punto1);
        System.out.println("Punto 2: "+punto2);
        System.out.println("Punto 3: "+punto3);
        System.out.println("Punto 4: "+punto4);
        System.out.println("Distancia: "+Punto.distancia(punto1, punto2));
        System.out.println("Distancia: "+Punto3D.distancia(punto3, punto4));
    }

    
}
