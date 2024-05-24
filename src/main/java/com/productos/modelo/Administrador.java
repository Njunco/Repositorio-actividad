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
public class Administrador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdAdministrador;
	
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    private Usuario usuarios;

	//____________________________//
	public int getIdAdministrador() {
		return IdAdministrador;
	}


	public void setIdAdministrador(int idAdministrador) {
		IdAdministrador = idAdministrador;
	}


	public Usuario getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	} 
    
	
	 
	 
}
