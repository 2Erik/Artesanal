package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TetsServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("Pilsener", "Dorada", 0.02, 8000, "P002");
		System.out.println("Estado inicial");
		rubia.imprimir();
		
		System.out.println("-------LLENAR MAQUINA----------");
		rubia.llenarMaquina();
		rubia.imprimir();
		
		System.out.println("--------Servir 1000 ml----------");
		double valor;
		valor = rubia.servirCerveza(1000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
		
		System.out.println("--------Servir 2000 ml----------");
		valor = rubia.servirCerveza(2000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
		
		System.out.println("--------Servir 6000 ml----------");
		valor = rubia.servirCerveza(6000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
		
		System.out.println("--------Servir 1000 ml----------");
		valor = rubia.servirCerveza(1000);
		rubia.imprimir();
		System.out.println("Valor a pagar: "+valor);
	}

}
