package com.example.petcare.model;

public class Perro extends Mascota implements Calculable {
    private String raza;

    public Perro(String idMascota, String nombre, String idDueño, String tipo, int edad, double peso, String raza){
        super(idMascota,nombre, idDueño, tipo, edad, peso);
        this.raza=raza;
    } 

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public double calcularDescuento(double subTotal) {
        return subTotal * 0.10;
    }

    @Override
    public String toString() {
        return super.toString()+ " Raza: "+ raza;
    };

}
