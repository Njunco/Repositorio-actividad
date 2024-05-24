package com.productos.dao;
import java.util.List;

import com.productos.modelo.Usuario;

public interface UsuarioServicio {
	public List<Usuario> BuscarTodos();
	
	public void crearUsuario(Usuario usuario);
		
	public void actualizarUsuario(Usuario usuario);
	
}
