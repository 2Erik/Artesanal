package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("Pilsener", "Dorada", 0.02, 8000, "P002");
		
		rubia.imprimir();
		
		rubia.llenarMaquina();
		System.out.println("---------------------");
		
		rubia.imprimir();
		
		Maquina negra = new Maquina("Club", "Mas fria", 0.03, "C002");
		
		negra.llenarMaquina();
		System.out.println("-------------------");
		
		negra.imprimir();
		System.out.println("------------------------");
		
		Maquina maquina = new Maquina("Rica", "Mas fria", 0.04, "C770");
		
		maquina.llenarMaquina();
		maquina.imprimir();
	}

}
