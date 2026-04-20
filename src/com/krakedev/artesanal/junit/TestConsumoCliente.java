package com.krakedev.artesanal.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

class TestConsumoCliente {
	
	@Test
	void probarConsumo() {
		
		Maquina maquina1 =  new Maquina("Pilsener", "Fria", 0.02,  8000, "PD002");
		Negocio negocio1 = new Negocio("FRIA", maquina1);
		Cliente cliente1 = new Cliente("Pepe", "1111111111");
		
		negocio1.cargarMaquina();
		negocio1.consumirCerveza(cliente1, 100);
		
		assertEquals(7700, maquina1.getCantidadActual());
		assertEquals(2, cliente1.getTotalConsumido());
		
		negocio1.consumirCerveza(cliente1, 200);
		
		assertEquals(7500, maquina1.getCantidadActual());
		assertEquals(6, cliente1.getTotalConsumido());
		
	}
	
}
