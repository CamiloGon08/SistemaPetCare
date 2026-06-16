package com.example.petcare.model;

public class Gato extends Mascota implements Calculable {
    private String esInterior;
    
    public Gato(String idMascota, String nombre, String idDueño, String tipo, int edad, double peso, String esInterior){
        super(idMascota, nombre, idDueño, tipo, edad, peso);
        this.esInterior=esInterior;
    }

    public String getEsInterior() {
        return esInterior;
    }

    public void setEsInterior(String esInterior) {
        this.esInterior = esInterior;
    }

    @Override
    public double calcularDescuento(double subTotal) {
        return subTotal * 0.15;
    }

    @Override
    public String toString() {
        return super.toString()+ " De Donde es: "+ esInterior;
    };


}
