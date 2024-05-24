package com.productos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


@Entity
@Table
public class Permisos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPermiso;
	
	private String TipoPermiso;
	
	 @JoinTable(
		        name = "Roles_Permisos",
		        joinColumns = @JoinColumn(name = "IdPermisos", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="IdRol", nullable = false)
		    )
		    @ManyToMany(cascade = CascadeType.PERSIST)
		    private List<Rol> roles;
	 
	//____________________________//

	public int getIdPermiso() {
		return IdPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		IdPermiso = idPermiso;
	}

	public String getTipoPermiso() {
		return TipoPermiso;
	}

	public void setTipoPermiso(String tipoPermiso) {
		TipoPermiso = tipoPermiso;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
   


}
