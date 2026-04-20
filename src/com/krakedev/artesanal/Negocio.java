package com.krakedev.artesanal;

public class Negocio {
	private String nombre;
	//La composicion es meter un objeto dentro de otro objeto
	private Maquina maquina;
	private int ultimoCodigo = 100;
	
	//CONSTRUCTOR
	public Negocio() {}
	
	public Negocio(String nombre, Maquina maquina) {
		this.nombre = nombre;
		this.maquina = maquina;
	} 
	
	//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	
	//METODO ASIGNACION DE CODIGO
	public void asignarCodigoCliente(Cliente cliente) {
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo ++;
	}
	
	//METODO CARGAR MAQUINA
	public void cargarMaquina() {
		maquina.llenarMaquina();
	}
	
	//METODO CONSUMIR CERVEZA
	public void consumirCerveza(Cliente cliente, double ml) {
		
	double valor = maquina.servirCerveza(ml);
	cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
	
	}
}
