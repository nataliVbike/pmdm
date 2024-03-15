package com.example.volleycondao;

public class Persona {
private String nombre;
private String apellidos;
private int edad;
private String ruta;

    public Persona(String nombre, String apellidos, int edad, String ruta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.ruta = ruta;
    }

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
