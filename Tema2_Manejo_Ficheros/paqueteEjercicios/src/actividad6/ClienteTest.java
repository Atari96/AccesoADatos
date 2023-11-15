package actividad6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClienteTest {
        private static Scanner sc = new Scanner (System.in);
        private static String ruta = "D:\\FP\\SEGUNDO\\3_AccesoDatos\\EjerciciosJava\\Tema2_Manejo_Ficheros\\paqueteEjercicios\\src\\actividad6";
        private static String nombreArchivo = "clientes.dat";
        private static File file;
        private static ArrayList<ClienteSer> listadoClientes;

    public static void main(String[] args) {
        sc = new Scanner (System.in);
        file = new File (ruta, nombreArchivo);
        listadoClientes = new ArrayList<ClienteSer>();

        String menu =   "MENU:\n"+
                        "1.- Alta cliente\n"+
                        "2.- Baja cliente\n"+
                        "3.- Listar clientes por saldo\n"+
                        "4.- Saldo medio\n"+
                        "5.- Salir";

        int opcion = 0;
        while (opcion !=5){
            System.out.println(menu);
            System.out.println("Introduce una opción");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Introduce el nombre del cliente");
                    String nombreCliente = sc.nextLine();
                    System.out.println("Introduce dni");
                    String dniCliente = sc.next();
                    System.out.println("Introduce fecha de nacimiento");
                    String fechaNacimiento = sc.next();
                    System.out.println("Introduce saldo");
                    Double saldoCliente = sc.nextDouble();
                    ClienteSer cliente = new ClienteSer(nombreCliente, dniCliente, fechaNacimiento, saldoCliente);
                    listadoClientes.add(cliente);
                    guardarCliente(cliente);
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente");
                    dniCliente = sc.next();
                    break;
                case 3:
                    System.out.println("Listado de clientes por saldo");
                    System.out.println(ordenarClientesPorSaldo());
                    break;
                case 4:
                    System.out.println("El saldo medio es: "+saldoMedio());
                    break;
                case 5:
                System.out.println("Fin de la aplicación. Hasta luego!");
                    break;
                default:
                    System.out.println("Opción errónea, prueba de nuevo.");
            }
        }
        System.out.println("Leemos fichero: "+leerFichero());
        sc.close();
    }
    public static void guardarCliente(ClienteSer cliente){
        OutputStream fis;
        try {
            fis = new FileOutputStream(file);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(cliente);
            ois.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }        
    } 
    public static ClienteSer[] leerFichero() {
        ArrayList<ClienteSer> clientesLeidos = new ArrayList<>();
        ClienteSer[] objetos = null;
        FileInputStream fis;

        try {
            fis = new FileInputStream(file);
            
            // Lee un objeto serializado en cada iteración y lo agrega a la lista
            
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                ClienteSer cliente = (ClienteSer) ois.readObject();
                clientesLeidos.add(cliente);
            }
            
        } catch (EOFException e) {
            // Esto ocurre cuando se alcanza el final del archivo
            objetos = clientesLeidos.toArray(new ClienteSer[0]);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        
        return objetos;
    }
    public static String ordenarClientesPorSaldo(){
        String clientela="";
        Collections.sort(listadoClientes);
        for (ClienteSer cliente : listadoClientes) {
            clientela +=cliente.toString()+"\n";   
        }
        return clientela;
    }
    public static Double saldoMedio(){
        Double saldoM=0.0;
        int contador=0;
        for (ClienteSer clienteSer : listadoClientes) {
            contador++;
            saldoM +=clienteSer.getSaldoCliente();
        }
        return saldoM/contador;
    } 
}
