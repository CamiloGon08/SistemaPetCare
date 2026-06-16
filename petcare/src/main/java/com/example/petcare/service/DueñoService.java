package com.example.petcare.service;

import com.example.petcare.dao.DueñoDAO;
import com.example.petcare.model.Dueño;
import java.util.List;

public class DueñoService {

    private DueñoDAO dueñoDAO = new DueñoDAO();

    public String registrar(Dueño dueño) {

        if (dueño.getCedula() == null) {
            return "La cédula es obligatoria";
        }

        if (dueño.getNombre() == null) {
            return "El nombre es obligatorio";
        }

        if (dueño.getTelefono() == null) {
            return "El teléfono es obligatorio";
        }

        if (dueñoDAO.buscarPorCedula(dueño.getCedula()) != null) {
            return "Ya existe un dueño con esa cédula";
        }

        dueñoDAO.guardar(dueño);
        return null;
    }

    public List<Dueño> listarTodos() {
        return dueñoDAO.listarTodos();
    }

    public Dueño buscarPorCedula(String cedula) {
        if (cedula == null) return null;
        return dueñoDAO.buscarPorCedula(cedula);
    }
}