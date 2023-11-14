package transportesPabloMorato.mainPabloMorato;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import transportesPabloMorato.pojoPablo.Empleado;

public class TransportesPabloTest {

    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        List<Empleado> listadoEmpleados=new ArrayList<Empleado>();

        String menu = "TRANSPORTES MORATO: \n"+
                        "===================\n"+
                        "1.- Listar todos los empleados\n"+
                        "2.- Listar todo\n"+
                        "3.- Insertar nuevo empleado\n"+
                        "4.- Insertar nueva localidad\n"+
                        "5.- Borrar empleado\n"+
                        "6.- Mostrar empleado más antiguo\n"+
                        "7.- Mostrar empleado que gana mas dinero\n"+
                        "8.- Salir\n";


        
        
        // Inicio y gestión de la aplicacion
        int opcion = 0;
        while (opcion !=8){
            System.out.println(menu);
            System.out.println("Introduce una opción");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce una opción correcta\n");
            }           
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Listar todos los empleados");
                    listarEmpleados(listadoEmpleados);
                    break;
                case 2:
                    System.out.println("Listar todo");
                    break;
                case 3:
                    System.out.println("Alta nuevo empleado");
                    System.out.println("Introduce el nombre del empleado");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce el dni del empleado");
                    String dni = sc.next();
                    System.out.println("Introduce la fecha de nacimiento (dd-mm-aaaa)");
                    String fechaNac = sc.next();
                    System.out.println("Introduce el telefono");
                    String telefono = sc.next();
                    System.out.println("Introduce el salario");
                    double salario = sc.nextDouble();
                    Empleado empleado = new Empleado(nombre, dni, fechaNac, telefono, salario);
                    listadoEmpleados.add(empleado);
                    System.out.println("Nuevo empledo creado: "+empleado.toString());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción incorrecta, pruebe de nuevo");
            }      
        }
    }
    private static void listarEmpleados(List<Empleado> listadoEmpleados) {
        System.out.println("Lista de empleados:");
        for (Empleado emp : listadoEmpleados) {
                System.out.println(emp);
            }
    }

    private static void accesoXML(String ruta){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document document=db.parse(new File(ruta));
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
