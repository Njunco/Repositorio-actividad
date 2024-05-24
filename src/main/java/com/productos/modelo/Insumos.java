package com.productos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


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


import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table
public class Insumos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdInsumo;
	
	private String NombreInsumo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaIngreso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaVence;
	
	private int CantidadInsumo;
	
	private String Estado; 
	
	
	  @JoinTable(
		        name = "Insumos_Productos",
		        joinColumns = @JoinColumn(name = "IdInsumo", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="IdProducto", nullable = false)
		    )
	  
		    @ManyToMany
		    private List<Productos> productos;
	  
	  @JoinTable(
		        name = "Provedores_Insumos",
		        joinColumns = @JoinColumn(name = "IdInsumo", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="IdProvedores", nullable = false)
		    )
	    
		    @ManyToMany(fetch = FetchType.EAGER)
		    private List<Cliente>provedores;
	  
	  @ManyToOne
	  @JoinColumn(name = "Id_UnidadMedida")
	    private UnidadesMedida unidadesmedida; 
	  
	  
	 
	  
	//____________________________//



	public int getIdInsumo() {
		return IdInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		IdInsumo = idInsumo;
	}

	public String getNombreInsumo() {
		return NombreInsumo;
	}

	public void setNombreInsumo(String nombreInsumo) {
		NombreInsumo = nombreInsumo;
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

	public int getCantidadInsumo() {
		return CantidadInsumo;
	}

	public void setCantidadInsumo(int cantidadInsumo) {
		CantidadInsumo = cantidadInsumo;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	


	public UnidadesMedida getUnidadesmedida() {
		return unidadesmedida;
	}

	public void setUnidadesmedida(UnidadesMedida unidadesmedida) {
		this.unidadesmedida = unidadesmedida;
	}

	public List<Cliente> getProvedores() {
		return provedores;
	}

	public void setProvedores(List<Cliente> provedores) {
		this.provedores = provedores;
	}

	public Insumos(int idInsumo, String nombreInsumo, Date fechaIngreso, Date fechaVence, int cantidadInsumo,
			String estado, List<Productos> productos) {
		super();
		IdInsumo = idInsumo;
		NombreInsumo = nombreInsumo;
		FechaIngreso = fechaIngreso;
		FechaVence = fechaVence;
		CantidadInsumo = cantidadInsumo;
		Estado = estado;
		this.productos = productos;
	
		
	}
	
	public Insumos() {
		super();
	}

	public Insumos(String nombreInsumo, Date fechaIngreso, Date fechaVence, int cantidadInsumo, String estado,
			List<Productos> productos) {
		super();
		NombreInsumo = nombreInsumo;
		FechaIngreso = fechaIngreso;
		FechaVence = fechaVence;
		CantidadInsumo = cantidadInsumo;
		Estado = estado;
		this.productos = productos;
		
	}

	public Insumos(int idInsumo, String nombreInsumo, Date fechaIngreso, Date fechaVence, int cantidadInsumo,
			String estado) {
		super();
		IdInsumo = idInsumo;
		NombreInsumo = nombreInsumo;
		FechaIngreso = fechaIngreso;
		FechaVence = fechaVence;
		CantidadInsumo = cantidadInsumo;
		Estado = estado;
	}

	public Insumos(List<Cliente> provedores) {
		super();
		this.provedores = provedores;
	}

	
	
}
