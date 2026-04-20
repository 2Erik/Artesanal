package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina maquinaNueva = new Maquina("Pilsener", "Fria", 0.02, 8000,"CP02");
		Negocio negocio1 = new Negocio("Negocio", maquinaNueva);
		
		System.out.println("Nombre: "+negocio1.getNombre());
		System.out.println("Maquina: "+negocio1.getMaquina());
		
		Maquina maquina1 = negocio1.getMaquina();
		//Intento acceder a su atributo pero este esta en null
		double capacidad = maquina1.getCapacidadMaxima();
	}

}
