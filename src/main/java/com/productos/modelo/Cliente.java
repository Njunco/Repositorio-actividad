package com.productos.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Cliente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCliente;
	
	private String Nombres;
	
	private String Apellidos;
	
	private String Correo; 
	
	private int Telefono; 
	
    private String Ciudad;
    
    private String Direccion;
    
    


	public int getIdCliente() {
		return IdCliente;
	}


	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}


	public String getNombres() {
		return Nombres;
	}


	public void setNombres(String nombres) {
		Nombres = nombres;
	}


	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public String getCiudad() {
		return Ciudad;
	}


	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Cliente(int idCliente, String nombres, String apellidos, String correo, int telefono, String ciudad,
			String direccion) {
		super();
		IdCliente = idCliente;
		Nombres = nombres;
		Apellidos = apellidos;
		Correo = correo;
		Telefono = telefono;
		Ciudad = ciudad;
		Direccion = direccion;
	}


	public Cliente(int idCliente) {
		super();
		IdCliente = idCliente;
	}


	public Cliente() {
		super();
	}


	public Cliente(String nombres) {
		super();
		Nombres = nombres;
	}


	@Override
	public String toString() {
		return "Id = " + IdCliente + ",  " + Nombres + " " + Apellidos + "";
	}


	

	


	
	





    
    

}
