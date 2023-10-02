import java.util.Scanner;

public class CuentaTest {
    public static boolean validarCuenta(Cuenta cuenta1){
        boolean resultado= false;
        String letras = cuenta1.getNumCuenta().substring(0, 2);
        String ccc1 = cuenta1.getNumCuenta().substring(4, 8);
        String ccc2 = cuenta1.getNumCuenta().substring(8, 12);
        String ccc3 = cuenta1.getNumCuenta().substring(14, 19);
        String ccc4 = cuenta1.getNumCuenta().substring(19, 24);
        String dc1=cuenta1.getNumCuenta().substring(12, 13);
        String dc2=cuenta1.getNumCuenta().substring(13, 14);
        int sumaA=0;
        int sumaB=0;
        int sumaD=0; 
        try {
            int digitoControl1=Integer.parseInt(dc1);
            int digitoControl2=Integer.parseInt(dc2);
            int num1 =Integer.parseInt(ccc1); // Primeros 4 numeros de la CCC
            sumaA=num1%10*10;
            num1= num1/10;
            sumaA=sumaA+num1%10*5;
            num1= num1/10;
            sumaA=sumaA+num1%10*8;
            num1=num1/10;
            sumaA=sumaA+num1%10*4;
            int num2 =Integer.parseInt(ccc2); // Segundos 4 numeros de la CCC
            sumaB=num2%10*6;
            num2= num2/10;
            sumaB=sumaB+num2%10*3;
            num2= num2/10;
            sumaB=sumaB+num2%10*7;
            num2=num2/10;
            sumaB=sumaB+num2%10*9;
            int num3 =Integer.parseInt(ccc3); //Penultima serie de 5 numeros CCC
            sumaD=num3%10*5;
            num3= num3/10;
            sumaD=sumaD+num3%10*8;
            num3= num3/10;
            sumaD=sumaD+num3%10*4;
            num3= num3/10;
            sumaD=sumaD+num3%10*2;
            num3=num3/10;
            sumaD=sumaD+num3%10*1;
            int num4 =Integer.parseInt(ccc4); // Ultimos 5 numeros de la CCC
            sumaD=sumaD+num4%10*6;
            num4= num4/10;
            sumaD=sumaD+num4%10*3;
            num4= num4/10;
            sumaD=sumaD+num4%10*7;
            num4= num4/10;
            sumaD=sumaD+num4%10*9;
            num4=num4/10;
            sumaD=sumaD+num4%10*10;
            int sumaAB=sumaA+sumaB;
            int digito1 = 11 - (sumaAB % 11);
            if (digito1 == 10) {
                digito1 = 1;
            } else if (digito1 == 11) {
                digito1 = 0;
            }      
            int digito2 = 11 - (sumaD % 11);
            if (digito2 == 10) {
                digito2 = 1;
            } else if (digito2 == 11) {
                digito2 = 0;
            }
            if (cuenta1.getNumCuenta().length()==24 && letras.equalsIgnoreCase("ES")){
                if (digito1 == digitoControl1 && digito2 == digitoControl2) {
                    resultado = true;
                }
        }   
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errrorrr");
        } 
        return resultado;
    }
    public static void transferencia(Cuenta origen, Cuenta destino, double cantidad) {
        double retiro=origen.getImporteRetiro();
        double saldo=origen.getSaldo();
        double ingreso=destino.getImporteIngreso();
        
        if (retiro+cantidad<origen.getImporteMaxRetiro() && saldo-cantidad>0 && ingreso+cantidad<destino.getImporteMaxIngreso()){
            System.out.println(origen.sacarDinero(cantidad));
            System.out.println(destino.ingresarDinero(cantidad));
        }
        else if(ingreso+cantidad>destino.getImporteMaxIngreso()){
            System.out.println(destino.ingresarDinero(cantidad));
        }
        else if (retiro+cantidad<origen.getImporteMaxRetiro()){
            System.out.println(origen.sacarDinero(cantidad));
        }
        else {
            try {
                throw new NumeroNegativoException();
            } catch (NumeroNegativoException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args) throws Exception {

        Cuenta cuenta1=new Cuenta("00001A","Pablo", "ES8701282851526173526918", 30000.0);
        Cuenta cuenta2=new Cuenta("00002A","Pepe", "ES1212345678999876543210", 1000.0);       

        System.out.println("Validacion "+validarCuenta(cuenta1));
        System.out.println("Validacion "+validarCuenta(cuenta2));
        
        /*System.out.println("Ingreso 100 cuenta 1 "+cuenta1.ingresarDinero(100));
        System.out.println("Ingreso 100 cuenta 2 "+cuenta2.ingresarDinero(100));
        System.out.println("Retiro 100 cuenta 1 "+cuenta1.sacarDinero(100));
        System.out.println("Retiro 100 cuenta 2 "+cuenta2.sacarDinero(100));
        System.out.println("Retiro 2000 cuenta 1 "+cuenta1.sacarDinero(2000));
        System.out.println("Retiro 2000 cuenta 2 "+cuenta2.sacarDinero(2000));
        System.out.println("Retiro 100 cuenta 1 "+cuenta1.sacarDinero(1900)+" "+cuenta1.mostrarSaldo());
        System.out.println("Retiro 100 cuenta 2 "+cuenta2.sacarDinero(1900)+" "+cuenta2.mostrarSaldo());
        System.out.println("Ingreso 100 cuenta 2 "+cuenta2.ingresarDinero(7000)+" "+cuenta2.mostrarSaldo());
        System.out.println("Retiro 100 cuenta 1 "+cuenta1.sacarDinero(7000)+" "+cuenta1.mostrarSaldo());
        cuenta1.cambioTitular("pepepepepepepepepe");
        System.out.println(cuenta1);*/

        System.out.println("\n******************\n");
        System.out.println("NOTA: Puedes comentar las líneas superiores para que no afecten las limitaciones y probar con el menú de la app ");
        System.out.println("\n******************\n");

        String menu="BANCO MORATO, La app de su banco amigo :)\nElige la operacion que deseas realizar\n"+
                    "1.- Transferencia de cuenta 1 a cuenta 2\n"+
                    "2.- Transferencia de cuenta 2 a cuenta 1\n"+
                    "3.- Cambio titular cuenta 1\n"+
                    "4.- Cambio titular cuenta 2\n"+
                    "5.- Salir";
        
        int opcion=0;
        while (opcion !=5){
            System.out.println(menu);
            System.out.println("Elige una opción");
            Scanner sc = new Scanner(System.in);
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Introduce la cantidad");
                        double cantidad=sc.nextDouble();
                        transferencia(cuenta1, cuenta2, cantidad);
                        System.out.println(cuenta2.mostrarSaldo()); 
                        System.out.println(cuenta1.mostrarSaldo()); 
                        break;
                    case 2:
                        System.out.println("Introduce la cantidad");
                        cantidad=sc.nextDouble();
                        transferencia(cuenta2, cuenta1, cantidad);
                        System.out.println(cuenta2.mostrarSaldo()); 
                        System.out.println(cuenta1.mostrarSaldo()); 
                        break;
                    case 3:
                        System.out.println("Introduce el titular");
                        String nuevoTitular=sc.next();
                        cuenta1.cambioTitular(nuevoTitular);
                        break;
                    case 4:
                        System.out.println("Introduce el titular");
                        nuevoTitular=sc.next();
                        cuenta2.cambioTitular(nuevoTitular);
                        break;
                    case 5:
                        break;
                    default: 
                        System.out.println("Elige una opción correcta");
                        break;
                }
        }
    }
}
