package com.mauridemasi.aluraexchange.menu;

import com.mauridemasi.aluraexchange.funcionalidades.CalculaConversion;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        System.out.println("*****************************************************");
        System.out.println("Sea bienvenido/a al conversor de moneda =]");
        System.out.println("");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opcion valida: ");
        System.out.println("*****************************************************");
    }
    public void seleccionarOpcion(Scanner scanner, CalculaConversion conversion) {
        int opcion = scanner.nextInt();
        while (opcion > 0 || opcion < 8) {
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    double amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionADol(amount, "USD", "ARS"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionAOtraMoneda(amount, "ARS", "USD"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionADol(amount, "USD", "BRL"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionAOtraMoneda(amount, "BRL", "USD"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                case 5:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionADol(amount, "USD", "COP"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    amount = scanner.nextDouble();
                    System.out.println(conversion.generarConversionAOtraMoneda(amount, "COP", "USD"));
                    mostrarMenu();
                    opcion = scanner.nextInt();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
}
