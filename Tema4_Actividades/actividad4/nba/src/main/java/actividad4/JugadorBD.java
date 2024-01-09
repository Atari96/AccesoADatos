package actividad4;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JugadorBD {
    private List<Jugador> jugadores;

    @XmlElement(name = "jugador")
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setEquipos(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
