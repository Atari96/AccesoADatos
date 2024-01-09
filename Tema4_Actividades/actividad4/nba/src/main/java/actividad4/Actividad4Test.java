package actividad4;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Actividad4Test {
    private static Scanner sc;
    public static void main(String[] args) {
        sc= new Scanner(System.in);
        String nba =    " ___       _   _______   _______\n"+
                        "|   \\     | | |  ___  \\ |  ___  \\\n"+
                        "| |\\ \\    | | | |   | | | |   | |\n"+
                        "| | \\ \\   | | | |___|/  | |___| |\n"+
                        "| |  \\ \\  | | |  ___ \\  |  ___  |\n"+
                        "| |   \\ \\ | | | |   | | | |   | |\n"+
                        "| |    \\ \\| | | |___| | | |   | |\n"+
                        "|_|     \\___| |______/  |_|   |_|\n";
        String menu = "MENU APLICACION NBA\n"+
                    "Indica la tabla que deseas consultar:\n"+
                    "1.- Tabla estadísticas\n"+
                    "2.- Tabla partidos\n"+
                    "3.- Tabla jugadores\n"+
                    "4.- Tabla equipos\n"+
                    "5.- Salir\n"+
                    "Introduce el número de la opción";
        int opcion=0;
        while (opcion !=5){
            System.out.println(nba);
            System.out.println(menu);
            try {            
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Consulta estadisticas");
                        String sql="Select * from estadisticas;";
                        String tabla="estadisticas";
                        mostrarResultSet(extraerTabla(sql), tabla);
                        break;
                    case 2:
                        System.out.println("Consulta partidos");
                        String sql2="Select * from partidos;";
                        String tabla2="partidos";
                        mostrarResultSet(extraerTabla(sql2), tabla2);
                        break;
                    case 3:
                        System.out.println("Consulta jugadores");
                        String sql3="Select * from jugadores;";
                        String tabla3="jugadores";
                        mostrarResultSet(extraerTabla(sql3), tabla3);
                        break;
                    case 4:
                        System.out.println("Consulta equipos");
                        String sql4="Select * from equipos;";
                        String tabla4="equipos";
                        mostrarResultSet(extraerTabla(sql4), tabla4);
                        break;
                    case 5:
                    System.out.println("Fin de la aplicación.");
                        break;
                    default:
                        System.out.println("La opción elegida es incorrecta");
                        break;
                }
                } catch (InputMismatchException e) {
                    System.out.println("Debes elegir un número entre 1 y 5");
                    sc.next(); // Importante, para limpiar el buffer y que no se produzca un bucle
                }           
        }       
    }
    public static ResultSet extraerTabla(String sql){
        // Datos conexion
        String usuario= "PabloMorato";
        String password= "1234";
        String url="jdbc:mysql://localhost:3307/nba";
        //Conexion
        Connection con;
        try {
            con = DriverManager.getConnection(url, usuario, password);
            Statement sentencia=con.createStatement();
            ResultSet resultado=sentencia.executeQuery(sql);
            return resultado;            
        } catch (SQLException e) {
            e.printStackTrace();
            return null; 
        }     
    }
    public static void mostrarResultSet(ResultSet resultado, String tabla){
        switch(tabla){
            case "estadisticas":
                Estadistica estadistica=new Estadistica();
                List<Estadistica> listadoEstadisticas = new ArrayList<>();
                try {
                    while(resultado.next()){                        
                        estadistica.setTemporada(resultado.getString("temporada"));
                        estadistica.setJugador(resultado.getInt("jugador"));
                        float asistencias=Float.parseFloat(resultado.getString("Asistencias_por_partido"));
                        float tapones=Float.parseFloat(resultado.getString("Tapones_por_partido"));
                        float rebotes=Float.parseFloat(resultado.getString("Rebotes_por_partido"));
                        estadistica.setAsistencias(asistencias);
                        estadistica.setTapones(tapones);
                        estadistica.setRebotes(rebotes);
                        listadoEstadisticas.add(estadistica);
                        System.out.println(estadistica);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }    
                System.out.println("¿Quieres guardar la tabla en un archivo XML? (S/N)");  
                String guardar=sc.next().toUpperCase();
                if (guardar.equals("S")){
                    guardarEstadisticaEnXML(tabla, listadoEstadisticas);
                    System.out.println("Información guardada en xml");
                }    
                else {
                    System.out.println("La información no se ha guardado");
                }         
                break;
            case "partidos":
                Partido partido = new Partido();
                List<Partido> listadoPartidos = new ArrayList<>();
                try {
                    while(resultado.next()){
                        partido.setCodigo(resultado.getInt("codigo"));
                        partido.setEquipo_local(resultado.getString("equipo_local"));
                        partido.setEquipo_visitante(resultado.getString("equipo_visitante"));
                        partido.setPuntos_local(resultado.getInt("puntos_local"));
                        partido.setPuntos_visitante(resultado.getInt("puntos_visitante"));
                        partido.setTemporada(resultado.getString("temporada"));
                        listadoPartidos.add(partido);
                        System.out.println(partido);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }  
                System.out.println("¿Quieres guardar la tabla en un archivo XML? (S/N)");  
                guardar=sc.next().toUpperCase();
                if (guardar.equals("S")){
                    guardarPartidoEnXML(tabla, listadoPartidos);
                    System.out.println("Información guardada en xml");
                }    
                else {
                    System.out.println("La información no se ha guardado");
                }           
                break;
            case "jugadores":
                Jugador jugador = new Jugador();
                List<Jugador> listadoJugadores = new ArrayList<>();
                try {
                    while(resultado.next()){
                        jugador.setCodigo(resultado.getInt("codigo"));
                        jugador.setNombre(resultado.getString("Nombre"));
                        jugador.setProcedencia(resultado.getString("Procedencia"));
                        jugador.setAltura(resultado.getString("Altura"));
                        jugador.setPeso(resultado.getInt("Peso"));
                        jugador.setPosicion(resultado.getString("Posicion"));
                        jugador.setNombre_equipo(resultado.getString("Nombre_equipo"));
                        listadoJugadores.add(jugador);
                        System.out.println(jugador);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }      
                System.out.println("¿Quieres guardar la tabla en un archivo XML? (S/N)");  
                guardar=sc.next().toUpperCase();
                if (guardar.equals("S")){
                    guardarJugadorEnXML(tabla, listadoJugadores);
                    System.out.println("Información guardada en xml");
                }    
                else {
                    System.out.println("La información no se ha guardado");
                }       
                break;
            case "equipos":
                Equipo equipo = new Equipo();
                List<Equipo> listadoEquipos = new ArrayList<>();
                try {
                    while(resultado.next()){
                        equipo.setNombre(resultado.getString("Nombre"));
                        equipo.setCiudad(resultado.getString("Ciudad"));
                        equipo.setConferencia(resultado.getString("Conferencia"));
                        equipo.setDivision(resultado.getString("Division"));
                        listadoEquipos.add(equipo);
                        System.out.println(equipo);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }   
                System.out.println("¿Quieres guardar la tabla en un archivo XML? (S/N)");  
                guardar=sc.next().toUpperCase();
                if (guardar.equals("S")){
                    guardarEquipoEnXML(tabla, listadoEquipos);
                    System.out.println("Información guardada en xml");
                }    
                else {
                    System.out.println("La información no se ha guardado");
                }    
                break;
        }
    }
    public static void guardarEquipoEnXML(String tabla, List<Equipo> listado) {
        String ruta = "actividad4\\nba\\src\\main\\resources\\" + tabla + ".xml";
        File file = new File(ruta);     
                try {
                    EquipoBD equipoBD = new EquipoBD();
                    equipoBD.setEquipos(listado);   
                    JAXBContext contexto = JAXBContext.newInstance(EquipoBD.class);
                    Marshaller mars = contexto.createMarshaller();
                    mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                    
                    mars.marshal(equipoBD, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }        
    }
    public static void guardarEstadisticaEnXML(String tabla, List<Estadistica> listado) {
        String ruta = "actividad4\\nba\\src\\main\\resources\\" + tabla + ".xml";
        File file = new File(ruta);      
                try {
                    EstadisticaBD estadisticaBD = new EstadisticaBD();
                    estadisticaBD.setEquipos(listado);    
                    JAXBContext contexto = JAXBContext.newInstance(EstadisticaBD.class);
                    Marshaller mars = contexto.createMarshaller();
                    mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                    
                    mars.marshal(estadisticaBD, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }   
    }
    public static void guardarJugadorEnXML(String tabla, List<Jugador> listado) {
        String ruta = "actividad4\\nba\\src\\main\\resources\\" + tabla + ".xml";
        File file = new File(ruta);      
                try {
                    JugadorBD jugadorBD = new JugadorBD();
                    jugadorBD.setEquipos(listado);    
                    JAXBContext contexto = JAXBContext.newInstance(JugadorBD.class);
                    Marshaller mars = contexto.createMarshaller();
                    mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                    
                    mars.marshal(jugadorBD, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }   
    }
    public static void guardarPartidoEnXML(String tabla, List<Partido> listado) {
        String ruta = "actividad4\\nba\\src\\main\\resources\\" + tabla + ".xml";
        File file = new File(ruta);      
                try {
                    PartidoBD partidoBD = new PartidoBD();
                    partidoBD.setPartidos(listado);    
                    JAXBContext contexto = JAXBContext.newInstance(PartidoBD.class);
                    Marshaller mars = contexto.createMarshaller();
                    mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                    
                    mars.marshal(partidoBD, file);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }   
    }
}