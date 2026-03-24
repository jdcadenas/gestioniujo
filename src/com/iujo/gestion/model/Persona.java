package com.iujo.gestion.model;

public abstract class Persona {
    protected String nombre;
    protected String cedula;
/**
 * Constructor de la clase Persona que inicializa el nombre y la cédula de la persona.
 * @param nombre
 * @param cedula
 */
    public Persona(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;   
    }
/*
    Método abstracto para mostrar el perfil de la persona. Cada subclase (Estudiante, Profesor, Administrador) implementará este método de manera diferente para mostrar su información específica.
*/
    public abstract void mostrarPerfil();

    public String getCedula(){
        return cedula;
    }

    public String getNombre(){
        return nombre;
    }
}



