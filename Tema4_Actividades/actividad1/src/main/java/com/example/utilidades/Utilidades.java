package com.example.utilidades;

import javax.swing.text.Document;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

public class Utilidades {

    
    
    private Node documentXML;
    public void generarXML() throws Exception{

            Source origen= new DOMSource(documentXML);
            /*File archivoXML= new File("productos.xml");*/
            Result destino= new StreamResult("./ProyectosJava/tema5/src/main/java/baroja/lenmar/tema5/Practicas_Tema5/EjT5_1/productosXML.xml");
            TransformerFactory factoria= TransformerFactory.newInstance();
            Transformer transformer= factoria.newTransformer();
            transformer.transform(origen, destino);
        }
    public static void main(String[] args) {
        
        


    }
}
