package actividad6;

import java.io.Serializable;

public class ClienteSer implements Serializable, Comparable<ClienteSer>{
    private String nombreCliente;
    private String dniCliente;
    private String fechaNacimiento;
    private Double saldoCliente;

    public ClienteSer(String nombreCliente, String dniCliente, String fechaNacimiento, Double saldoCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoCliente = saldoCliente;   
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(Double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    @Override
    public String toString() {
        return "ClienteSer [nombreCliente=" + nombreCliente + ", dniCliente=" + dniCliente + ", fechaNacimiento="
                + fechaNacimiento + ", saldoCliente=" + saldoCliente + "]";
    }

    @Override
    public int compareTo(ClienteSer c) {  
        return (int) (c.getSaldoCliente()-this.getSaldoCliente());
    }
}
