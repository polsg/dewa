package com.model;

public class Personal {
	
	private int id;
	private int idTipoCargo;
	private String nombreCargo;
	private String dni;
	private String apellidos;
	private String nombres;
	private String email;
	private String claveUsuario;
	private String direccion;
	private String telefono;
	private byte[] imagen;
	private TipoCargo tipocargo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getIdTipoCargo() {
		return idTipoCargo;
	}
	public void setIdTipoCargo(int idTipoCargo) {
		this.idTipoCargo = idTipoCargo;
	}
	
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClaveUsuario() {
		return claveUsuario;
	}
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public TipoCargo getTipocargo() {
		return tipocargo;
	}
	public void setTipocargo(TipoCargo tipocargo) {
		this.tipocargo = tipocargo;
	}		
}
