public class Profesor extends Personas{
    private String sMateria;

    public Profesor(String sNombre, int iEdad, Aula aula, String sMateria){
        super(sNombre, iEdad, aula);
        this.sMateria=sMateria;
    }
    public String getsMateria() {
        return sMateria;
    }
    public void setsMateria(String sMateria) {
        this.sMateria = sMateria;
    }
    public String toString() {
        return super.toString()+" Profesor, sMateria: " + sMateria;
    }
    
}
