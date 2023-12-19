package com.example;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Instituto {

    public static void main(String[] args) {
        // Datos de archivo xml a leer
        String rutaXML = "src\\bbdd\\alumnos.xml";
        File f = new File(rutaXML);
        try {
            // Extraemos la informacion del xml y construcción de lista de alumnos
            JAXBContext contexto = JAXBContext.newInstance(Alumno.class); 
            Unmarshaller um = contexto.createUnmarshaller();
            Alumno alumnos = (Alumno) um.unmarshal(f); 
            List<Alumno> listaAlumnos = alumnos.getListaAlumnos();
            
            // Introducir en la base de datos la lista de los alumnos
            AlumnoBD.insertarAlumnos(listaAlumnos);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}