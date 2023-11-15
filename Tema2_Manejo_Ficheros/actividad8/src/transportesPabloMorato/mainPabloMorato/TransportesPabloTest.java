package transportesPabloMorato.mainPabloMorato;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import transportesPabloMorato.pojoPablo.Empleado;
import transportesPabloMorato.pojoPablo.Localidad;

public class TransportesPabloTest {

    private static Scanner sc;
    private static String rutaEmpleadoXML="/xmlPabloMorato";
    private static String rutaLocalidadXML="/xmlPabloMorato";
    private static String rutaProvinciaXML="/xmlPabloMorato";
    private static String rutaRegionXML="/xmlPabloMorato";
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        List<Empleado> listadoEmpleados=new ArrayList<Empleado>();

        String menu = "TRANSPORTES MORATO: \n"+
                        "===================\n"+
                        "1.- Listar todos los empleados\n"+
                        "2.- Listar todo\n"+
                        "3.- Insertar nuevo empleado\n"+
                        "4.- Insertar nueva localidad\n"+
                        "5.- Borrar empleado\n"+
                        "6.- Mostrar empleado más antiguo\n"+
                        "7.- Mostrar empleado que gana mas dinero\n"+
                        "8.- Salir\n";

        // Inicio y gestión de la aplicacion
        int opcion = 0;
        while (opcion !=8){
            System.out.println(menu);
            System.out.println("Introduce una opción");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce una opción correcta\n");
            }           
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Listar todos los empleados");
                    listarEmpleadosDesdeXML(rutaEmpleadoXML);
                    break;
                case 2:
                    System.out.println("Listar todo");
                    listarEmpleadosDesdeXML(rutaEmpleadoXML);
                    listarLocalidadesDesdeXML(rutaLocalidadXML);
                    listarProvinciasDesdeXML(rutaProvinciaXML);
                    listarRegionesDesdeXML(rutaRegionXML);
                    break;
                case 3:
                    System.out.println("Alta nuevo empleado");
                    System.out.println("Introduce el nombre del empleado");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce el dni del empleado");
                    String dni = sc.next();
                    System.out.println("Introduce la fecha de nacimiento (dd-mm-aaaa)");
                    String fechaNac = sc.next();
                    System.out.println("Introduce el telefono");
                    String telefono = sc.next();
                    System.out.println("Introduce el salario");
                    double salario = sc.nextDouble();
                    Empleado empleado = new Empleado(nombre, dni, fechaNac, telefono, salario);
                    listadoEmpleados.add(empleado);
                    System.out.println("Nuevo empledo creado: "+empleado.toString());
                    break;
                case 4:
                    System.out.println("Insertar nueva localidad");
                    System.out.println("Introduce la localidad nueva");
                    String localidad=sc.nextLine();
                    Localidad localidad1 = new Localidad(localidad);
                    Document document = cargarDocumentoXML(rutaLocalidadXML);
                    if (document != null) {                       
                        agregarLocalidad(document, localidad1);
                        guardarDocumentoXML(document, "xmlPabloMorato/localidad.xml");
                    } else {
                        System.out.println("Error al cargar el documento XML.");
                    }
                    break;
                case 5:
                    System.out.println("Borrar empleado");
                    System.out.println("Introduce el dni del empleado");
                    dni=sc.next();
                    break;
                case 6:
                    System.out.println("El empleado más antiguo es: ");
                    break;
                case 7:
                    System.out.println("El empleado que más gana es: ");
                    break;
                default:
                    System.out.println("Opción incorrecta, pruebe de nuevo");
            }      
        }
    }
    private static void listarEmpleadosDesdeXML(String ruta) {
        Document documento = cargarDocumentoXML(ruta);

        if (documento != null) {
            NodeList empleados = documento.getElementsByTagName("empleado");

            System.out.println("Lista de empleados:");

            for (int i = 0; i < empleados.getLength(); i++) {
                Node empleadoNode = empleados.item(i);

                if (empleadoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element empleadoElement = (Element) empleadoNode;
                    String nombre = empleadoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String dni = empleadoElement.getElementsByTagName("dni").item(0).getTextContent();
                    System.out.println("Nombre: " + nombre + ", DNI: " + dni);
                }
            }
        } else {
            System.out.println("Error al cargar el documento XML.");
        }
    }

    private static void listarLocalidadesDesdeXML(String ruta) {
        Document documento = cargarDocumentoXML(rutaLocalidadXML);
        if (documento != null) {
            NodeList localidades = documento.getElementsByTagName("localidad");

            System.out.println("Lista de localidades:");

            for (int i = 0; i < localidades.getLength(); i++) {
                Node localidadNode = localidades.item(i);

                if (localidadNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element localidadElement = (Element) localidadNode;
                    String codLocalidad = localidadElement.getElementsByTagName("Código localidad").item(0).getTextContent();
                    String nombre = localidadElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    System.out.println("Código localidad"+codLocalidad+"Nombre: " + nombre );
                }
            }
        } else {
            System.out.println("Error al cargar el documento XML.");
        }
    }

    private static void listarProvinciasDesdeXML(String ruta) {
        Document documento = cargarDocumentoXML(rutaProvinciaXML);
        if (documento != null) {
            NodeList provincias = documento.getElementsByTagName("provincia");

            System.out.println("Lista de provincias:");

            for (int i = 0; i < provincias.getLength(); i++) {
                Node provinciaNode = provincias.item(i);

                if (provinciaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element localidadElement = (Element) provinciaNode;
                    String codLocalidad = localidadElement.getElementsByTagName("Código provincia").item(0).getTextContent();
                    String nombre = localidadElement.getElementsByTagName("Nombre").item(0).getTextContent();
                    System.out.println("Código provincia"+codLocalidad+"Nombre: " + nombre );
                }
            }
        } else {
            System.out.println("Error al cargar el documento XML.");
        }
    }

    private static void listarRegionesDesdeXML(String ruta) {
        Document documento = cargarDocumentoXML(rutaRegionXML);
        if (documento != null) {
            NodeList regiones = documento.getElementsByTagName("region");

            System.out.println("Lista de provincias:");

            for (int i = 0; i < regiones.getLength(); i++) {
                Node regionNode = regiones.item(i);
                           
                if (regionNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element regionElement = (Element) regionNode;
                    String codRegion = regionElement.getElementsByTagName("Código region").item(0).getTextContent();
                    String nombre = regionElement.getElementsByTagName("nombre").item(0).getTextContent();
                    System.out.println("Código región"+codRegion+"Nombre: " + nombre );
                }
            }
        } else {
            System.out.println("Error al cargar el documento XML.");
        }
    }

    private static Document cargarDocumentoXML(String ruta) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(new File(ruta));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void agregarLocalidad(Document documento, Localidad localidad) {
        // Obtener el elemento raíz del documento
        Element rootElement = documento.getDocumentElement();
    
        // Crear un nuevo elemento para la localidad
        Element nuevaLocalidadElement = documento.createElement("localidad");
    
        // Crear un elemento para el nombre de la localidad
        Element nombreElement = documento.createElement("nombre");
        nombreElement.appendChild(documento.createTextNode(localidad.getNombre()));
        nuevaLocalidadElement.appendChild(nombreElement);
    
        // Agregar la nueva localidad al elemento raíz
        rootElement.appendChild(nuevaLocalidadElement);
    }

    private static void guardarDocumentoXML(Document documento, String ruta) {
    try {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(documento);
        StreamResult result = new StreamResult(new File(ruta));

        transformer.transform(source, result);
    } catch (TransformerException e) {
        e.printStackTrace();
    }
}
}
