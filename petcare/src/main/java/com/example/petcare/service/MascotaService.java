package com.example.petcare.service;

import java.util.List;

import com.example.petcare.dao.DueñoDAO;
import com.example.petcare.dao.MascotaDAO;
import com.example.petcare.model.Mascota;

public class MascotaService {

    private MascotaDAO mascotaDAO = new MascotaDAO();
    private DueñoDAO dueñoDAO = new DueñoDAO();

    public String registrar(Mascota mascota) {

        if (mascota.getNombre() == null) {
            return "El nombre es obligatorio";
        }

        if (mascota.getEdad() <= 0) {
            return "La edad debe ser mayor a 0";
        }

        if (mascota.getPeso() <= 0) {
            return "El peso debe ser mayor a 0";
        }

        if (dueñoDAO.buscarPorCedula(mascota.getIdDueño()) == null) {
            return "El dueño no existe en el sistema";
        }

        mascotaDAO.guardar(mascota);
        return null;
    }

    public List<Mascota> listarTodos() {
        return mascotaDAO.listarTodos();
    }

    public Mascota buscarPorId(String idMascota) {
        if (idMascota == null) return null;
        return mascotaDAO.buscarPorId(idMascota);
    }
}