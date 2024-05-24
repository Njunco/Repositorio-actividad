package com.productos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table

public class VentasProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdVentaProducto", nullable = false, insertable=false)
	private int IdVentaProducto;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venta")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Ventas ventas;
     
    public int getIdVentaProducto() {
		return IdVentaProducto;
	}
	public void setIdVentaProducto(int idVentaProducto) {
		IdVentaProducto = idVentaProducto;
	}

	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Productos productos;
    
	private int CantidadCompra;
    private int precio;
    
    public Ventas getVentas() {
		return ventas;
	}
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public int getCantidadCompra() {
		return CantidadCompra;
	}
	public void setCantidadCompra(int cantidadCompra) {
		CantidadCompra = cantidadCompra;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public VentasProducto()
	{
		super();
	}
	public VentasProducto(int idVentaProducto) {
		super();
		IdVentaProducto = idVentaProducto;
	}
}
