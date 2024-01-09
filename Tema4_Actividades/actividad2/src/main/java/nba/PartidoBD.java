package nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PartidoBD {
    public static boolean insertarPartidos(List<Partido> listaPartidos){
        // Datos del alumno, conexión y consultas
        for (Partido pa: listaPartidos) {
            int idPartido= pa.getIdPartido();
            int equipoLocal= pa.getEquipoLocal();
            int equipoVisitante= pa.getEquipoVisitante();
            int ganador= pa.getGanador();
            
            String url= "jdbc:mysql://localhost:3307/liganba";
            String usuario= "PabloMorato";
            String password="1234";
            String sql3="INSERT INTO partidos(IdPartido, equipoLocal, equipoVisitante, ganador)"+ 
                                        " values("+idPartido+","+equipoLocal+","+equipoVisitante+","+ganador+")";
            System.out.println("ConultaSQL partidos ..."+sql3);
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sql3);
                con.close();
                System.out.println("Inserción correcta de partidos");
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL de partidos");
                e.printStackTrace();
            }
            }        
        return true;
    }
}
