package nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JugadorBD {
    public static boolean insertarJugadores(List<Jugador> listaJugadores){
        // Datos del alumno, conexión y consultas
        for (Jugador ju: listaJugadores) {
            int idJugador= ju.getIdJugador();
            String nombre= ju.getNombre();
            int edad= ju.getEdad();
            Double altura= ju.getAltura();
            String pais=ju.getPais();
            
            String url= "jdbc:mysql://localhost:3307/liganba";
            String usuario= "PabloMorato";
            String password="1234";
            String sql2="INSERT INTO jugadores(IdJugador, nombre, edad, altura, pais)"+ 
                                        " values("+idJugador+",'"+nombre+"',"+edad+","+altura+",'"+pais+"')";
            System.out.println("ConultaSQL jugadores ..."+sql2);
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sql2);
                con.close();
                System.out.println("Inserción correcta de jugadores");
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL de jugadores");
                e.printStackTrace();
            }
            }        
        return true;
    }
}
