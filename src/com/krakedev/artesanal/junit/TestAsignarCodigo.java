package com.krakedev.artesanal.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

class TestAsignarCodigo {
	
	@Test
	void asiganrCodigo() {
		
		Negocio negocio1 = new Negocio();
		
		Cliente cliente1 = new Cliente("Mario", "1111111111");
		Cliente cliente2 = new Cliente("Pepe", "2222222222");
		
		negocio1.asignarCodigoCliente(cliente1);
		negocio1.asignarCodigoCliente(cliente2);
		
		assertEquals(100, cliente1.getCodigo());
		assertEquals(101, cliente2.getCodigo());
	}
}
