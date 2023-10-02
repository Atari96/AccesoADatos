public class Alumno extends Personas{
    private int iBBDD;
    private int iProgramacion;
    private int iAplicaciones;
    private int iMontaje;
    private int iOfimatica;

    public Alumno(String sNombre, int iEdad, Aula aula, int iBBDD, int iProgramacion, int iAplicaciones, int iMontaje, int iOfimatica){
        super(sNombre, iEdad, aula);
        this.iBBDD=iBBDD;
        this.iProgramacion=iProgramacion;
        this.iAplicaciones=iAplicaciones;
        this.iMontaje=iMontaje;
        this.iOfimatica=iOfimatica;
    }
    public int getiBBDD() {
        return iBBDD;
    }
    public void setiBBDD(int iBBDD) {
        this.iBBDD = iBBDD;
    }
    public int getiProgramacion() {
        return iProgramacion;
    }
    public void setiProgramacion(int iProgramacion) {
        this.iProgramacion = iProgramacion;
    }
    public int getiAplicaciones() {
        return iAplicaciones;
    }
    public void setiAplicaciones(int iAplicaciones) {
        this.iAplicaciones = iAplicaciones;
    }
    public int getiMontaje() {
        return iMontaje;
    }
    public void setiMontaje(int iMontaje) {
        this.iMontaje = iMontaje;
    }
    public int getiOfimatica() {
        return iOfimatica;
    }
    public void setiOfimatica(int iOfimatica) {
        this.iOfimatica = iOfimatica;
    }
    public String toString() {
        return super.toString()+"Alumno, notas: BBDD=" + iBBDD + ", Programacion=" + iProgramacion + ", Aplicaciones=" + iAplicaciones
                + ", Montaje=" + iMontaje + ", Ofimatica=" + iOfimatica ;
    }
    
}
