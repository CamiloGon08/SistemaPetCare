package com.example.petcare.model;

public class Recepcionista extends Empleado {
    private String turno;

    public Recepcionista(String cedula, String nombre, String apellido, double salario, String turno){
        super(cedula, nombre, apellido, salario);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
     @Override 
    public String getRol(){
        return "RECEPCIONISTA";
    }

    @Override
    public String toString() {
       return super.toString() + " Turno: "+ turno;
    };

}
