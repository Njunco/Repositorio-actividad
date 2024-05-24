package com.productos.Controller.vendedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productos.Repository.UsuarioRepository;
import com.productos.modelo.Usuario;

@Controller
@RequestMapping
public class UsuarioVendedorController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping("/usuariosVendedor")
	public String listarUsuarios(Model modelo) {
		List<Usuario> listarUsuarios = usuarioRepository.findAll();
		modelo.addAttribute("listarUsuarios", listarUsuarios);
		return "vendedor/usuarioVendedor";

	}

}
