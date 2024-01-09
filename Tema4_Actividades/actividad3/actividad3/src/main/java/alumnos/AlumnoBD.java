package alumnos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class AlumnoBD {
    public static List<Alumno> consultarAlumnos(String clase){
        String url= "jdbc:mysql://localhost:3307/alumnobd";
        String usuario= "PabloMorato";
        String password="1234";
        String sql1="Select * from alumnosAct3 where clase='"+clase+"';";
        System.out.println(sql1);
        
        List<Alumno> listado = new ArrayList<>();
            
            // Creamos conexion
            
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql1);
                
                while (resultado.next()){
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(resultado.getString("idAlumno"));
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setClase(resultado.getString("clase"));
                    listado.add(alumno);                   
                }
                con.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL");
                e.printStackTrace();
            }
            return listado;
    }
    public static void guardarEnXML(List<Alumno> listado, String clase){
        String clase2=clase.replace(" ", "");
        String archivo = "actividad3\\actividad3\\src\\"+clase2+".xml";
        
        File file=new File(archivo);
        Alumnos alumnos = new Alumnos();
            alumnos.setAlumnos(listado);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Alumnos.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(alumnos, new FileWriter(file));
            System.out.println("Archivo xml generado correctamente"); 
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }     
    }
}
