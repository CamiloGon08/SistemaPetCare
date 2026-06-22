package com.example.petcare.view;

import java.util.Scanner;

import com.example.petcare.model.Dueño;
import com.example.petcare.service.DueñoService;

public class MenuDueños {

    private Scanner scanner = new Scanner(System.in);
    private DueñoService dueñoService = new DueñoService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE DUEÑOS ===");
            System.out.println("1. Registrar Dueño");
            System.out.println("2. Listar Dueños");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarDueño(); break;
                case 2: listarDueños(); break;
                case 0: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void registrarDueño() {
        System.out.println("\n--- Registrar Dueño ---");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Dueño d = new Dueño(cedula, nombre, apellido, telefono);
        String error = dueñoService.registrar(d);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Dueño registrado exitosamente");
        }
    }

    private void listarDueños() {
        System.out.println("\n--- Lista de Dueños ---");
        for (Dueño d : dueñoService.listarTodos()) {
            System.out.println(d.toString());
        }
    }
}