package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;
	private int ultimoCodigo = 100;
	
	//CONSTRUCTOR
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}
	
	//SETTERS AND GETTERS
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	//METODO GENERAR CODIGO
	public String generarCodigo() {
		int numero = (int) (Math.random()*100)+1;
		return "M-"+numero;
	}
	
	//METODO AGREGAR MAQUINA
	public boolean agregarMaquina(String nombre, String descripcion, double precioPorML) {
		String codigo = generarCodigo();
		
		Maquina maquinaRecuperada = recuperarMaquina(codigo);
		
		if(maquinaRecuperada == null) {
			Maquina maquina = new Maquina(nombre, descripcion, precioPorML, codigo);
			maquinas.add(maquina);
			return true;
		}
		
		return false;
	}
	
	//METODO CARAGAR MAQUINAS
	public void cargarMaquinas() {
		for(int i=0; i<maquinas.size();i++) {
			maquinas.get(i).llenarMaquina();
		}
	}
	
	//METODO RECUPERAR MAQUINAS
	public Maquina recuperarMaquina(String codigo) {
		for(int i = 0; i<maquinas.size();i++) {
			if (maquinas.get(i).getCodigo().equals(codigo)) {
				return maquinas.get(i);
			}
		}
		return null;
	}
	
	//METODO REGISTRAR CLIENTE
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);
	}
	
}
