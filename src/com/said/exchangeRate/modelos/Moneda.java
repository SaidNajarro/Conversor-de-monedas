package com.said.exchangeRate.modelos;

import java.util.HashMap;
import java.util.Map;

public class Moneda {
    private final String nombre;
    private final double monto;
    private final String codigo;
    private Map<String, Double> montoCambiado;

    public Moneda(double monto, String codigo, String nombre) {
        this.monto = monto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.montoCambiado = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void asignarCambio(TipoDeCambio tipoDeCambio){
        montoCambiado.put("USD", tipoDeCambio.getUSD()*monto);
        montoCambiado.put("EUR", tipoDeCambio.getEUR()*monto);
        montoCambiado.put("JPY", tipoDeCambio.getJPY()*monto);
        montoCambiado.put("GBP", tipoDeCambio.getGBP()*monto);
        montoCambiado.put("AUD", tipoDeCambio.getAUD()*monto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*************************************************\n");
        sb.append("*                  MONEDA                      *\n");
        sb.append("*************************************************\n");
        sb.append("Nombre          : ").append(nombre).append("\n");
        sb.append("Código          : ").append(codigo).append("\n");
        sb.append("Monto inicial   : ").append(String.format("%.2f", monto)).append("\n");
        sb.append("-------------------------------------------------\n");
        sb.append("Montos convertidos:\n");

        if (montoCambiado != null && !montoCambiado.isEmpty()) {
            montoCambiado.forEach((divisa, valor) ->
                    sb.append("  - ").append(divisa).append(": ").append(String.format("%.2f", valor)).append("\n")
            );
        } else {
            sb.append("  (No hay datos de conversión disponibles)\n");
        }

        sb.append("*************************************************\n");
        return sb.toString();
    }

}
