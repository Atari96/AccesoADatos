package nba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jugadores")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jugador {
    
    @XmlElement(name="idJugador")
    private int idJugador;
    @XmlElement(name="nombre")
    private String nombre;
    @XmlElement(name="edad")
    private int edad;
    @XmlElement(name = "altura")
    private Double altura;
    @XmlElement(name = "pais")
    private String pais;
    @XmlElement(name = "jugador")
    private List<Jugador> listaJugadores;

    public Jugador() {}

    public Jugador(int idJugador, String nombre, int edad, Double altura, String pais) {
        listaJugadores = new ArrayList<>();
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura
                + ", listaJugadores=" + listaJugadores + "]";
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
