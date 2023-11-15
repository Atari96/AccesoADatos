package actividad5;

import java.io.Serializable;

public class Registro implements Serializable{
    private String ciudad;
    private String fecha;
    private int tempMax;
    private int tempMin;

    public Registro(String ciudad, String fecha, int tempMax, int tempMin) {
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
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

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    @Override
    public String toString() {
        return "Registro [ciudad=" + ciudad + ", fecha=" + fecha + ", tempMax=" + tempMax + ", tempMin=" + tempMin
                + "]";
    }
    
    

    


}
