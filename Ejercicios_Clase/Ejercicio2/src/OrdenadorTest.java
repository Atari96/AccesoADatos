import java.util.ArrayList;
import java.util.List;

public class OrdenadorTest {
    public static void main(String[] args) throws Exception {
        Ordenador ordenador1=new Ordenador(1, 16, "i3", 1000);
        Ordenador ordenador2=new Ordenador(2, 16, "i5", 1000);
        Portatil portatil1=new Portatil(3, 32, "R5", 1500, 10);
        Portatil portatil2=new Portatil(4, 32, "R7", 1500,13);
        Sobremesa sobremesa1=new Sobremesa(5, 32, "i9", 1700, "Torre compacta");
        Sobremesa sobremesa2=new Sobremesa(6, 32, "i9", 1900, "Torre rgb");
    
        // Precio de todos los ordenadores, creamos lista y sumamos los precios del stock
        List<Ordenador> stock=new ArrayList<Ordenador>();
        stock.add(ordenador1);
        stock.add(ordenador2);
        stock.add((Ordenador) portatil1);
        stock.add((Ordenador) portatil2);
        stock.add((Ordenador) sobremesa1);
        stock.add((Ordenador) sobremesa2);

        double capitalOrdenadores=0;
        for (Ordenador pc : stock){
            capitalOrdenadores+=pc.getPrecio();
        }
        System.out.println("Precio de todos los equipos: "+capitalOrdenadores);
        System.out.println(ordenador1.getCaracteristica());
        System.out.println("Caracteristicas: "+sobremesa1.getCaracteristica());
        System.out.println("Caracteristicas :"+sobremesa1.getCaracteristicas());

        // Cual es el peso del portatil1?
        System.out.println("Peso portatil1= "+portatil1.getPeso()+" kg");

        // Cuanta RAM tiene el ordenador2?
        System.out.println("Ram del ordenador2= "+ordenador2.getRam()); 

        //Todos los ordenadores del inventario
        for (Ordenador pc : stock){
            System.out.println(pc);
        }
    }


}
