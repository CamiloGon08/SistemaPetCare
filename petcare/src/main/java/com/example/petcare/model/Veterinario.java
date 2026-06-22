package com.example.petcare.model;

public class Veterinario extends Empleado  {
    private String especialidad;

    public Veterinario(String cedula, String nombre, String apellido, double salario, String especialidad){
        super(cedula, nombre, apellido, salario);

        this.especialidad = especialidad;
    }

    @Override
    public String getRol(){
        return "VETERINARIO";
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;

    }

    @Override
    public String toString() {
        return super.toString()+ " Especialidad: "+ especialidad;
    };
}
