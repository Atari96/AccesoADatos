package transportesPabloMorato.pojoPablo;

public class Localidad {
    private String codLocalidad;
    private String nombre;

    public Localidad(String nombre) {
        this.codLocalidad = nombre.substring(0,3).toUpperCase();
        this.nombre = nombre;
    }

    public String getCodLocalidad() {
        return codLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Localidad [codLocalidad=" + codLocalidad + ", nombre=" + nombre + "]";
    }

    
    
    
}
