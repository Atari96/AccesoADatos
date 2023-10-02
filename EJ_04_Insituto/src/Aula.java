import java.util.Arrays;

public class Aula {
    public enum sNombreAula{Aula_B3, Aula_B5, Aula_2_6, Aula_2_7 };
    private String sNombreAula;
    private int iNumEstudiantes;
    private String[] profesores;
    private String[] alumnos;
    private String[] materias;

    public Aula(String sNombreAula, int iNumEstudiantes){
        this.sNombreAula=sNombreAula;
        this.iNumEstudiantes=iNumEstudiantes;
       
    }
    public String buscarMateriaProfesor(String nombreProfesor){
        for (String sNombre : profesores){
            if (sNombre.equals(nombreProfesor)){
                Profesor profesor=buscarProfesorPorNombre(nombreProfesor);
                return profesor.getsMateria();
            }
        }
        return null;
    }
    private Profesor buscarProfesorPorNombre(String nombreProfesor){
     
        Profesor profesor=null;
        for (String sNombre : profesores){
            if (sNombre.equals(nombreProfesor)){
                profesor=buscarProfesorPorNombre(nombreProfesor);
                return profesor;
            }
        }
        return null;
    }
    public String[] obtenerListaProfesores(){

        return Constantes.LISTA_PROFESORES;
    }

    public String getsNombre() {
        return sNombreAula;
    }
    public void setsNombre(String sNombreAula) {
        this.sNombreAula = sNombreAula;
    }
    public int getiNumEstudiantes() {
        return iNumEstudiantes;
    }
    public void setiNumEstudiantes(int iNumEstudiantes) {
        this.iNumEstudiantes = iNumEstudiantes;
    }
    public String[] getProfesores() {
        return profesores;
    }
    public void setProfesores(String[] profesores) {
        this.profesores = profesores;
    }
    public String[] getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(String[] alumnos) {
        this.alumnos = alumnos;
    }
    public String[] getMaterias() {
        return materias;
    }
    public void setMaterias(String[] materias) {
        this.materias = materias;
    }
    public void addMateria(){

    }
    public void addProfesor(){

    }
    public void addAlumno(){

    }
    public String toString() {
        return "Aula: " + sNombreAula + ", iNumEstudiantes=" + iNumEstudiantes + ", profesores="
                + Arrays.toString(profesores) + ", alumnos=" + Arrays.toString(alumnos) + ", materias="
                + Arrays.toString(materias);
    }
    
}
