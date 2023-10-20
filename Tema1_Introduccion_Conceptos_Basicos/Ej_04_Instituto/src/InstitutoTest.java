public class InstitutoTest {
    
public static void main(String[] args) {
    Aula aula1=new Aula("Newman",12);
    Aula aula2=new Aula("Codd",30);
    Profesor profesor1=new Profesor("Alvaro", 55, aula1, "BBDD");
    Profesor profesor2=new Profesor("David", 55, aula1, "Programacion");
    Profesor profesor3=new Profesor("Miguel Angel", 55, aula1, "Aplicaciones");
    Profesor profesor4=new Profesor("Arturo", 55, aula1, "Montaje");
    Profesor profesor5=new Profesor("Jesus", 55, aula1, "Ofimatica");

    System.out.println("Lista profesores aula1 ");
    String [] claseAula1=aula1.obtenerListaProfesores();
    for (int i=0; i<claseAula1.length;i++){
        System.out.println("- "+claseAula1[i]);
    }
    System.out.println("Lista profesores aula2 ");
    String [] claseAula2=aula2.obtenerListaProfesores();
    for (String prof : claseAula2){
        System.out.println("- "+prof);
    }
    System.out.println("**********************");
    System.out.println("AULA 1:\n"+aula1);
    System.out.println("**********************");
    System.out.println("AULA 2:\n"+aula2);
    System.out.println("**********************");
    System.out.println(profesor1+"\n");
    System.out.println(profesor2+"\n");
    System.out.println(profesor3+"\n");
    System.out.println(profesor4+"\n");
    System.out.println(profesor5);
    
}

}
