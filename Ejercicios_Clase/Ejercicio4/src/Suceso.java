import java.time.LocalDateTime;

public class Suceso extends Punto3D{
    private LocalDateTime tiempo;
    private String descripcion;

    public Suceso(int coordenadaX, int coordenadaY, int coordenadaZ, LocalDateTime LocalDateTime, String descripcion ) {
        super(coordenadaX, coordenadaY, coordenadaZ);
        this.tiempo=tiempo;
        this.descripcion=descripcion;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static boolean equals(Suceso p1, Suceso p2){
        boolean iguales=false;
        if (p1.getCoordenadaX()==p2.getCoordenadaX() && 
                p1.getCoordenadaY()==p2.getCoordenadaY() && 
                    p1.getCoordenadaZ()==p2.getCoordenadaZ() &&
                        p1.getTiempo()==p2.getTiempo() &&
                            p1.getDescripcion()==p2.getDescripcion()){
            iguales=true;
        }
        return iguales;
    }

    @Override
    public String toString() {
        return super.toString()+" Suceso [tiempo=" + tiempo + ", descripcion=" + descripcion + "]";
    }
}
