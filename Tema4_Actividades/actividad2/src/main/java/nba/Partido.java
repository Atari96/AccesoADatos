package nba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="partidos")
@XmlAccessorType(XmlAccessType.FIELD)

public class Partido {
    @XmlElement(name="idPartido")
    private int idPartido;
    @XmlElement(name="equipoLocal")
    private int equipoLocal;
    @XmlElement(name="equipoVisitante")
    private int equipoVisitante;
    @XmlElement(name = "ganador")
    private int ganador;
    @XmlElement(name = "partido")
    private List<Partido> listaPartidos;

    public Partido() {}

    public Partido(int idPartido, int equipoLocal, int equipoVisitante, int ganador) {
        listaPartidos=new ArrayList<>();
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(int equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(int equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public List<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    @Override
    public String toString() {
        return "Partido [idPartido=" + idPartido + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
                + equipoVisitante + ", ganador=" + ganador + ", listaPartidos=" + listaPartidos + "]";
    } 
    
}
