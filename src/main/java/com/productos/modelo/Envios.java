package com.productos.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Envios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEnvio;
	
	private String direccion;
	
	private String detalle; 
	


	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	    private Ventas ventas; 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private estadocompras estadocompra;
	//____________________________//

	public int getIdEnvio() {
		return IdEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		IdEnvio = idEnvio;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public estadocompras getEstadocompra() {
		return estadocompra;
	}

	public void setEstadocompra(estadocompras estadocompra) {
		this.estadocompra = estadocompra;
	}

	public Envios(int idEnvio, String direccion, Ventas ventas, estadocompras estadocompra) {
		super();
		IdEnvio = idEnvio;
		this.direccion = direccion;
		this.ventas = ventas;
		this.estadocompra = estadocompra;
	}

	public Envios(Ventas ventas) {
		super();
		this.ventas = ventas;
	}

	public Envios() {
		super();
	} 

	 
}
