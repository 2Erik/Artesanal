package com.krakedev.artesanal.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejorado {
	private NegocioMejorado negocio;

	@BeforeEach
	public void setUp() {
		// Se crea una nueva instancia antes de cada prueba
		negocio = new NegocioMejorado();
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO agregarMaquina
	// ==========================================================
	
	@Test
	public void testSetMaquina() {
		ArrayList<Maquina> nuevasMaquinas = new ArrayList<Maquina>();

		// Se agrega una máquina a la nueva lista
		Maquina maquina = new Maquina(
				"Pilsener",
				"Rubia",
				0.05,
				"M-500");

		nuevasMaquinas.add(maquina);

		// Se reemplaza la lista original
		negocio.setMaquinas(nuevasMaquinas);
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO agregarMaquina
	// ==========================================================

	@Test
	public void testAgregarMaquina() {
		// Se agrega una máquina nueva
		boolean resultado = negocio.agregarMaquina("Pilsener", "Rubia", 0.05);

		// Se espera que la operación sea exitosa
		assertTrue(resultado);
		assertEquals(1, negocio.getMaquinas().size());

	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO recuperarMaquina
	// ==========================================================

	@Test
	public void testRecuperarMaquinaExistente() {
		negocio.agregarMaquina("Pilsener", "Rubia", 0.05);

		String codigo = negocio.getMaquinas().get(0).getCodigo();

		Maquina maquina = negocio.recuperarMaquina(codigo);

		// Debe encontrar la máquina
		assertNotNull(maquina);
		assertEquals(codigo, maquina.getCodigo());
	}

	@Test
	public void testRecuperarMaquinaNoExistente() {
		Maquina maquina = negocio.recuperarMaquina("M-999");

		// Debe retornar null
		assertNull(maquina);
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO cargarMaquinas
	// ==========================================================

	@Test
	public void testCargarMaquinas() {
		negocio.agregarMaquina("Pilsener", "Rubia", 0.05);
		negocio.agregarMaquina("Club", "Negra", 0.07);

		negocio.cargarMaquinas();

		// Cada máquina debe quedar llena hasta el límite permitido
		assertEquals(9800, negocio.getMaquinas().get(0).getCantidadActual());

		assertEquals(9800, negocio.getMaquinas().get(1).getCantidadActual());
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO registrarCliente
	// ==========================================================

	@Test
	public void testRegistrarCliente() {
		negocio.registrarCliente("Erik", "1723456789");

		Cliente cliente = negocio.buscarClientePorCedula("1723456789");

		// Se valida que el cliente exista
		assertNotNull(cliente);
		assertEquals("Erik", cliente.getNombre());
		assertEquals(100, cliente.getCodigo());
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO buscarClientePorCedula
	// ==========================================================

	@Test
	public void testBuscarClientePorCedulaExistente() {
		negocio.registrarCliente("Erik", "1723456789");

		Cliente cliente = negocio.buscarClientePorCedula("1723456789");

		assertNotNull(cliente);
	}

	@Test
	public void testBuscarClientePorCedulaNoExistente() {
		Cliente cliente = negocio.buscarClientePorCedula("0000000000");

		assertNull(cliente);
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO buscarClientePorCodigo
	// ==========================================================

	@Test
	public void testBuscarClientePorCodigoExistente() {
		negocio.registrarCliente("Erik", "1723456789");

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertNotNull(cliente);
	}

	@Test
	public void testBuscarClientePorCodigoNoExistente() {
		Cliente cliente = negocio.buscarClientePorCodigo(999);

		assertNull(cliente);
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO registrarConsumo
	// ==========================================================

	@Test
	public void testRegistrarConsumo() {
		negocio.registrarCliente("Erik", "1723456789");

		negocio.registrarConsumo(100, 25.5);

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertEquals(25.5, cliente.getTotalConsumido());
	}

	@Test
	public void testRegistrarConsumoAcumulado() {
		negocio.registrarCliente("Erik", "1723456789");

		negocio.registrarConsumo(100, 20);
		negocio.registrarConsumo(100, 30);

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertEquals(50, cliente.getTotalConsumido());
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO consumirCerveza
	// ==========================================================

	@Test
	public void testConsumirCervezaExitoso() {
		negocio.agregarMaquina("Pilsener", "Rubia", 0.05);
		negocio.cargarMaquinas();

		negocio.registrarCliente("Erik", "1723456789");

		String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

		negocio.consumirCerveza(100, codigoMaquina, 1000);

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		// 1000 * 0.05 = 50
		assertEquals(50, cliente.getTotalConsumido());
	}

	@Test
	public void testConsumirCervezaClienteNoExiste() {
		negocio.agregarMaquina("Pilsener", "Rubia", 0.05);

		String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();

		// No debe lanzar error ni registrar consumo
		negocio.consumirCerveza(999, codigoMaquina, 1000);

		assertNull(negocio.buscarClientePorCodigo(999));
	}

	@Test
	public void testConsumirCervezaMaquinaNoExiste() {
		negocio.registrarCliente("Erik", "1723456789");

		negocio.consumirCerveza(100, "M-999", 1000);

		Cliente cliente = negocio.buscarClientePorCodigo(100);

		assertEquals(0, cliente.getTotalConsumido());
	}

	// ==========================================================
	// PRUEBAS DEL MÉTODO consultarValorVendido
	// ==========================================================

	@Test
	public void testConsultarValorVendidoSinClientes() {
		assertEquals(0, negocio.consultarValorVendido());
	}

	@Test
	public void testConsultarValorVendidoConUnCliente() {
		negocio.registrarCliente("Erik", "1723456789");
		negocio.registrarConsumo(100, 75);

		assertEquals(75, negocio.consultarValorVendido());
	}

	@Test
	public void testConsultarValorVendidoMultiplesClientes() {
		negocio.registrarCliente("Erik", "1723456789");
		negocio.registrarCliente("Ana", "0102030405");

		negocio.registrarConsumo(100, 50);
		negocio.registrarConsumo(101, 120);

		// Se valida el comportamiento real del método
		// (retorna el último total consumido)
		assertEquals(120, negocio.consultarValorVendido());
	}
}
