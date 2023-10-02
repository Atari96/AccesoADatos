public class ElectrodomesticoTest {
    public static void main(String[] args) throws Exception {
        
        Electrodomestico[] stock = new Electrodomestico[6]; 
        Nevera nev1 = new Nevera("Liebher", "100L", 1100, "Blanco", 50, 24, 7, 0.40, 120, 50, 20);
        Nevera nev2 = new Nevera();
        Televisor tv1=new Televisor("Samsung");
        Televisor tv2= new Televisor("Philips", "55HDU", 777, "Negro", 200, 4, 7, 0.4, 55);
        Televisor tv3= new Televisor("Philips", "55HDU", 777, "Negro", 200, 4, 7, 0.4, 45);
        Electrodomestico electr1=new Electrodomestico();
        stock[0]= (Electrodomestico) nev1;
        stock[1]= (Electrodomestico) nev2;
        stock[2]= (Electrodomestico) tv1;
        stock[3]= (Electrodomestico) tv2;
        stock[4]= (Electrodomestico) tv3;
        stock[5]= electr1;

        for (int i=0; i<stock.length; i++){
            System.out.println(stock[i]+"\n"); 
        }
        double dinerito=0;
        for (Electrodomestico el : stock){
            
            System.out.println(el.getClass()+", consumo "+el.consumoAnual()+" euros");
            dinerito += el.consumoAnual(); 
        }
        System.out.println("Consumo total: "+dinerito+" euros");
    }
}
