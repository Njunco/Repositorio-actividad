package com.productos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table

public class Ventas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdVenta", nullable = false, insertable=false)
	private int IdVenta;
	
	private int ValorVenta;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaVenta;
	
	private String CiudadCompra;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Cliente cliente; 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Vendedor vendedor; 
	 
	 @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
  
	  @ManyToOne(fetch = FetchType.EAGER)
	    private Inventario inventario;
	 
	//____________________________//

	public int getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(int idVenta) {
		IdVenta = idVenta;
	}

	public int getValorVenta() {
		return ValorVenta;
	}

	public void setValorVenta(int valorVenta) {
		ValorVenta = valorVenta;
	}

	public Date getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}

	public String getCiudadCompra() {
		return CiudadCompra;
	}

	public void setCiudadCompra(String ciudadCompra) {
		CiudadCompra = ciudadCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}



	/*public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}*/

	/*public Set<VentasProducto> getVentasProducto() {
		return ventasProducto;
	}

	public void setVentasProducto(Set<VentasProducto> ventasProducto) {
		this.ventasProducto = ventasProducto;
	}*/

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Ventas(int idVenta) {
		super();
		IdVenta = idVenta;
	}

	public Ventas() {
		super();
	}
}
