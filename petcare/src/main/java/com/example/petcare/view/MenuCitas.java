package com.example.petcare.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.example.petcare.model.Citas;
import com.example.petcare.service.CitasService;

public class MenuCitas {

    private Scanner scanner = new Scanner(System.in);
    private CitasService citasService = new CitasService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CITAS ===");
            System.out.println("1. Agendar Cita");
            System.out.println("2. Listar Citas por Veterinario");
            System.out.println("3. Listar Todas las Citas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: agendarCita(); break;
                case 2: listarPorVeterinario(); break;
                case 3: listarTodas(); break;
                case 0: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void agendarCita() {
        System.out.println("\n--- Agendar Cita ---");
        System.out.print("ID Cita: ");
        String idCita = scanner.nextLine();
        System.out.print("ID Mascota: ");
        String idMascota = scanner.nextLine();
        System.out.print("Cédula Veterinario: ");
        String idVeterinario = scanner.nextLine();
        System.out.print("Cédula Dueño: ");
        String idDueño = scanner.nextLine();
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Costo base: ");
        double subTotal = scanner.nextDouble();
        scanner.nextLine();

        Citas cita = new Citas(LocalDate.now(), idCita, idDueño, idMascota,
                               idVeterinario, subTotal, 0, motivo);
        String error = citasService.registrar(cita);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Cita agendada exitosamente");
        }
    }

    private void listarPorVeterinario() {
        System.out.print("Cédula del veterinario: ");
        String cedula = scanner.nextLine();
        System.out.println("\n--- Citas del Veterinario ---");
        for (Citas c : citasService.listarPorVeterinario(cedula)) {
            System.out.println(c.toString());
        }
    }

    private void listarTodas() {
        System.out.println("\n--- Todas las Citas ---");
        for (Citas c : citasService.listarTodos()) {
            System.out.println(c.toString());
        }
    }
}