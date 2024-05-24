package com.productos.modelo;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Vendedor  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdVendedor;
	private int NombreVendedor;
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Usuario usuarios; 
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	  	private List<Ventas> ventas;
	 
	//____________________________//

	 
	public int getIdVendedor() {
		return IdVendedor;
	}



	public void setIdVendedor(int idVendedor) {
		IdVendedor = idVendedor;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}



	@Override
	public String toString() {
		return " || "+ IdVendedor + " || "  + usuarios ;
	}



	 

}
