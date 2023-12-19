package nba;


public class Liga {
    
    private static final String RUTA_EQUIPOS="actividad2\\src\\bbddxml\\equipos.xml";
    private static final String RUTA_JUGADORES="actividad2\\src\\bbddxml\\jugadores.xml";
    private static final String RUTA_ESTADISTICAS="actividad2\\src\\bbddxml\\estadisticas.xml";
    private static final String RUTA_PARTIDOS="actividad2\\src\\bbddxml\\partidos.xml";

    public static void main(String[] args) {
        String nombreTabla="equipos";
        
        Utilidades.insertarBBDD(nombreTabla, RUTA_EQUIPOS, Equipo.class);
        

        /*for (String ruta : listadoXML){
            file= new File(ruta);
            Utilidades.leerXML(file);
            Utilidades.insertarBBDD();
        }*/

    }
    
}