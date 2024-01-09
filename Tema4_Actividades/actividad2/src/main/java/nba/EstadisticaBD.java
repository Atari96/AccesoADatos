package nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EstadisticaBD {
    public static boolean insertarEstadisticas(List<Estadistica> listaEstadistica){
        // Datos del alumno, conexión y consultas
        for (Estadistica es: listaEstadistica) {
            int idDato= es.getIdDato();
            int idPartido= es.getIdPartido();
            int idJugador= es.getIdJugador();
            int puntos= es.getPuntos();
            
            String url= "jdbc:mysql://localhost:3307/liganba";
            String usuario= "PabloMorato";
            String password="1234";
            String sql4="INSERT INTO estadisticas(IdDato, IdPartido, IdJugador, puntos)"+ 
                                        " values("+idDato+","+idPartido+","+idJugador+","+puntos+")";
            System.out.println("ConultaSQL estadisticas ..."+sql4);
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sql4);
                con.close();
                System.out.println("Inserción correcta de estadisticas");
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL de estadisticas");
                e.printStackTrace();
            }
            }        
        return true;
    }
}
