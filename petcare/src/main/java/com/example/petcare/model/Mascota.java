package com.example.petcare.model;

public abstract class Mascota  {
    private String idMascota;
    private String nombre;
    private String idDueño;
    private String tipo;
    private int edad;
    private double peso;

    public Mascota(String idMascota, String nombre, String idDueño, String tipo, int edad, double peso){
        this.idMascota=idMascota;
        this.nombre = nombre;
        this.idDueño = idDueño;
        this.tipo=tipo;
        this.edad=edad;
        this.peso=peso;
    }  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(String idDueño) {
        this.idDueño = idDueño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIdMascota(){
        return idMascota;
    }

    public void setIdMascota(String idMascota){
        this.idMascota=idMascota;
    }

    @Override
    public String toString() {
        return "ID mascota: " + idMascota + "Nombre: "+ 
        nombre +" cedula Dueño: "+ idDueño +
        "Tipo: "+ tipo +"Edad: "+ edad +"Peso: "+ peso;
    };

}
