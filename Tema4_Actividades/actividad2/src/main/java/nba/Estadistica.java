package nba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="estadisticas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Estadistica {

    @XmlElement(name="idDato")
    private int idDato;
    @XmlElement(name="idPartido")
    private int idPartido;
    @XmlElement(name="idJugador")
    private int idJugador;
    @XmlElement(name = "puntos")
    private int puntos;
    @XmlElement(name = "estadistica")
    private List<Estadistica> listaEstadisticas;

    public Estadistica() {}

    public Estadistica(int idDato, int idPartido, int idJugador, int puntos) {
        listaEstadisticas=new ArrayList<>();
    }

    public int getIdDato() {
        return idDato;
    }

    public void setIdDato(int idDato) {
        this.idDato = idDato;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Estadistica> getListaEstadisticas() {
        return listaEstadisticas;
    }

    public void setListaEstadisticas(List<Estadistica> listaEstadisticas) {
        this.listaEstadisticas = listaEstadisticas;
    }

    @Override
    public String toString() {
        return "Estadistica [idDato=" + idDato + ", idPartido=" + idPartido + ", idJugador=" + idJugador + ", puntos="
                + puntos + ", listaEstadisticas=" + listaEstadisticas + "]";
    }
}
