package com.example.petcare.view;

import java.util.Scanner;

import com.example.petcare.model.Citas;
import com.example.petcare.service.CitasService;

public class MenuEstadisticas {

    private Scanner scanner = new Scanner(System.in);
    private CitasService citasService = new CitasService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== ESTADÍSTICAS ===");
            System.out.println("1. Total recaudado");
            System.out.println("2. Cita más costosa");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: mostrarTotalRecaudado(); break;
                case 2: mostrarCitaMasCostosa(); break;
                case 0: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void mostrarTotalRecaudado() {
        double total = citasService.calcularTotalRecaudado();
        System.out.println("Total recaudado: $" + total);
    }

    private void mostrarCitaMasCostosa() {
        Citas c = citasService.obtenerCitaMasCostosa();
        if (c == null) {
            System.out.println("No hay citas registradas");
        } else {
            System.out.println("Cita más costosa: " + c.toString());
        }
    }
}