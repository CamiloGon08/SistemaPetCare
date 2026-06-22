package com.example.petcare.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.petcare.model.Gato;
import com.example.petcare.model.Mascota;
import com.example.petcare.model.Perro;

public class MascotaDAO {
    public static final String RUTA_ARCHIVO = "src/main/resources/mascotas.txt";

    public void guardar(Mascota mascota){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO,true))){
            if(mascota instanceof Perro){
                Perro p = (Perro) mascota;

                writer.write(p.getIdMascota()+";"+p.getNombre()+";"+p.getIdDueño()+";"+p.getTipo()
                            +";"+p.getEdad()+";"+p.getPeso()+";"+p.getRaza());
            }else if(mascota instanceof Gato){
                Gato g = (Gato) mascota;
                writer.write(g.getIdMascota()+";"+g.getNombre()+";"+g.getIdDueño()+";"+g.getTipo()
                            +";"+g.getEdad()+";"+g.getPeso()+";"+g.getEsInterior());
            }
            writer.newLine();
        }catch(IOException e){
            System.out.println("Error añ guardar mascota: " + e.getMessage());
        }
    }

    public List<Mascota> listarTodos(){
        List<Mascota> lista = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
            String linea;
            while((linea = reader.readLine())!=null){
                Mascota m = convertir(linea);
                if(m!=null) lista.add(m);
            }
        }catch(IOException e){
            System.out.println("Error al listar las mascotas: "+ e.getMessage());
        }
        return lista;
    }

    public Mascota buscarPorId (String idMascota){
        for(Mascota m : listarTodos()){
            if(m.getIdMascota().equals(idMascota)){
                return m;

            }
        }
        return null;
    }

    private Mascota convertir(String linea) {
        String[] partes = linea.split(";");
        String idMascota = partes[0];
        String nombre    = partes[1];
        String idDueño   = partes[2];
        String tipo      = partes[3];
        int edad         = Integer.parseInt(partes[4]);
        double peso      = Double.parseDouble(partes[5]);
        String extra     = partes[6];

        if (tipo.equals("PERRO")) {
            return new Perro(idMascota, nombre, idDueño, tipo, edad, peso, extra);
        } else {
            return new Gato(idMascota, nombre, idDueño, tipo, edad, peso, extra); // ← solo extra, sin Boolean.parseBoolean
        }
    }
}
