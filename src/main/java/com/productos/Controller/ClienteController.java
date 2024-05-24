package com.productos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productos.Repository.ClienteRepository;
import com.productos.modelo.Cliente;




@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@GetMapping("/listaCliente")
	public String listaCliente(Model modelo) {
		List<Cliente> listaCliente = clienteRepository.findAll();
		modelo.addAttribute("listaCliente", listaCliente);
		return "Admin/Cliente";
		
	}
	
	@GetMapping("/listaCliente/nuevo")
	public String nuevoCliente(Model modelo) {
		modelo.addAttribute("cliente", new Cliente());
		return "Admin/nuevoCliente";
		
	}
	
	@PostMapping("/listaCliente/guardar")
	public String guardarCliente (Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/listaCliente";
		
	}
	@GetMapping("/listaCliente/editar/{IdCliente}")
	public String EditarCliente(@PathVariable("IdCliente")Integer IdCliente, Model modelo) {
		Cliente cliente = clienteRepository.findById(IdCliente).get();
		modelo.addAttribute("cliente", cliente);
		return"Admin/nuevoCliente";
	}
	@GetMapping("/listaCliente/eliminar/{IdCliente}")
	public String EliminarCliente(@PathVariable("IdCliente")Integer IdCliente , Model modelo) {
		clienteRepository.deleteById(IdCliente);
		return "redirect:/cliente";
	}	
	
}
