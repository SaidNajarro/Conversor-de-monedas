package com.said.exchangeRate.modelos;

public class PantallaUsuario {

    static String mensajeDeInicio = """
            **************** Bienvenido al conversor de monedas sudamericanas ******************
                
            Nos encargaremos de convertir su moneda en las divisas más utilizadas y actualizadas
                
                - Dólar Estadounidense (USD)
                - Euro (EUR)
                - Yen japonés (JPY)
                - Libra esterlina (GBP)
                - Dólar australiano (AUD)
            """;

    static String seleccionDeMonedas = """
            Escoja la moneda a covertir:
                1.  Argentina – Peso argentino (ARS)
                2.  Bolivia – Boliviano (BOB)
                3.  Brasil – Real brasileño (BRL)
                4.  Chile – Peso chileno (CLP)
                5.  Colombia – Peso colombiano (COP)
                6.  Ecuador – Dólar estadounidense (USD)
                7.  Guyana – Dólar guyanés (GYD)
                8.  Paraguay – Guaraní (PYG)
                9.  Perú – Sol (PEN)
                10. Surinam – Dólar surinamés (SRD)
                11. Uruguay – Peso uruguayo (UYU)
                12. Venezuela – Bolívar digital (VES)
            """;

    static String mensajeDeSeleccionDeMonedas = """
            Digite la moneda que quiere convertir:            
            """;

    static String mensajeDeSeleccionDeMonto = """
            Ingrese la cantidad a convertir:            
            """;


    public static void mostrarMensajeDeInicio(){
        System.out.println(mensajeDeInicio);
    }

    public static void mostrarSeleccionDeMonedas(){
        System.out.println(seleccionDeMonedas);
    }

    public static void mostrarMensajeDeSeleccionDeMonto() {
        System.out.print(mensajeDeSeleccionDeMonto);
    }

    public static void mostrarMensajeDeSeleccionDeMonedas() {
        System.out.print(mensajeDeSeleccionDeMonedas);
    }


}
