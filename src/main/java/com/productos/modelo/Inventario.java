package com.productos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.productos.modelo.Productos;




@Entity
@Table
public class Inventario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdInventario;
	private int CantidadProductos;
	private Date FechaIngreso; 
	private Date FechaVence; 
	private String Estado; 
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Productos producto;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventario")
	  	private List<Ventas> ventas;
	 
	 @ManyToMany(mappedBy = "inventario")
	    private List<Productos> productos ;
	 
	//____________________________//

	public int getIdInventario() {
		return IdInventario;
	}

	public void setIdInventario(int idInventario) {
		IdInventario = idInventario;
	}

	public int getCantidadProductos() {
		return CantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}

	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public Date getFechaVence() {
		return FechaVence;
	}

	public void setFechaVence(Date fechaVence) {
		FechaVence = fechaVence;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	
	  
}
