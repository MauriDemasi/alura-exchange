package com.mauridemasi.aluraexchange.menu;


import com.mauridemasi.aluraexchange.funcionalidades.CalculaConversion;

import java.util.Scanner;

public class Principal  {
    public static void main(String[] args) {
         Menu menu = new Menu();
         menu.mostrarMenu();
         Scanner sc = new Scanner(System.in);
        CalculaConversion conversion = new CalculaConversion();
         menu.seleccionarOpcion(sc, conversion);
    }
}
