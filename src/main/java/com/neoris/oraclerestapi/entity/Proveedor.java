package com.neoris.oraclerestapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="proveedorid")
	private int proveedorid;
	@NotNull
	@Column(name="nombreprov")
	private String nombreprov;
	@NotNull
	@Column(name="contacto")
	private String contacto;
	@Column(name="celuprov")
	private String celuprov;
	@Column(name="fijoprov")
	private String fijoprov;
	
	public int getProveedorid() {
		return proveedorid;
	}
	public void setProveedorid(int proveedorid) {
		this.proveedorid = proveedorid;
	}
	public String getNombreprov() {
		return nombreprov;
	}
	public void setNombreprov(String nombreprov) {
		this.nombreprov = nombreprov;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getCeluprov() {
		return celuprov;
	}
	public void setCeluprov(String celuprov) {
		this.celuprov = celuprov;
	}
	public String getFijoprov() {
		return fijoprov;
	}
	public void setFijoprov(String fijoprov) {
		this.fijoprov = fijoprov;
	}
	
	

}
