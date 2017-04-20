package com.model;

public class Proceso {
	
	private int id;
	private int idPersonal;
	private String nombPersonal;
	private int idEmpresa;
	private String nombEmpresa;
	private int idTipoProceso;
	private String nombTipoProceso;	
	private String nombreProceso;
	private String nombResponsable;	
	private String descActividades;
	private String codeUml;
	private String observaciones;
	private String fechaRegistro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
	public String getNombPersonal() {
		return nombPersonal;
	}
	public void setNombPersonal(String nombPersonal) {
		this.nombPersonal = nombPersonal;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombEmpresa() {
		return nombEmpresa;
	}
	public void setNombEmpresa(String nombEmpresa) {
		this.nombEmpresa = nombEmpresa;
	}
	public int getIdTipoProceso() {
		return idTipoProceso;
	}
	public String getNombTipoProceso() {
		return nombTipoProceso;
	}
	public void setNombTipoProceso(String nombTipoProceso) {
		this.nombTipoProceso = nombTipoProceso;
	}
	public void setIdTipoProceso(int idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}		
	
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	public String getNombResponsable() {
		return nombResponsable;
	}
	public void setNombResponsable(String nombResponsable) {
		this.nombResponsable = nombResponsable;
	}
	public String getDescActividades() {
		return descActividades;
	}
	public void setDescActividades(String descActividades) {
		this.descActividades = descActividades;
	}
	
	
	public String getCodeUml() {
		return codeUml;
	}
	public void setCodeUml(String codeUml) {
		this.codeUml = codeUml;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
