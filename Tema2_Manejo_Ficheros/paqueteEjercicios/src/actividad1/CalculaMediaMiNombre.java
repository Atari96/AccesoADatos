package actividad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Problema para calcular la media de edad y altura de los datos contenidos de un archivo

public class CalculaMediaMiNombre {

    public static void main(String[] args) {
        // Creamos el fichero
        String ruta=".";
        String nombre = "calculaMediaMiNombre.txt";
        File fichero = new File(ruta, nombre);
        // Creamos un array para escribir en el fichero
        String[] array1={"Rudy 37 1.96", "Sergio 36 1.91", "Adam 33 2.2", "Edy 30 2.2", "Mario 27 2.02"};
        
        try {
            // Escribimos e el fichero
            FileWriter fw = new FileWriter(fichero);
            for (String str : array1){
                fw.write(str+"\n");
            }
            fw.close();

            // Leemos el archivo
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea="";
            double mediaEdad=0;
            double mediaAltura=0;
            int numPersonas=0;
            // Extraemos las edades y las alturas
            while ((linea=br.readLine())!=null){
                String[] lineaArray= linea.split(" ");
                numPersonas++;  
                mediaEdad +=Integer.parseInt(lineaArray[1]);
                mediaAltura +=Double.parseDouble(lineaArray[2]);
            }
            br.close();
            System.out.println("Media de edad: "+mediaEdad/numPersonas);
            System.out.println("Media de altura: "+mediaAltura/numPersonas);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
