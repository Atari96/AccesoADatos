package transportesPabloMorato.pojoPablo;

public class Region {
    private String nombre;
    private String codRegion;

    public Region(String nombre) {
        this.nombre = nombre;
        this.codRegion = nombre.substring(0,3).toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodRegion() {
        return codRegion;
    }

    @Override
    public String toString() {
        return "Region [codRegion=" + codRegion +", nombre" +nombre +"]";
    }

    

    

    
    
}
