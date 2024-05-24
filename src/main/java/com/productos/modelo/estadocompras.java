package com.productos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class estadocompras implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEstado;
	private String NombreEstado; 

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadocompra")
  	private List<Envios> envios;
	
	//____________________________//
	
	
	public int getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(int idEstado) {
		IdEstado = idEstado;
	}

	public String getNombreEstado() {
		return NombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		NombreEstado = nombreEstado;
	}

	public List<Envios> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envios> envios) {
		this.envios = envios;
	}

	@Override
	public String toString() {
		return  NombreEstado;
	}

	
	
}
