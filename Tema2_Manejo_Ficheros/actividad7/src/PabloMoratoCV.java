import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class PabloMoratoCV {
    private static List<String> datosPersonales;
    private static List<String> experiencia1;
    private static List<String> experiencia2;
    private static List<String> experiencia3;
    private static List<String> formacionReglada;
    private static List<String> complementos;
    private static List<String> complementos1;

    public static void main(String[] args){
        Gson gson = new Gson();

        datosPersonales = new ArrayList<>();
        datosPersonales.add("Pablo Morato Polo");
        datosPersonales.add("1234567890A");
        datosPersonales.add("Palacio de la Zarzuela");
        datosPersonales.add("28051");

        experiencia1 = new ArrayList<>();
        experiencia1.add("Profesor");
        experiencia1.add("Julio 2010 - Actualidad");
        experiencia1.add("Impartiendo asignaturas de naturales y tecnología");

        experiencia2 = new ArrayList<>();
        experiencia2.add("Auditor Interno");
        experiencia2.add("Junio 2005 - Julio 2010");
        experiencia2.add("Análisis contable y suscripción de riesgos");

        experiencia3 = new ArrayList<>();
        experiencia3.add("Geólogo");
        experiencia3.add("Marzo 2001 - Junio 2005");
        experiencia3.add("Redacción estudios geotécnicos");

        formacionReglada = new ArrayList<>();
        formacionReglada.add("Título de Formación Profesional Desarrollo Aplicaciones Multiplataforma DAM");
        formacionReglada.add("Junio 2024");

        complementos =new ArrayList<>();
        complementos.add("Ingles");
        complementos.add("Nivel B2");

        complementos1 =new ArrayList<>();
        complementos1.add("Carnet de conducir");
        complementos1.add("B1");

        // Imprimir JSON
        System.out.println("Datos Personales:");
        System.out.println("=================\n");
        System.out.println(datosPersonales.get(0)+"\n"+datosPersonales.get(1)+"\n"
        +datosPersonales.get(2)+"\n"+datosPersonales.get(3)+"\n");

        System.out.println("Experiencia laboral:");
        System.out.println("====================\n");
        System.out.println(experiencia1.get(1)+"   "+experiencia1.get(0)+"\n"+experiencia1.get(2)+"\n");

        System.out.println(experiencia2.get(1)+"   "+experiencia2.get(0)+"\n"+experiencia2.get(2)+"\n");
        
        System.out.println(experiencia3.get(1)+"   "+experiencia3.get(0)+"\n"+experiencia3.get(2)+"\n");
        
        System.out.println("Formación Reglada:");
        System.out.println("==================\n");
        System.out.println(formacionReglada.get(1)+"   "+formacionReglada.get(0)+"\n");

        System.out.println("Complementos:");
        System.out.println("=============\n");
        System.out.println(complementos.get(0)+"   "+complementos.get(1));
        System.out.println(complementos1.get(0)+"   "+complementos1.get(1)+"\n");

        // Cambiar el nivel de inglés de B2 a B1 
        complementos.set(1, "Nivel B1");

        // Crear un objeto JSON que contenga todas las secciones
        List<String> secciones = new ArrayList<>();
        secciones.add("Datos personales: ");
        secciones.add(gson.toJson(datosPersonales));
        secciones.add("Experiencia laboral: ");
        secciones.add(gson.toJson(experiencia1));
        secciones.add(gson.toJson(experiencia2));
        secciones.add(gson.toJson(experiencia3));
        secciones.add("Formación reglada: ");
        secciones.add(gson.toJson(formacionReglada));
        secciones.add("Complementos: ");
        secciones.add(gson.toJson(complementos));
        secciones.add(gson.toJson(complementos1));

        // Convertir el objeto JSON a String
        String jsonCompleto = gson.toJson(secciones);

        // Imprimir JSON modificado
        System.out.println("Datos Personales Modificados: " + complementos.get(0)+"   "+ complementos.get(1));
        secciones.add(gson.toJson(complementos));

        // Guardar JSON en archivo
        guardarEnArchivo("datosPersonales.json", jsonCompleto);
    }

    private static void guardarEnArchivo(String CV_Pablo, String contenido) {
        try (FileWriter fileWriter = new FileWriter(CV_Pablo)) {
            fileWriter.write(contenido);
            System.out.println("Datos guardados en el archivo: " + CV_Pablo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}