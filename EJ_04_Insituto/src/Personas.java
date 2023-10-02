public abstract class Personas {
    private String sNombre;
    private int iEdad;
    private Aula aula;

    public Personas(String sNombre, int iEdad, Aula aula){
        this.sNombre=sNombre;
        this.iEdad=iEdad;
        this.aula=aula;
    }
    public String getsNombre() {
        return sNombre;
    }
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
    public int getiEdad() {
        return iEdad;
    }
    public void setiEdad(int iEdad) {
        this.iEdad = iEdad;
    }
    public Aula getAula() {
        return aula;
    }
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    public String toString() {
        return sNombre + ", " + iEdad + ", aula=" + aula;
    }
    
    
}
