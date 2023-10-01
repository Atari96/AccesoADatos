import java.util.Scanner;

public class PersonaTest {
    public static void main(String[] args) throws Exception {
        Persona persona1=new Persona("Pepe", 33, Sexo.HOMBRE);
        System.out.println(persona1.generarDNI()); 
        System.out.println(persona1.validarSexo(persona1));
        System.out.println(persona1.validarDNI("05419175F")); 
        System.out.println(persona1.validarDNI("05419175f")); 
        Persona persona2=new Persona("Pepote", 55, "05419175F", Sexo.HOMBRE, 80, 1.87);
        System.out.println("IMC "+persona2.calcularIMC()); 

        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el nombre");
        String nombre=sc.nextLine();
        System.out.println("Introduce la edad");
        int edad=sc.nextInt();
        Sexo sexo=null;
        while (sexo == null) {
            System.out.println("Introduce el sexo (HOMBRE o MUJER): ");
            String entrada = sc.next().toUpperCase(); 
            
            if (entrada.equals("HOMBRE")) {
                sexo = Sexo.HOMBRE;
            } else if (entrada.equals("MUJER")) {
                sexo = Sexo.MUJER;
            } else {
                System.out.println("Valor no válido. Introduce HOMBRE o MUJER.");
            }
        }
        System.out.println("Introduce el peso");
        double peso=sc.nextDouble();
        System.out.println("Introduce la altura");
        double altura=sc.nextDouble();
        Persona persona3=new Persona(nombre, edad, nombre, sexo, peso, altura); 
        Persona persona4=new Persona(nombre, edad, sexo);
        Persona persona5=new Persona();
        System.out.println(persona5);
        persona5.setNombre("Edelmiro");
        persona5.setEdad(105);
        persona5.setDni(persona5.generarDNI());
        persona5.setPeso(120);
        persona5.setAltura(1.88);
        System.out.println(persona5);
        System.out.println("Persona1 IMC "+persona1.calcularIMC());
        System.out.println("Persona2 IMC "+persona2.calcularIMC());
        System.out.println("Persona3 IMC "+persona3.calcularIMC());
        System.out.println("Persona4 IMC "+persona4.calcularIMC());
        System.out.println("Persona5 IMC "+persona5.calcularIMC());
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);
        System.out.println(persona4);
        System.out.println(persona5);

    }
}
