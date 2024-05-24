package com.productos.Controller.vendedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.productos.Repository.EnviosRepository;
import com.productos.Repository.EstadoComprasRepository;
import com.productos.Repository.VentasRepository;
import com.productos.modelo.Envios;
import com.productos.modelo.Ventas;
import com.productos.modelo.estadocompras;



@Controller
public class EnviosVendedorController {
	
	@Autowired
	private EnviosRepository enviosRepository;
	
	@Autowired
    private EstadoComprasRepository estadoComprasRepository;
	
	@Autowired
	private VentasRepository ventasRepository;
	
	@GetMapping("/enviosVendedor")
	public String listarEnvios(Model modelo) {
		List<Envios> listarEnvios = enviosRepository.findAll();
		modelo.addAttribute("listarEnvios",listarEnvios);	
		return"vendedor/EnviosVendedor";
	}
	
	@GetMapping("/envioVendedor/nuevo")
	public String nuevoEnvio(Model modelo) {
		List<estadocompras> listaestado = estadoComprasRepository.findAll();
		List<Ventas> listaVentas = ventasRepository.findAll();
		modelo.addAttribute("envios",new Envios());
		modelo.addAttribute("listaestado",listaestado);
		modelo.addAttribute("listaVentas",listaVentas);
		
 		return"vendedor/NuevoEnvioVendedor";
	}
	
	@PostMapping("/enviosVendedor/guardar")
	public String guardarproductos(Envios envios) {
		enviosRepository.save(envios);
		return "redirect:/enviosVendedor";
		
	}
	@GetMapping("/enviosVendedor/editar/{IdEnvio}")
	public String EditarProducto(@PathVariable("IdEnvio")Integer IdEnvio, Model modelo) {
		Envios envios = enviosRepository.findById(IdEnvio).get();
		List<estadocompras> listaestado = estadoComprasRepository.findAll();
		List<Ventas> listaVentas = ventasRepository.findAll();
		modelo.addAttribute("envios",envios );
		modelo.addAttribute("listaestado",listaestado);
		modelo.addAttribute("listaVentas",listaVentas);
		
		return"vendedor/NuevoEnvioVendedor";
	}
}