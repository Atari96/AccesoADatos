package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AlumnoBD {
    

    public AlumnoBD(){}

    public static boolean insertarAlumnos(List<Alumno> listaAlumnos){
        // Datos del alumno, conexión y consultas
        for (Alumno alumno : listaAlumnos) {
            String id= alumno.getId();
            String nombre= alumno.getNombre();
            int edad= alumno.getEdad();
            String telefono= alumno.getTelefono();
            String url= "jdbc:mysql://localhost:3307/alumnobd";
            String usuario= "PabloMorato";
            String password="1234";
            String sql1="INSERT INTO alumnos(IdAlumno, NombreAlumno, EdadAlumno, TelefonoAlumno)"+ 
                                        " values("+id+",'"+nombre+"',"+edad+",'"+telefono+"')";
            System.out.println(sql1);
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sql1);
                con.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL");
            }
            }        
        return true;
    }
    
    
}

