package actividad2;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personas> listadoPersonas=new ArrayList<Personas>();
        String menu="     ===================\n"+
                    "     AGENDA DE CONTACTOS\n"+
                    "     ===================\n"+
                    "     Elige una opción:\n"+
                    "     1.- Nuevo contacto\n"+
                    "     2.- Buscar por nombre\n"+
                    "     3.- Mostrar todos\n"+
                    "     4.- Salir\n";

        int opcion=0;
        while (opcion !=4){
            System.out.println(menu);
            try {
                opcion=sc.nextInt();
            } catch (Exception e) {
                
            } 
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Introduce el nombre: ");                   
                    String nombre = sc.nextLine();                   
                    System.out.println("Introduce el telefono de "+nombre+":");                    
                    String telefono = sc.next();
                    System.out.println("Usuario: "+nombre+" "+telefono+" introducido correctamente\n");
                    Personas persona1=new Personas(nombre, telefono);
                    listadoPersonas.add(persona1);
                    break;
                case 2:
                    System.out.println("Introduce las iniciales para la búsqueda");
                    String iniciales=sc.next().toLowerCase();
                    String iniciales2=iniciales.toUpperCase();
                    for (Personas personas : listadoPersonas) {
                        if (personas.getNombre().startsWith(iniciales) || personas.getNombre().startsWith(iniciales2)){
                            System.out.println(personas.getNombre()+" "+personas.getTelefono());
                        }                   
                    }
                    break;
                case 3:
                    System.out.println("Listado completo de contactos");
                    for (Personas personas : listadoPersonas) {
                        System.out.println(personas.getNombre()+" "+personas.getTelefono());
                    }                   
                    break;
                case 4:
                    System.out.println("Fin de la aplicación, hasta luego campeón!\n");
                    break;
                default:
                    System.out.println("Opción no válida, prueba otra vez. \n");
                    break;
            }
        }
    sc.close();    
    }
}
