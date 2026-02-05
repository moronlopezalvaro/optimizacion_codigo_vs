package com.ilerna;

import java.util.*;

/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas
 * responsabilidades.
 */
public class ProcesadorPedidos {

    private static final Logger LOGGER = Logger.getLogger(ProcesadorPedidos.class.getName());
    private static final double TASA_IMPUESTO = 0.21;
    private static final double TASA_DESCUENTO = 0.10;

    private static final double UMBRAL_DESCUENTO = 100.0;
    private static final double GASTOS_ENVIO = 15.95;
    private static final double UMBRAL_ENVIO_GRATUITO = 500.0;

    public double procesar(List<String> listaNombres, List<Double> precios) {
        double t = 0;

        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            LOGGER.info("Añadiendo producto: " + listaNombres.get(i));
            t = t + precios.get(i);
        }

        // Lógica de descuento (Magic Number 100 y 0.10)
        if (t > UMBRAL_DESCUENTO) {
            LOGGER.info("Descuento aplicado.");
            t = t - (t * TASA_DESCUENTO);
        }

        // Cálculo de impuestos (Magic Number 0.21)
        double res = t + (t * TASA_IMPUESTO);

        // Gastos de envío (Magic Number 500)
        if (res < UMBRAL_ENVIO_GRATUITO) {
            res = res + GASTOS_ENVIO;
        }

        return res;
    }
}
