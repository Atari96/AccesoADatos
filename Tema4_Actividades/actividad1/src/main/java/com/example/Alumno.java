package com.example;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "alumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {
    
    // Definición de variables
    @XmlAttribute(required = true)
    private String id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "edad")
    private int edad;

    @XmlElement(name = "telefono")
    private String telefono;

    @XmlElement(name = "alumno")
    private List<Alumno> listaAlumnos;

    public Alumno(){}

    public Alumno(String id, String nombre, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono
                + ", listaAlumnos=" + listaAlumnos + "]";
    }

    
}