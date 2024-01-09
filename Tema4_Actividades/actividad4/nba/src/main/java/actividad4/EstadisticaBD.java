package actividad4;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstadisticaBD {
private List<Estadistica> estadisticas;

    @XmlElement(name = "estadistica")
    public List<Estadistica> getEquipos() {
        return estadisticas;
    }

    public void setEquipos(List<Estadistica> estadisticas) {
        this.estadisticas = estadisticas;
    }
}