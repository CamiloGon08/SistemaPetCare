package com.example.petcare.view;

import java.util.Scanner;

import com.example.petcare.model.Empleado;
import com.example.petcare.model.Recepcionista;
import com.example.petcare.model.Veterinario;
import com.example.petcare.service.EmpleadoService;

public class MenuEmpleados {

    private Scanner scanner = new Scanner(System.in);
    private EmpleadoService empleadoService = new EmpleadoService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Registrar Veterinario");
            System.out.println("2. Registrar Recepcionista");
            System.out.println("3. Listar Empleados");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarVeterinario(); break;
                case 2: registrarRecepcionista(); break;
                case 3: listarEmpleados(); break;
                case 0: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void registrarVeterinario() {
        System.out.println("\n--- Registrar Veterinario ---");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        Veterinario v = new Veterinario(cedula, nombre, apellido, salario, especialidad);
        String error = empleadoService.registrar(v);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Veterinario registrado exitosamente");
        }
    }

    private void registrarRecepcionista() {
        System.out.println("\n--- Registrar Recepcionista ---");
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Turno (MAÑANA/TARDE): ");
        String turno = scanner.nextLine();

        Recepcionista r = new Recepcionista(cedula, nombre, apellido, salario, turno);
        String error = empleadoService.registrar(r);

        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            System.out.println("Recepcionista registrado exitosamente");
        }
    }

    private void listarEmpleados() {
        System.out.println("\n--- Lista de Empleados ---");
        for (Empleado e : empleadoService.listarTodos()) {
            System.out.println(e.toString());
        }
    }
}