package nba;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Utilidades {
    public static <T> List<T> leerXML(File file, Class<T> clazz) {
        List<T> listaElementos = new ArrayList<>();
        try {
            JAXBContext contexto = JAXBContext.newInstance(clazz);
            Unmarshaller um = contexto.createUnmarshaller();
            T elemento = clazz.cast(um.unmarshal(file));
            listaElementos.add(elemento);
            System.out.println("LISTA"+listaElementos);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return listaElementos;
    }

    /*public static <T extends ElementosTabla> void insertarBBDD(String nombreTabla, String ruta, Class<T> clazz) {
        String usuario = "PabloMorato";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/liganba";
        File file = new File(ruta);


        // Leer XML y convertir a objetos
        List<T> lista = leerXML(new File(ruta), clazz);

        for (T elemento : lista) {
            nombreTabla = "equipos"; 
            List<String> campos = elemento.getCampos();
            List<Object> valores = elemento.getValores();

            StringJoiner columnas = new StringJoiner(", ");
            StringJoiner valoresStr = new StringJoiner(", ", "'", "'");

            for (String campo : campos) {
                columnas.add(campo);
            }

            for (Object valor : valores) {
                if (valor != null) {
                    valoresStr.add(valor.toString());
                } else {
                    valoresStr.add("0"); // O un valor por defecto, dependiendo del contexto
                }
            }

            String sentenciaSQL = "INSERT INTO " + nombreTabla + " (" + columnas + ") VALUES (" + valoresStr + ")";
            System.out.println(sentenciaSQL);
            try {
                Connection con = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = con.createStatement();
                sentencia.executeUpdate(sentenciaSQL);
                con.close();
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL");
                e.printStackTrace();
            }
        }
    }*/
    public static <T extends ElementosTabla> void insertarBBDD(String nombreTabla, String ruta, Class<T> clazz) {
    String usuario = "PabloMorato";
    String password = "1234";
    String url = "jdbc:mysql://localhost:3307/liganba";
    File file = new File(ruta);

    // Leer XML y convertir a objetos
    List<T> lista = leerXML(file, clazz);

    try (Connection con = DriverManager.getConnection(url, usuario, password)) {
        for (T elemento : lista) {
            nombreTabla = "equipos";
            List<String> campos = elemento.getCampos();
            List<Object> valores = elemento.getValores();
            System.out.println("Valores obtenidos: " + valores);

            StringJoiner columnas = new StringJoiner(", ");
            StringJoiner valoresPlaceholder = new StringJoiner(", ");

            for (String campo : campos) {
                columnas.add(campo);
                valoresPlaceholder.add("?");
            }

            String sentenciaSQL = "INSERT INTO " + nombreTabla + " (" + columnas + ") VALUES (" + valoresPlaceholder + ")";
            System.out.println(sentenciaSQL);

            try (PreparedStatement pstmt = con.prepareStatement(sentenciaSQL)) {
                int index = 1;
                for (Object valor : valores) {
                    pstmt.setObject(index++, valor);
                }
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL");
                e.printStackTrace();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}