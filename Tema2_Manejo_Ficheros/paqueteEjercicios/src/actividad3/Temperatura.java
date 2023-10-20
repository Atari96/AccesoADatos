package actividad3;

public class Temperatura {
    private int temperaturaMaxima;
    private int temperaturaMinima;
    private String ciudad;
    private String fecha;
    
    public Temperatura(int temperaturaMaxima, int temperaturaMinima, String ciudad, String fecha) {
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(int temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(int temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return ciudad+" "+fecha+" "+temperaturaMaxima+" "+temperaturaMinima;
    }

    
}
