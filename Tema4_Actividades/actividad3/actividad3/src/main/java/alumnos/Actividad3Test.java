package alumnos;

public class Actividad3Test {
    public static void main(String[] args) {
        String clase="Bases de datos";
        String clase2=clase.replace(" ", "");
        AlumnoBD.guardarEnXML(AlumnoBD.consultarAlumnos(clase), clase2);
        
    }
}