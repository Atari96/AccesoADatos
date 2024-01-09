package actividad4;

@XmlRootElement
public class Estadistica {
    private String temporada;
    private int jugador;
    private float puntos;
    private float asistencias;
    private float tapones;
    private float rebotes;

    public Estadistica(){}

    public Estadistica(String temporada, int jugador, float puntos, float asistencias, float tapones, float rebotes) {
        this.temporada = temporada;
        this.jugador = jugador;
        this.puntos = puntos;
        this.asistencias = asistencias;
        this.tapones = tapones;
        this.rebotes = rebotes;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public float getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(float asistencias) {
        this.asistencias = asistencias;
    }

    public float getTapones() {
        return tapones;
    }

    public void setTapones(float tapones) {
        this.tapones = tapones;
    }

    public float getRebotes() {
        return rebotes;
    }

    public void setRebotes(float rebotes) {
        this.rebotes = rebotes;
    }

    @Override
    public String toString() {
        return "Estadistica: temporada=" + temporada + ", jugador=" + jugador + ", puntos=" + puntos + ", asistencias="
                + asistencias + ", tapones=" + tapones + ", rebotes=" + rebotes;
    }

}
