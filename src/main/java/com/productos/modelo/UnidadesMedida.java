package com.productos.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class UnidadesMedida  implements Serializable {
	
	


	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdUnidadesMedida;
	
	private String UnidadaesMedida; 
	
	 @OneToMany(fetch = FetchType.EAGER)
	 @JoinColumn( name = "Id_UnidadMedida")
		private List<Insumos> insumos = new ArrayList<>();
	
	 
	 
	 
	 
	 @OneToMany
		private List<Productos> productos = new ArrayList<>();

	//____________________________//
	public int getIdUnidadesMedida() {
		return IdUnidadesMedida;
	}


	public void setIdUnidadesMedida(int idUnidadesMedida) {
		IdUnidadesMedida = idUnidadesMedida;
	}


	public String getUnidadaesMedida() {
		return UnidadaesMedida;
	}


	public void setUnidadaesMedida(String unidadaesMedida) {
		UnidadaesMedida = unidadaesMedida;
	}


	public List<Productos> getProductos() {
		return productos;
	}


	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}


	public List<Insumos> getInsumos() {
		return insumos;
	}


	public void setInsumos(List<Insumos> insumos) {
		this.insumos = insumos;
	}


	@Override
	public String toString() {
		return  UnidadaesMedida;
	}
	
	
	

	 

}
