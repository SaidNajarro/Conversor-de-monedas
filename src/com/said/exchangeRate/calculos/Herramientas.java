package com.said.exchangeRate.calculos;

import com.said.exchangeRate.conexion.ConexionAPI;
import com.said.exchangeRate.modelos.Moneda;
import com.said.exchangeRate.modelos.TipoDeCambio;

public class Herramientas {
    public static Moneda crearMoneda(int numeroPais, double monto) {
        String nombre;
        String codigo;

        switch (numeroPais) {
            case 1:
                nombre = "Peso argentino";
                codigo = "ARS";
                break;
            case 2:
                nombre = "Boliviano";
                codigo = "BOB";
                break;
            case 3:
                nombre = "Real brasileño";
                codigo = "BRL";
                break;
            case 4:
                nombre = "Peso chileno";
                codigo = "CLP";
                break;
            case 5:
                nombre = "Peso colombiano";
                codigo = "COP";
                break;
            case 6:
                nombre = "Dólar estadounidense";
                codigo = "USD";
                break;
            case 7:
                nombre = "Dólar guyanés";
                codigo = "GYD";
                break;
            case 8:
                nombre = "Guaraní";
                codigo = "PYG";
                break;
            case 9:
                nombre = "Sol";
                codigo = "PEN";
                break;
            case 10:
                nombre = "Dólar surinamés";
                codigo = "SRD";
                break;
            case 11:
                nombre = "Peso uruguayo";
                codigo = "UYU";
                break;
            case 12:
                nombre = "Bolívar digital";
                codigo = "VES";
                break;
            default:
                System.out.println("Número de país no válido.");
                return null;
        }

        Moneda moneda = new Moneda(monto, codigo, nombre);

        TipoDeCambio tipoDeCambio = asignarCambioH(codigo);

        moneda.asignarCambio(tipoDeCambio);

        return moneda;
    }

    public static TipoDeCambio asignarCambioH(String json){
        ConexionAPI conexionAPI = new ConexionAPI();

        String jsonCambio = conexionAPI.obtenerCambioJson(json);
        return conexionAPI.obtenerTipoDeCambio(jsonCambio);
    }
}
