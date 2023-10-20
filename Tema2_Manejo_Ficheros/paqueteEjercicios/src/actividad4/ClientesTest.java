package actividad4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientesTest {
    private static Scanner sc;
    private static ArrayList<Cliente> listaClientes;
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        listaClientes= new ArrayList<Cliente>();

        String ruta="D:\\FP\\SEGUNDO\\3_AccesoDatos\\EjerciciosJava\\EjerciciosClase\\paqueteEjercicios\\src\\actividad4";
        String nomFichero="clientes.txt";
        String menu="CLIENTES BANCO MORATO\n"+
                    "1.- Alta cliente\n"+
                    "2.- Baja cliente\n"+
                    "3.- Listar clientes por saldo\n"+
                    "4.- Saldo medio clientes\n"+
                    "5.- Salir";
        File fichero = new File(ruta, nomFichero);
        try {
            FileWriter fw= new FileWriter(fichero);
            int opcion=0;
            sc.nextInt();
            while (opcion !=5){
                System.out.println(menu);
                System.out.println("Elige una opción");
                opcion=sc.nextInt();
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
    }
    public static void bajaClientes(){
        System.out.println("Introduce el dni del cliente a dar de baja: ");
        String dni=sc.next();
        for (Cliente cli : listaClientes) {
            if (cli.getDni().equals(dni)){
                listaClientes.remove(cli);
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

    public static void guardarDatos(){

    }
    public static void listadoDatos(){

    }
}
