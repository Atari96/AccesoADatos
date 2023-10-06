public class ImpresoraTest {
    public static void main(String[] args) {
        ImpresoraLaser laser1=new ImpresoraLaser(55);
        laser1.imprimir("Texto desde impresora laser");
        ImpresoraTinta tinta1=new ImpresoraTinta(20);
        laser1.imprimir("Texto con tinta");

        System.out.println("¿Es laser más rápida que tinta? "+laser1.esMasRapida(tinta1));
    
    }
}
