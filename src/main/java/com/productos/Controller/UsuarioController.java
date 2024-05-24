package com.productos.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.productos.Repository.RolRepository;
import com.productos.Repository.UsuarioRepository;
import com.productos.daoImpl.UsuarioImp;
import com.productos.modelo.Rol;
import com.productos.modelo.Usuario;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	UsuarioImp usuarioImp;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/registro")
	public String crearUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}

	@PostMapping("/guardarRegistro")
	public String crearUsuario(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			return "registro";
		}
		usuarioImp.crearUsuario(usuario);
		atributo.addFlashAttribute("guardar", "Se ha registrado el usuario con exito");
		return "redirect:/registro?exito";
	}

	@GetMapping("/usuarios")
	public String listarUsuarios(Model modelo) {
		List<Usuario> listarUsuarios = usuarioRepository.findAll();
		modelo.addAttribute("listarUsuarios", listarUsuarios);
		return "Admin/usuario";

	}

	@GetMapping("/usuarios/nuevo")
	public String MostrarFormularioDeRegistro(Model modelo) {
		List<Rol> listaRoles = rolRepository.findAll();
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("listaRoles", listaRoles);

		return "Admin/usuario_formulario";
	}

	@PostMapping("/usuarios/guardar")
	public String guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/editar/{IdUsuario}")
	public String EditarUsuario(@PathVariable("IdUsuario") Integer IdUsuario, Model modelo) {
		Usuario usuario = usuarioRepository.findById(IdUsuario).get();
		modelo.addAttribute("usuario", usuario);
		List<Rol> listaRoles = rolRepository.findAll();
		modelo.addAttribute("listaRoles", listaRoles);
		return "Admin/usuario_formulario";
	}

	@GetMapping("/usuarios/eliminar/{IdUsuario}")
	public String EliminarUsuario(@PathVariable("IdUsuario") Integer IdUsuario, Model modelo) {
		usuarioRepository.deleteById(IdUsuario);
		return "redirect:/usuarios";
	}

}
