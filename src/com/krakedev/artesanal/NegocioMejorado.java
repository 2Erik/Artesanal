package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;
	private int ultimoCodigo = 100;

	// CONSTRUCTOR
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
		clientes = new ArrayList<Cliente>();
	}

	// SETTERS AND GETTERS
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	// METODO GENERAR CODIGO
	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	// METODO AGREGAR MAQUINA
	public boolean agregarMaquina(String nombre, String descripcion, double precioPorML) {
		String codigo = generarCodigo();

		Maquina maquinaRecuperada = recuperarMaquina(codigo);

		if (maquinaRecuperada == null) {
			Maquina maquina = new Maquina(nombre, descripcion, precioPorML, codigo);
			maquinas.add(maquina);
			return true;
		}

		return false;
	}

	// METODO CARAGAR MAQUINAS
	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}

	// METODO RECUPERAR MAQUINAS
	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			if (maquinas.get(i).getCodigo().equals(codigo)) {
				return maquinas.get(i);
			}
		}
		return null;
	}

	// METODO REGISTRAR CLIENTE
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);
	}

	// METODO BUSCAR CLIENTE
	public Cliente buscarClientePorCedula(String cedula) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCedula().equals(cedula)) {
				return clientes.get(i);
			}
		}
		return null;
	}

	// METODO BUSCAR CLIENTE
	public Cliente buscarClientePorCodigo(int codigo) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCodigo() == codigo) {
				return clientes.get(i);
			}
		}
		return null;
	}
	
	//METODO CONSUMIR CERVEZA
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		Maquina maquina = recuperarMaquina(codigoMaquina);
		Cliente cliente = buscarClientePorCodigo(codigoCliente);
		
		if(maquina == null || cliente == null) {
			return;
		}
		
		double resultado = maquina.servirCerveza(cantidad);
		registrarConsumo(codigoCliente, resultado);
		
	}
	
	//METODO REGISTRAR CONSUMO
	public void registrarConsumo(int codigo, double valor) {
		Cliente cliente = buscarClientePorCodigo(codigo);
		cliente.setTotalConsumido(valor+cliente.getTotalConsumido());
	}

}
