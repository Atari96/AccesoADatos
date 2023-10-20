package Parking_PabloMorato;

import java.time.LocalDateTime;

public class VehiculoPabloMorato {
    /*Atributos */
    private String sMatricula;
    private LocalDateTime dFechaInicio;
    private LocalDateTime dFechaFin;

    /*Constructor */
    public VehiculoPabloMorato(String paramMatricula) {
        this.sMatricula = paramMatricula;
    }

    /*Getters y setters */
    public String getsMatricula() {
        return sMatricula;
    }
    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }
    public LocalDateTime getdFechaInicio() {
        return dFechaInicio;
    }
    public void setdFechaInicio(LocalDateTime dFechaInicio) {
        this.dFechaInicio = dFechaInicio;
    }
    public LocalDateTime getdFechaFin() {
        return dFechaFin;
    }
    public void setdFechaFin(LocalDateTime dFechaFin) {
        this.dFechaFin = dFechaFin;
    }
    public String toString() {
        return "Vehículo matrícula= " + sMatricula + ", Fecha Inicio= " + dFechaInicio + ", Fecha Fin= "
                + dFechaFin;
    }

    /*Metodos */
    
    
}
