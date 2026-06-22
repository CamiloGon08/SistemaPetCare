package com.example.petcare.model;

public class Dueño extends Persona {
    private String telefono;

    public Dueño(String cedula, String nombre, String apellido, String telefono){
        super(cedula, nombre, apellido);

        this.telefono=telefono;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return super.toString() + " Telefono: " + telefono;
    };

}
