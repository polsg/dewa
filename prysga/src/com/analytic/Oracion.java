package com.analytic;

public class Oracion {
	
	private String condicion;	
	private String sujeto;
	private String predicado;	
	private String mensaje;	
	private String estado;	
	
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getSujeto() {
		return sujeto;
	}
	public void setSujeto(String sujeto) {
		this.sujeto = sujeto;
	}
	public String getPredicado() {
		return predicado;
	}
	public void setPredicado(String predicado) {
		this.predicado = predicado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
