package nba;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Liga {

    public static void main(String[] args) {
        String RUTA_EQUIPOS = "actividad2\\src\\bbddxml\\equipos.xml";
        File f = new File(RUTA_EQUIPOS);
        String RUTA_JUGADORES = "actividad2\\src\\bbddxml\\jugadores.xml";
        File f2 = new File(RUTA_JUGADORES);
        String RUTA_PARTIDOS = "actividad2\\src\\bbddxml\\partidos.xml";
        File f3 = new File(RUTA_PARTIDOS);
        String RUTA_ESTADISTICAS = "actividad2\\src\\bbddxml\\estadisticas.xml";
        File f4 = new File(RUTA_ESTADISTICAS);
    try {
        JAXBContext contexto = JAXBContext.newInstance(Equipo.class);
        Unmarshaller um = contexto.createUnmarshaller();
        Equipo equipos = (Equipo) um.unmarshal(f);

        JAXBContext contexto2 = JAXBContext.newInstance(Jugador.class);
        Unmarshaller um2 = contexto2.createUnmarshaller();
        Jugador jugadores = (Jugador) um2.unmarshal(f2);

        JAXBContext contexto3 = JAXBContext.newInstance(Partido.class);
        Unmarshaller um3 = contexto3.createUnmarshaller();
        Partido partidos = (Partido) um3.unmarshal(f3);

        JAXBContext contexto4 = JAXBContext.newInstance(Estadistica.class);
        Unmarshaller um4 = contexto4.createUnmarshaller();
        Estadistica estadisticas = (Estadistica) um4.unmarshal(f4);

        List<Equipo> listaEquipos = equipos.getListaEquipos();
        EquipoBD.insertarEquipos(listaEquipos);
        List<Jugador> listaJugadores = jugadores.getListaJugadores();
        JugadorBD.insertarJugadores(listaJugadores);
        List<Partido> listaPartidos = partidos.getListaPartidos();
        PartidoBD.insertarPartidos(listaPartidos);
        List<Estadistica> listaEstadisticas = estadisticas.getListaEstadisticas();
        EstadisticaBD.insertarEstadisticas(listaEstadisticas);

    } catch (JAXBException e) {
        e.printStackTrace();
    }
}
}