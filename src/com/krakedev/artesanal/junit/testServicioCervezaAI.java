package com.krakedev.artesanal.junit;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testServicioCervezaAI {

    // Tolerancia para comparaciones de double
    private static final double DELTA = 0.0001;

    /**
     * ✅ Caso 1:
     * La máquina tiene suficiente cerveza.
     * Debe servir correctamente, restar la cantidad y retornar el valor.
     */
    @Test
    public void testServirCervezaCorrectamente() {
        Maquina m = new Maquina("Pilsener", "Rubia", 0.05, 1000, "P002");

        m.recargarCerveza(500); // cantidad actual = 500

        double valor = m.servirCerveza(200);

        // Verifica valor a pagar
        assertEquals(200 * 0.05, valor, DELTA);

        // Verifica que se haya restado correctamente
        assertEquals(300, m.getCantidadActual(), DELTA);
    }

    /**
     * ❌ Caso 2:
     * No hay suficiente cerveza.
     * No debe servir nada, no modifica cantidad y retorna 0.
     */
    @Test
    public void testNoSirvePorFaltaDeCerveza() {
        Maquina m = new Maquina("Pilsener", "Rubia", 0.05, 1000, "P002");

        m.recargarCerveza(100); // cantidad actual = 100

        double valor = m.servirCerveza(200);

        // No debe cobrar nada
        assertEquals(0.0, valor, DELTA);

        // No debe cambiar la cantidad
        assertEquals(100, m.getCantidadActual(), DELTA);
    }

    /**
     * ✅ Caso 3:
     * Sirve exactamente lo que tiene disponible.
     * Debe dejar la máquina en 0.
     */
    @Test
    public void testSirveCantidadExacta() {
        Maquina m = new Maquina("Negra", "Oscura", 0.1, 1000, "N002");

        m.recargarCerveza(300);

        double valor = m.servirCerveza(300);

        assertEquals(300 * 0.1, valor, DELTA);
        assertEquals(0, m.getCantidadActual(), DELTA);
    }

    /**
     * ❌ Caso 4:
     * Máquina sin cerveza.
     * No debe servir nada ni modificar estado.
     */
    @Test
    public void testMaquinaVacia() {
        Maquina m = new Maquina("IPA", "Amarga", 0.08, 1000, "I002");

        double valor = m.servirCerveza(100);

        assertEquals(0.0, valor, DELTA);
        assertEquals(0, m.getCantidadActual(), DELTA);
    }

    /**
     * ✅ Caso 5:
     * Uso del segundo constructor (sin capacidad explícita).
     * Verifica comportamiento normal.
     */
    @Test
    public void testConstructorSinCapacidad() {
        Maquina m = new Maquina("Lager", "Suave", 0.03, "L002");

        m.recargarCerveza(500);

        double valor = m.servirCerveza(200);

        assertEquals(200 * 0.03, valor, DELTA);
        assertEquals(300, m.getCantidadActual(), DELTA);
    }
}
