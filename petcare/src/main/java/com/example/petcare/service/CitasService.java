package com.example.petcare.service;

import java.util.List;

import com.example.petcare.dao.CitasDAO;
import com.example.petcare.dao.EmpleadoDAO;
import com.example.petcare.dao.MascotaDAO;
import com.example.petcare.model.Calculable;
import com.example.petcare.model.Citas;
import com.example.petcare.model.Mascota;

public class CitasService {

    private CitasDAO citasDAO = new CitasDAO();
    private MascotaDAO mascotaDAO = new MascotaDAO();
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public String registrar(Citas cita) {

        if (cita.getIdMascota() == null) {
            return "La mascota es obligatoria";
        }

        if (cita.getIdVeterinario() == null) {
            return "El veterinario es obligatorio";
        }

        if (cita.getMotivo() == null) {
            return "El motivo es obligatorio";
        }

        if (mascotaDAO.buscarPorId(cita.getIdMascota()) == null) {
            return "La mascota no existe en el sistema";
        }

        if (empleadoDAO.buscarPorCedula(cita.getIdVeterinario()) == null) {
            return "El veterinario no existe en el sistema";
        }

        Mascota mascota = mascotaDAO.buscarPorId(cita.getIdMascota());
        double descuento = 0;

        if (mascota instanceof Calculable) {
            Calculable c = (Calculable) mascota;
            descuento = c.calcularDescuento(cita.getSubTotal());
        }

        cita.setTotal(cita.getSubTotal() - descuento);

        citasDAO.guardar(cita);
        return null;
    }

    public List<Citas> listarTodos() {
        return citasDAO.listarTodos();
    }

    public List<Citas> listarPorVeterinario(String cedulaVeterinario) {
        if (cedulaVeterinario == null) return null;
        return citasDAO.buscarPorVeterinario(cedulaVeterinario);
    }

    public double calcularTotalRecaudado() {
        double total = 0;
        for (Citas c : citasDAO.listarTodos()) {
            total += c.getTotal();
        }
        return total;
    }

    public Citas obtenerCitaMasCostosa() {
        Citas masCostosa = null;
        for (Citas c : citasDAO.listarTodos()) {
            if (masCostosa == null || c.getTotal() > masCostosa.getTotal()) {
                masCostosa = c;
            }
        }
        return masCostosa;
    }
}