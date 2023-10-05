package Parking_PabloMorato;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingVehiculoPabloMorato implements ParkingPabloMorato{
    private final double PRECIOMINUTO=0.0425;
    private final int NUMEROMAXPLAZAS=100;
    private String sDireccion;
    private int iPlazasActuales;
    private ArrayList<VehiculoPabloMorato> vehiculosEnParking=new ArrayList<VehiculoPabloMorato>();

    /*Constructores */
    public ParkingVehiculoPabloMorato(String paramDireccion, int paramPlazasActuales) {
        this.sDireccion = paramDireccion;
        this.iPlazasActuales = paramPlazasActuales;
    }
    /*Getters y setters */
    public String getsDireccion() {
        return sDireccion;
    }
    public void setsDireccion(String sDireccion) {
        this.sDireccion = sDireccion;
    }
    public int getiPlazasActuales() {
        return iPlazasActuales;
    }
    public void setiPlazasActuales(int iPlazasActuales) {
        this.iPlazasActuales = iPlazasActuales;
    }
    public double getPRECIOMINUTO() {
        return PRECIOMINUTO;
    }
    public int getNUMEROMAXPLAZAS() {
        return NUMEROMAXPLAZAS;
    }

    /*Metodos */
    public boolean hayPlaza(){
        boolean plaza=false;
        if (NUMEROMAXPLAZAS>getiPlazasActuales()){
            plaza=true;
        }
        return plaza;
    }
    public void aparcaCoche(VehiculoPabloMorato vehiculo){
        if(hayPlaza()){
            vehiculo.setdFechaInicio(LocalDateTime.now());
            iPlazasActuales++;
            vehiculosEnParking.add(vehiculo);
            System.out.println("El vehículo con matricula "+vehiculo.getsMatricula()+" ha sido estacionado en el parking");
        }
        else{
            System.out.println("El parking está lleno");
        }
    }
    public void sacaCoche(VehiculoPabloMorato vehiculo){
        if (comprobarCocheEnParking(vehiculo)==false){
            System.out.println("Hay un error con la matricula, ese vehículo no se encuentra en el parking");
        }
        if (vehiculo.getdFechaInicio()!=null && vehiculo.getdFechaFin()==null){
            vehiculo.setdFechaFin(LocalDateTime.now());
            vehiculosEnParking.remove(vehiculo);
            iPlazasActuales--;
            System.out.println("El vehículo con matricula "+vehiculo.getsMatricula()+" ha abandonado el parking");
            System.out.println(getFactura(vehiculo)); 
        }
    }
    public String getFactura(VehiculoPabloMorato vehiculo){
        double factura=0;
        Duration duration=Duration.between(vehiculo.getdFechaInicio(), vehiculo.getdFechaFin());
        double minutos=duration.toMinutes()+10;
        factura=(double) minutos*PRECIOMINUTO*100;
        int factura2=(int) factura;
        double factura3=(double) factura2/100; 
        return "El vehiculo "+vehiculo.getsMatricula()+" entrada "+ vehiculo.getdFechaInicio()+" salida "+vehiculo.getdFechaFin()+" Importe "+factura3+ " euros.";
    }
    public boolean comprobarCocheEnParking(VehiculoPabloMorato vehiculo){
        for(VehiculoPabloMorato vehiculo1: vehiculosEnParking) {
            if (vehiculo1.getsMatricula().equals(vehiculo.getsMatricula())){
                return true;
            }
        }
        return false;
    }
    public VehiculoPabloMorato seleccionarVehiculoPorMatricula(String matricula) {
        for (VehiculoPabloMorato vehiculo : vehiculosEnParking) {
            if (vehiculo.getsMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null; // Si no se encuentra el vehículo, devuelve null
    }

    public String toString() {
        String listaVehiculosParking="";
        for (int i=0; i<vehiculosEnParking.size();i++){
            listaVehiculosParking=listaVehiculosParking+" "+vehiculosEnParking.get(i);
        }
        return "Parking MORATO S.A.: Precio Minuto= " + PRECIOMINUTO + ", número máximo de plazas= " + NUMEROMAXPLAZAS
                + ", dirección= " + sDireccion + ", plazas ocupadas= " + iPlazasActuales+", coches en el parking: "+listaVehiculosParking;
    }
    
    
}
