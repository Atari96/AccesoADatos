package transportesPabloMorato.pojoPablo;

public class Provincia {
    private String codProvincia;
    private String nombre;

    public Provincia(int codProvincia, String nombre) {
        this.codProvincia = nombre.substring(0,3).toUpperCase();
        this.nombre = nombre;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Provincia [codProvincia=" + codProvincia + ", nombre=" + nombre + "]";
    }

    
    
}
