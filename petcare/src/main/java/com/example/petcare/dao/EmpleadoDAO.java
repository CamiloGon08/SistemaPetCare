package com.example.petcare.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.petcare.model.Empleado;
import com.example.petcare.model.Recepcionista;
import com.example.petcare.model.Veterinario;

public class EmpleadoDAO {
    public static final String RUTA_ARCHIVO = "src/main/resources/empleados.txt";

    public void guardar(Empleado empleado){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO,true))){

            if(empleado instanceof Veterinario){
               Veterinario v = (Veterinario) empleado;

                writer.write(v.getCedula()+ ";" + v.getNombre() + ";" +
                            v.getApellido()+ ";" + v.getSalario()+";"+ v.getRol()+";"+v.getEspecialidad());
            }else if (empleado instanceof Recepcionista){
                Recepcionista r = (Recepcionista) empleado;
                writer.write(r.getCedula()+";"+r.getNombre()+";"+r.getApellido()+";"+
                            r.getSalario()+";"+r.getRol()+";"+r.getTurno()
                );
            }
            writer.newLine();
        }catch(IOException e){
            System.out.println("Error al guardar el empleado: "+ e.getMessage());
        }
    }

    public List<Empleado> listarTodos(){
        List<Empleado> lista = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
            String linea;
            while((linea = reader.readLine()) !=null){
                Empleado e = convertir(linea);
                if(e!=null) lista.add(e);
            }
        }catch(IOException e){
            System.out.println("Error al listar empleado: "+ e.getMessage());
        }
        return lista;
    }

    public Empleado buscarPorCedula(String cedula){
        for(Empleado e : listarTodos()){
            if(e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }

    private Empleado convertir(String linea){

        String[] partes = linea.split(";");
        String cedula = partes[0];
        String nombre = partes[1];
        String apellido = partes[2];
        double salario = Double.parseDouble(partes[3]);
        String rol = partes[4];
        String extra = partes[5];

        if(rol.equals("VETERINARIO")){
            return new Veterinario(cedula, nombre, apellido, salario, extra);
        }else{
            return new Recepcionista(cedula, nombre, apellido, salario, extra);
        }
    }

    
}
