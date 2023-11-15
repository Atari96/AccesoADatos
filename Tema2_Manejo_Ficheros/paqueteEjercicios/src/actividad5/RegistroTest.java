package actividad5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Registro> registro = new ArrayList<>();

        String rutaDirectorio = "src/actividad5";
        String nombreFichero = "meteo.dat";
        String cabeceraFichero = "CIUDAD       FECHA        Tmax  Tmin";
        File fichero = new File(rutaDirectorio, nombreFichero);

        if (!fichero.getParentFile().exists()) {
            fichero.getParentFile().mkdirs();
        }

        FileWriter fw;
        try {
            fw = new FileWriter(fichero, true);
            fw.write(cabeceraFichero);
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String menu = "=============================================\n" +
                "=========  REGISTRO DE TEMPERATURAS  ========\n" +
                "=============================================\n" +
                "1.- Registrar nueva temperatura\n" +
                "2.- Mostrar historial de registros por ciudad\n" +
                "3.- Mostrar media de temperatura por ciudad\n" +
                "4.- Salir\n";

        int opcion = 0;
        while (opcion != 4) {
            System.out.println(menu);
            System.out.println("Introduce una opción");
            opcion = sc.nextInt();
            sc.nextLine();  // Consumir la nueva línea después de la entrada del número

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la ciudad");
                    String ciudad = sc.nextLine();
                    System.out.println("Introduce la fecha");
                    String fecha = sc.next();
                    System.out.println("Introduce la temperatura máxima");
                    int temperaturaMaxima = sc.nextInt();
                    System.out.println("Introduce la temperatura mínima");
                    int temperaturaMinima = sc.nextInt();
                    Registro nuevoRegistro = new Registro(ciudad, fecha, temperaturaMaxima, temperaturaMinima);
                    registro.add(nuevoRegistro);

                    // Escribir en el fichero
                    try {
                        fw = new FileWriter(fichero, true);
                        fw.write(nuevoRegistro.toString());
                        fw.write("\n");
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la ciudad");
                    ciudad = sc.nextLine();
                    for (Registro temp : registro) {
                        if (temp.getCiudad().equals(ciudad)) {
                            System.out.println(temp);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el nombre de la ciudad");
                    ciudad = sc.nextLine();
                    double mediaTempMaxima = 0;
                    double mediaTempMinima = 0;
                    int registros = 0;
                    for (Registro temp : registro) {
                        if (temp.getCiudad().equals(ciudad)) {
                            registros++;
                            mediaTempMaxima += temp.getTempMax();
                            mediaTempMinima += temp.getTempMin();
                        }
                    }
                    System.out.println("Temperatura máxima media: " + mediaTempMaxima / registros);
                    System.out.println("Temperatura mínima media: " + mediaTempMinima / registros);
                    System.out.println("Temperatura media max-min: " + (mediaTempMaxima / registros + mediaTempMinima / registros) / 2);
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
