package com.example.petcare.service;

import java.util.List;

import com.example.petcare.dao.EmpleadoDAO;
import com.example.petcare.model.Empleado;

public class EmpleadoService {

    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public String registrar(Empleado empleado){
        if(empleado.getCedula()==null){
            return "La cedula es obligatoria";
        }

        if(empleado.getNombre()== null){
            return "El nombre es obligatorio";
        }

        if(empleado.getApellido()==null){
            return "El apellido es obligatorio";
        }

        if(empleado.getSalario()<=0){
            return "El salario debe ser mayor a 0";
        }

        if(empleadoDAO.buscarPorCedula(empleado.getCedula())!=null){
            return "Ya existe un empleado con esa cedula";
        }

        empleadoDAO.guardar(empleado);
        return null;

        
    }

    public List<Empleado> listarTodos(){
        return empleadoDAO.listarTodos();
    }

    public Empleado buscarPorCedula(String cedula){
        if(cedula==null) return null;
        return empleadoDAO.buscarPorCedula(cedula);
    }
}
