package com.example.petcare.model;


public abstract class Empleado extends Persona{

    private double salario;
    private String rol;

    public Empleado(String cedula, String nombre, String apellido, double salario){
        super(cedula, nombre, apellido);
        this.salario = salario;

    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public abstract String getRol();
    
    @Override
    public String toString(){
        return super.toString() + " Salario: "+ salario;
    }



}
