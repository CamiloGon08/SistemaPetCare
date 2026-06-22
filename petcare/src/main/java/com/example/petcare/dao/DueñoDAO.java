package com.example.petcare.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.petcare.model.Dueño;



public class DueñoDAO {
    public static final String RUTA_ARCHIVO = "src/main/resources/duenos.txt";

    public void guardar(Dueño dueño) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))){

            writer.write(dueño.getCedula() + ";" + dueño.getNombre()+";"+
                        dueño.getApellido() + ";" + dueño.getTelefono());
            writer.newLine();
        }catch(IOException e){
            System.out.println("Error al guardar dueño: " + e.getMessage());
        }

    }

    public List<Dueño> listarTodos(){
        List<Dueño> lista = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
            String linea;
            while((linea=reader.readLine())!=null){
                Dueño d = convertir(linea);
                if (d!=null) lista.add(d);
            }
        }catch(IOException e){
            System.out.println("Error al listar dueño: " + e.getMessage());
        }
        return lista;
    }

    public Dueño buscarPorCedula(String cedula){
        for (Dueño d : listarTodos()){
            if(d.getCedula().equals(cedula)){
                return d;
            }
        }
        return null;
    }

    private Dueño convertir(String linea){
        String[] partes = linea.split(";");
        String cedula = partes[0];
        String nombre = partes[1];
        String apellido = partes[2];
        String telefono = partes[3];
        return new Dueño(cedula, nombre, apellido, telefono);
    }
}
