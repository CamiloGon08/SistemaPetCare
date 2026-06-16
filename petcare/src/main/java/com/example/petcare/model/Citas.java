package com.example.petcare.model;

import java.time.LocalDate;

public class Citas {
    private String idCita;
    private String idDueño;
    private String idVeterinario;
    private String idMascota;
    private double subTotal;
    private double total;
    private LocalDate fecha;
    private String motivo;

    public Citas(LocalDate fecha, String idCita, String idDueño, String idMascota, String idVeterinario, double subTotal, double total, String motivo) {
        this.fecha = fecha;
        this.idCita = idCita;
        this.idDueño = idDueño;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.subTotal = subTotal;
        this.total = total;
        this.motivo=motivo;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(String idDueño) {
        this.idDueño = idDueño;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo(){
        return motivo;
    }

    public void setMotivo(String motivo){
        this.motivo=motivo;
    }

    @Override
    public String toString() {
        return "ID Cita: "+ idCita + " ID Dueño: "+ idDueño + " ID Veterinario: "+ idVeterinario 
        + " ID Mascota: " + idMascota + " Fecha: "+ fecha + " SubTotal: "+ subTotal + "Total: "
        + total;
    };
}
