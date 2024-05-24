package com.productos.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdRol;
	private String nombre;
	
	

	public int getIdRol() {
		return IdRol;
	}

	public void setIdRol(int idRol) {
		IdRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return  nombre ;
	}


	
	
}
