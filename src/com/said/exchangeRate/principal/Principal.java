package com.said.exchangeRate.principal;

import com.said.exchangeRate.modelos.Moneda;

import java.util.Scanner;

import static com.said.exchangeRate.calculos.Herramientas.crearMoneda;
import static com.said.exchangeRate.modelos.PantallaUsuario.*;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        while (true){
            mostrarMensajeDeInicio();
            mostrarSeleccionDeMonedas();

            mostrarMensajeDeSeleccionDeMonedas();
            int opcionPais = lectura.nextInt();

            mostrarMensajeDeSeleccionDeMonto();
            double montoMoneda = lectura.nextDouble();

            Moneda moneda = crearMoneda(opcionPais, montoMoneda);

            System.out.println(moneda);

            System.out.println("¿Desea realizar alguna otra operación?");
            System.out.println("""
                    Presione 0 para continuar y cualquier otro número para salir:
                    """);
            int opcionSalir = lectura.nextInt();
            if(opcionSalir == 0){
                return;
            }
        }
    }
}
