package com.example.petcare.view;

import java.util.Scanner;

import com.example.petcare.model.Gato;
import com.example.petcare.model.Mascota;
import com.example.petcare.model.Perro;
import com.example.petcare.service.MascotaService;

public class MenuMascotas {

    private Scanner scanner = new Scanner(System.in);
    private MascotaService mascotaService = new MascotaService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE MASCOTAS ===");
            System.out.println("1. Registrar Perro");
            System.out.println("2. Registrar Gato");
            System.out.println("3. Listar Mascotas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarPerro(); break;
                case 2: registrarGato(); break;
                case 3: listarMascotas(); break;
                case 0: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void registrarPerro() {
        System.out.println("\n--- Registrar Perro ---");
        System.out.print("ID Mascota: ");
        String idMascota = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula del Dueño: ");
        String idDueño = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        Perro p = new Perro(idMascota, nombre, idDueño, "PERRO", edad, peso, raza);
        String error = mascotaService.registrar(p);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Perro registrado exitosamente");
        }
    }

    private void registrarGato() {
        System.out.println("\n--- Registrar Gato ---");
        System.out.print("ID Mascota: ");
        String idMascota = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula del Dueño: ");
        String idDueño = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("¿Es de interior? (INTERIOR/EXTERIOR): ");
        String esInterior = scanner.nextLine();

        Gato g = new Gato(idMascota, nombre, idDueño, "GATO", edad, peso, esInterior);
        String error = mascotaService.registrar(g);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Gato registrado exitosamente");
        }
    }

    private void listarMascotas() {
        System.out.println("\n--- Lista de Mascotas ---");
        for (Mascota m : mascotaService.listarTodos()) {
            System.out.println(m.toString());
        }
    }
}