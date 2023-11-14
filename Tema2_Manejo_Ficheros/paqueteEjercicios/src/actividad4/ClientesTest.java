package actividad4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ClientesTest {
    private static Scanner sc;
    private static ArrayList<Cliente> listaClientes;
    private static File fichero;
    private static FileWriter fw;
    
    public static void main(String[] args) {
        
        sc= new Scanner(System.in);
        listaClientes= new ArrayList<Cliente>();

        String ruta="D:\\FP\\SEGUNDO\\3_AccesoDatos\\EjerciciosJava\\Tema2_Manejo_Ficheros\\paqueteEjercicios\\src\\actividad4";
        String nomFichero="clientes.txt";
        String menu="CLIENTES BANCO MORATO\n"+
                    "1.- Alta cliente\n"+
                    "2.- Baja cliente\n"+
                    "3.- Listar clientes por saldo\n"+
                    "4.- Saldo medio clientes\n"+
                    "5.- Salir";
        fichero = new File(ruta, nomFichero);
        try {      
            int opcion=0;
            while (opcion !=5){
                System.out.println(menu);
                System.out.println("Elige una opción: ");
                opcion=sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1:
                        System.out.println("Proceso de alta de cliente: ");
                        altaClientes();
                        break;
                    case 2:
                        System.out.println("Proceso de baja de cliente: ");
                        bajaClientes();
                        break;
                    case 3:
                        System.out.println("Listar clientes ordenados por saldo: ");
                        System.out.println(ordenarClientesPorSaldo());
                        break;
                    case 4:
                        System.out.println("El saldo medio de los clientes es: "+saldoMedio()+" euros.");
                        saldoMedio();
                        break;
                    case 5:
                        System.out.println("Aplicación finalizada, que tenga buen día.");
                        break;
                    default:
                        System.out.println("Opción incorrecta, prueba otra vez.");
                        break;
                }
            }
            sc.close();
            fw.close();
        } catch (IOException e) {        
            e.printStackTrace();
        }
    }
    public static void altaClientes(){
        System.out.println("Introduce el nombre del cliente para dar el alta: ");
        String nombre= sc.nextLine();
        System.out.println("Introduce el dni de "+nombre);
        String dni= sc.next();
        System.out.println("Introduce la fecha de nacimiento de "+nombre);
        String fechaNacimiento= sc.next();
        System.out.println("Introduce el saldo de "+nombre);
        Double saldo=sc.nextDouble();
        Cliente cliente= new Cliente(nombre, dni, fechaNacimiento, saldo);
        listaClientes.add(cliente);
        guardarDatos(cliente.toString());
    }
    public static void bajaClientes(){
        System.out.println("Introduce el dni del cliente a dar de baja: ");
        String dni=sc.next();         
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cli = iterator.next();
            if (cli.getDni().equals(dni)) {
                iterator.remove(); // Utiliza el método remove del iterador
                eliminarDatos(cli.getNombre().toString());
            }
        }
    }
        
    public static Double saldoMedio(){
        Double saldoMed=0.0;
        int numCli=0;
        for (Cliente cli : listaClientes) {
            numCli++;
            saldoMed += cli.getSaldo();
        }
        return saldoMed/numCli;
    }
    public static void guardarDatos(String persona){
        try {
            fw= new FileWriter(fichero, true);
            fw.write(persona);
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarDatos(String persona){
        try {
            File tempFile = new File(fichero.getAbsolutePath() + ".tmp");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            bw.write(""); // Limpiamos el archivo temporal
            bw.close();
    
            for (Cliente cliente : listaClientes) {
                if (!cliente.getNombre().equals(persona)) {
                    guardarDatos(cliente.toString());
                }
            }
    
            // Se cierra el archivo original y se renombra
            fw.close();
            tempFile.renameTo(fichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public static String ordenarClientesPorSaldo(){
        String clientela="";
        Collections.sort(listaClientes);
        for (Cliente cliente : listaClientes) {
            clientela +=cliente.toString()+"\n";   
        }
        return clientela;
    }
}
