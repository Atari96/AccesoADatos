package alumnos;

public class Alumno {
    private String idAlumno;
    private String nombre;
    private String clase;

    public Alumno(){}
    
    public Alumno(String idAlumno, String nombre, String clase) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.clase = clase;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", clase=" + clase + "]";
    }

}
