package com.productos.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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


@Entity
@Table
public class Productos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProducto;
	
	private String NombreProducto;
	
	private int precio; 
	 
	
    private int CantidadEmpaque;
    
    
    private String Estado; 
    
    
    
    
    @JoinTable(
	        name = "Inventario_Productos",
	        joinColumns = @JoinColumn(name = "IdProducto", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="IdInventario", nullable = false)
	    )
	    @ManyToMany(cascade = CascadeType.PERSIST)
	    private List<Inventario> inventario;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Categorias categorias; 
    
    
    @ManyToMany(mappedBy = "productos")
    private List<Insumos> insumos;
    
    
    @ManyToOne
    private UnidadesMedida unidadesmedidas;
    
  //____________________________//


	public int getIdProducto() {
		return IdProducto;
	}


	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}


	public String getNombreProducto() {
		return NombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getCantidadEmpaque() {
		return CantidadEmpaque;
	}


	public void setCantidadEmpaque(int cantidadEmpaque) {
		CantidadEmpaque = cantidadEmpaque;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}





	public List<Inventario> getInventario() {
		return inventario;
	}


	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}


	public Categorias getCategorias() {
		return categorias;
	}


	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}


	public List<Insumos> getInsumos() {
		return insumos;
	}


	public void setInsumos(List<Insumos> insumos) {
		this.insumos = insumos;
	}


	public UnidadesMedida getUnidadesmedidas() {
		return unidadesmedidas;
	}


	public void setUnidadesmedidas(UnidadesMedida unidadesmedidas) {
		this.unidadesmedidas = unidadesmedidas;
	}


	public Productos(int idProducto, String nombreProducto, int precio, int cantidadEmpaque, String estado,
			List<Ventas> ventas, List<Inventario> inventario, Categorias categorias, List<Insumos> insumos,
			UnidadesMedida unidadesmedidas) {
		super();
		IdProducto = idProducto;
		NombreProducto = nombreProducto;
		this.precio = precio;
		CantidadEmpaque = cantidadEmpaque;
		Estado = estado;
	
		this.inventario = inventario;
		this.categorias = categorias;
		this.insumos = insumos;
		this.unidadesmedidas = unidadesmedidas;
	}


	public Productos() {
		super();
	}


	public Productos(String nombreProducto, int precio, int cantidadEmpaque, String estado, List<Ventas> ventas,
			List<Inventario> inventario, Categorias categorias, List<Insumos> insumos, UnidadesMedida unidadesmedidas) {
		super();
		NombreProducto = nombreProducto;
		this.precio = precio;
		CantidadEmpaque = cantidadEmpaque;
		Estado = estado;
		this.inventario = inventario;
		this.categorias = categorias;
		this.insumos = insumos;
		this.unidadesmedidas = unidadesmedidas;
	}


	public Productos(String nombreProducto, int precio, int cantidadEmpaque, String estado) {
		super();
		NombreProducto = nombreProducto;
		this.precio = precio;
		CantidadEmpaque = cantidadEmpaque;
		Estado = estado;
	}


	public Productos(int idProducto, String nombreProducto, int precio, int cantidadEmpaque, String estado) {
		super();
		IdProducto = idProducto;
		NombreProducto = nombreProducto;
		this.precio = precio;
		CantidadEmpaque = cantidadEmpaque;
		Estado = estado;
	}


	public Productos(UnidadesMedida unidadesmedidas) {
		super();
		this.unidadesmedidas = unidadesmedidas;
	}


	public Productos(String nombreProducto, int precio, int cantidadEmpaque, String estado, List<Ventas> ventas,
			List<Inventario> inventario, Categorias categorias, UnidadesMedida unidadesmedidas) {
		super();
		NombreProducto = nombreProducto;
		this.precio = precio;
		CantidadEmpaque = cantidadEmpaque;
		Estado = estado;
		this.inventario = inventario;
		this.categorias = categorias;
		this.unidadesmedidas = unidadesmedidas;
	}


	public Productos(int idProducto) {
		super();
		IdProducto = idProducto;
	}


	@Override
	public String toString() {
		return  NombreProducto;
	}


	
    
    

}
