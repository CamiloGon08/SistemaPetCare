package com.example.petcare.model;

public abstract class Persona {
    private  String cedula;
    private  String nombre;
    private String apellido;

    public Persona(String apellido, String cedula, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula(){
        return cedula;
    }
    public void setCedula( String cedula){
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return " Cedula: "+ cedula + " Nombre: "+ nombre+ " Apellido: " + apellido;
    };



}
