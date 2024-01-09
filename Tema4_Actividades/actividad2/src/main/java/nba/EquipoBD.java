package nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EquipoBD {
    public static boolean insertarEquipos(List<Equipo> listaEquipos){
        // Datos del alumno, conexión y consultas
        for (Equipo eq: listaEquipos) {
            int idEquipo= eq.getIdEquipo();
            String nombre= eq.getNombre();
            String ciudad= eq.getCiudad();
            
            String url= "jdbc:mysql://localhost:3307/liganba";
            String usuario= "PabloMorato";
            String password="1234";
            String sql1="INSERT INTO equipos(IdEquipo, nombre, ciudad)"+ 
                                        " values("+idEquipo+",'"+nombre+"','"+ciudad+"')";
            System.out.println("ConultaSQL ..."+sql1);
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sql1);
                con.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL");
                e.printStackTrace();
            }
            }        
        return true;
    }
}
