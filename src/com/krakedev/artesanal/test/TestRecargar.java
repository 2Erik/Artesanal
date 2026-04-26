package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean resultado;
		Maquina rubia = new Maquina("Pilsener", "Dorada", 0.02, 8000, "P002");

		rubia.imprimir();
		System.out.println("-------RECARGA 1---------");

		resultado = rubia.recargarCerveza(1000);

		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();

		System.out.println("-------RECARGA 2---------");

		resultado = rubia.recargarCerveza(1000);

		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();
		
		System.out.println("-------RECARGA 3---------");

		resultado = rubia.recargarCerveza(1000);

		System.out.println("Se recargo correctamente: " + resultado);
		rubia.imprimir();
		
		System.out.println("---------RECARGAR 4-----------");
		
		resultado = rubia.recargarCerveza(1000);
		
		System.out.println("Se recargo: "+resultado);
		
	}

}
