package nba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="equipos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipo{
    
    @XmlElement(name="idEquipo")
    private int idEquipo;
    @XmlElement(name="nombre")
    private String nombre;
    @XmlElement(name="ciudad")
    private String ciudad;
    @XmlElement(name = "equipo")
    private List<Equipo> listaEquipos;

    public Equipo(){}

    public Equipo(int idEquipo, String nombre, String ciudad) {
        listaEquipos = new ArrayList<>();
    }
    
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "idEquipo=" + idEquipo + ", nombre=" + nombre + ", ciudad=" + ciudad;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setLstaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }    
}
