package actividad3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TemperaturaTest {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Temperatura> registro = new ArrayList<Temperatura>();

        String rutaDirectorio="D:\\FP\\SEGUNDO\\3_AccesoDatos\\EjerciciosJava\\EjerciciosClase\\paqueteEjercicios\\src\\actividad3";
        String nombreFichero="meteo.txt";
        String cabeceraFichero="CIUDAD       FECHA        Tmax  Tmin";
        File fichero= new File(rutaDirectorio, nombreFichero);
        FileWriter fw;
        try {
            fw = new FileWriter(fichero, true);
            fw.write(cabeceraFichero);
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String menu="=============================================\n"+
                    "=========  REGISTRO DE TEMPERATURAS  ========\n"+
                    "=============================================\n"+
                    "1.- Registrar nueva temperatura\n"+
                    "2.- Mostrar historial de registros por ciudad\n"+
                    "3.- Mostrar media de temperatura por ciudad\n"+
                    "4.- Salir\n";

        int opcion=0;
        while (opcion !=4){
            System.out.println(menu);
            System.out.println("Introduce una opción");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Introduce la ciudad");
                    String ciudad = sc.nextLine();
                    System.out.println("Introduce la fecha");
                    String fecha=sc.next();
                    System.out.println("Introduce la temperatura máxima");
                    int temperaturaMaxima=sc.nextInt();
                    System.out.println("Introduce la temperatura mínima");
                    int temperaturaMinima=sc.nextInt();
                    Temperatura temperatura=new Temperatura(temperaturaMaxima, temperaturaMinima, ciudad, fecha);
                    registro.add(temperatura);
                    try {
                        fw= new FileWriter(fichero, true);
                        fw.write(temperatura.toString());
                        fw.write("\n");
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la ciudad");
                    ciudad=sc.nextLine();
                    for (Temperatura temp : registro) {
                        if (temp.getCiudad().equals(ciudad)){
                            System.out.println(temp);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el nombre de la ciudad");
                    ciudad=sc.nextLine();
                    double mediaTempMaxima=0;
                    double mediaTempMinima=0;
                    int registros=0;
                    for (Temperatura temp : registro) {
                        if (temp.getCiudad().equals(ciudad)){
                            registros++;
                            mediaTempMaxima += temp.getTemperaturaMaxima();
                            mediaTempMinima += temp.getTemperaturaMinima();
                        }
                    }
                    System.out.println("Temperatura máxima media: "+mediaTempMaxima/registros);
                    System.out.println("Temperatura mínima minima: "+mediaTempMinima/registros);
                    System.out.println("Temperatura media max-min: "+(mediaTempMaxima/registros+mediaTempMinima/registros)/2);
                    break;
                case 4:
                    System.out.println("Fin de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    sc.close();        
    }
}
