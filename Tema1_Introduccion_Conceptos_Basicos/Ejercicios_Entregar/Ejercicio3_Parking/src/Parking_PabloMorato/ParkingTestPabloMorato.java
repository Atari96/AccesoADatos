package Parking_PabloMorato;

import java.util.Scanner;

public class ParkingTestPabloMorato {
    
    public static void main(String[] args) {
        VehiculoPabloMorato vehiculo1=new VehiculoPabloMorato("1234MCD");
        VehiculoPabloMorato vehiculo2=new VehiculoPabloMorato("1111MCD");
        VehiculoPabloMorato vehiculo3=new VehiculoPabloMorato("2222MCD");
        VehiculoPabloMorato vehiculo4=new VehiculoPabloMorato("3333MCD");
        VehiculoPabloMorato vehiculo5=new VehiculoPabloMorato("4444MCD");

        ParkingVehiculoPabloMorato parking1=new ParkingVehiculoPabloMorato("C/ Tolosa 2", 0);
    
        //System.out.println(parking1);
        parking1.aparcaCoche(vehiculo1);
        parking1.aparcaCoche(vehiculo2);
        parking1.aparcaCoche(vehiculo3);
        parking1.aparcaCoche(vehiculo4);
        parking1.aparcaCoche(vehiculo5);
        System.out.println(parking1);
        parking1.sacaCoche(vehiculo1);
        parking1.sacaCoche(vehiculo2);
        parking1.sacaCoche(vehiculo3);
        parking1.sacaCoche(vehiculo4);
        parking1.sacaCoche(vehiculo5);
        System.out.println(parking1);
       
        String menu= "1- Aparcar coche\n"+
                    "2- Sacar coche\n"+
                    "3- Listar coches en parking\n"+
                    "4- Finalizar";
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        String matricula="";
        VehiculoPabloMorato vehiculoPabloMorato=null;
        do {
            System.out.println(menu);
            System.out.println("Introduce una opción");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Introduce la matricula del vehiculo");
                    matricula=sc.next();
                    vehiculoPabloMorato=new VehiculoPabloMorato(matricula);
                    parking1.aparcaCoche(vehiculoPabloMorato);
                    break;
                case 2:
                    System.out.println("Introduce la matricula del vehiculo");
                    matricula=sc.next();
                    parking1.sacaCoche(parking1.seleccionarVehiculoPorMatricula(matricula));
                    break;
                case 3: 
                    System.out.println(parking1);
                    break;
                case 4:
                    return;
                default:
                    System.out.println(menu);
            }
        } while(opcion!=4);
    }
}

