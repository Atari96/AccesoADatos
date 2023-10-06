import java.time.LocalDateTime;

public class PuntoTest {
    public static void main(String[] args) {
        Punto punto1=new Punto(0, 0);
        Punto punto2=new Punto(0, 1);
        Punto3D punto3=new Punto3D(0, 0, 0);
        Punto3D punto4=new Punto3D(1, 0, 0);
        Suceso suceso1=new Suceso(0, 0, 0, LocalDateTime.now(), "Puntito");
        Suceso suceso2=new Suceso(1, 1, 0, LocalDateTime.now(), "Puntito");
        System.out.println("Punto 1: "+punto1);
        System.out.println("Punto 2: "+punto2);
        System.out.println("Punto 3: "+punto3);
        System.out.println("Punto 4: "+punto4);
        System.out.println("Suceso1: "+suceso1);
        System.out.println("Suceso2: "+suceso2);
        System.out.println("Distancia: "+Punto.distancia(punto1, punto2));
        System.out.println("Distancia: "+Punto3D.distancia(punto3, punto4));
        System.out.println("Son iguales p1 y p2: " +Punto.equals(punto1, punto2));
        System.out.println("Son iguales p1 y p1: " +Punto.equals(punto1, punto1));
        System.out.println("Son iguales p3 y p4: " +Punto3D.equals(punto3, punto4));
        System.out.println("Son iguales p4 y p4: " +Punto3D.equals(punto4, punto4));
        System.out.println("Son iguales suceso1 y suceso2: " +Suceso.equals(suceso1, suceso2));
        System.out.println("Son iguales suceso1 y suceso1: " +Suceso.equals(suceso1, suceso1));
    }

    
}
