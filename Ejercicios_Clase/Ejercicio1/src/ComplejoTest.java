public class ComplejoTest {
    public static void main(String[] args) throws Exception {
        Complejo c1=new Complejo();
        Complejo c2=new Complejo();
        c1.asignar(5.0, 6);
        c2.asignar(7, 8);
        Complejo suma = Complejo.sumar(c1, c2);
        System.out.println(c1);
        System.out.println(c2);
        suma.imprimir();

    }
}
