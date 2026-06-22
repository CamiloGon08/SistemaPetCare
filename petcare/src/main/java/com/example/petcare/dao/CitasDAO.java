package com.example.petcare.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.petcare.model.Citas;

public class CitasDAO {

    private static final String RUTA_ARCHIVO = "src/main/resources/citas.txt";

    public void guardar(Citas cita) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            writer.write(cita.getIdCita() + ";" +
                        cita.getFecha() + ";" +
                        cita.getIdMascota() + ";" +
                        cita.getIdVeterinario() + ";" +
                        cita.getIdDueño() + ";" +
                        cita.getMotivo() + ";" +
                        cita.getSubTotal() + ";" +
                        cita.getTotal());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar cita: " + e.getMessage());
        }
    }

    public List<Citas> listarTodos() {
        List<Citas> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Citas c = convertir(linea);
                if (c != null) lista.add(c);
            }
        } catch (IOException e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
        return lista;
    }

    public Citas buscarPorId(String idCita) {
        for (Citas c : listarTodos()) {
            if (c.getIdCita().equals(idCita)) {
                return c;
            }
        }
        return null;
    }

    public List<Citas> buscarPorVeterinario(String cedulaVeterinario) {
        List<Citas> lista = new ArrayList<>();
        for (Citas c : listarTodos()) {
            if (c.getIdVeterinario().equals(cedulaVeterinario)) {
                lista.add(c);
            }
        }
        return lista;
    }

    private Citas convertir(String linea) {
        String[] partes = linea.split(";");
        String idCita        = partes[0];
        LocalDate fecha      = LocalDate.parse(partes[1]);
        String idMascota     = partes[2];
        String idVeterinario = partes[3];
        String idDueño       = partes[4];
        String motivo        = partes[5];
        double subTotal      = Double.parseDouble(partes[6]);
        double total         = Double.parseDouble(partes[7]);

        return new Citas(fecha, idCita, idDueño, idMascota, idVeterinario, subTotal, total, motivo);
    }
}