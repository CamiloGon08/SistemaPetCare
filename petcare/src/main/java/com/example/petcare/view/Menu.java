package com.example.petcare.view;

import java.util.Scanner;


public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private MenuEmpleados menuEmpleados = new MenuEmpleados();
    private MenuDueños menuDueños = new MenuDueños();
    private MenuMascotas menuMascotas = new MenuMascotas();
    private MenuCitas menuCitas = new MenuCitas();
    private MenuEstadisticas menuEstadisticas = new MenuEstadisticas();

    public void mostrar(){
        int opcion;
        do { 
            System.out.println("PETCARE - SISTEMA VETERINARIO");
            System.out.println("1. GESTION DE EMPLEADOS");
            System.out.println("2. GESTION DE DUEÑOS");
            System.out.println("3. GESTION DE MASCOTAS");
            System.out.println("4. GESTION DE CITAS");
            System.out.println("5. GESTION DE ESTADISTICAS");
            System.out.println("0. SALIR");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1: menuEmpleados.mostrar();
                    break;
                case 2: menuDueños.mostrar();
                    break;
                case 3: menuMascotas.mostrar();
                    break;
                case 4:menuCitas.mostrar();
                    break;
                case 5: menuEstadisticas.mostrar();
                    break;
                case 0: System.out.println("HASTA LUEGO");
                    break;
                default: System.out.println("OPCION INVALIDA");
            }
        } while(opcion!=0);
    }
    
}
