package com.productos.Controller.vendedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.productos.Repository.ClienteRepository;
import com.productos.Repository.EnviosRepository;
import com.productos.Repository.InventarioRepository;
import com.productos.Repository.ProductosRepository;
import com.productos.Repository.VendedorRepository;
import com.productos.Repository.VentasRepository;
import com.productos.modelo.Cliente;
import com.productos.modelo.Envios;
import com.productos.modelo.Inventario;
import com.productos.modelo.Productos;
import com.productos.modelo.Vendedor;
import com.productos.modelo.Ventas;


@Controller
public class VentasVendedorController {
	

	
		@Autowired
		private ClienteRepository clienteRepository;
		
		
	    @Autowired
	    private VendedorRepository vendedorRepository;
	    
		@Autowired
		private ProductosRepository productosRepository;

	    
	    @Autowired
	    private InventarioRepository inventarioRepository;
	    

	    
	    @Autowired
	    private VentasRepository ventasRepository;
	    
	    @Autowired
	    private EnviosRepository enviosRepository;
	    
	    
		@GetMapping("/ventasVendedor")
		public String listarVentas(Model modelo) {
			List<Ventas>listarVentas= ventasRepository.findAll();
			modelo.addAttribute("listarVentas", listarVentas);
			return "vendedor/VentasVendedor";
			
		}
		
		@GetMapping("/ventasVendedor/nuevo")
		public String nuevaVenta(Model modelo) {
			List<Cliente>listaCliente = clienteRepository.findAll();
			List<Vendedor>listaVendedor = vendedorRepository.findAll();
			List<Inventario>listaInventario = inventarioRepository.findAll();
			List<Envios>listaEnvios = enviosRepository.findAll();
			List<Productos>listaProductos = productosRepository.findAll();
			modelo.addAttribute("Ventas",new Ventas());
			modelo.addAttribute("listaCliente", listaCliente);
			modelo.addAttribute("listaVendedor", listaVendedor);
			modelo.addAttribute("listaInventario", listaInventario);
			modelo.addAttribute("listaEnvios", listaEnvios);
			modelo.addAttribute("listaProductos", listaProductos);
			
	 		return"vendedor/NuevoVentaVendedor";
		}
		@PostMapping("/ventasVendedor/guardar")
		public String guardarproductos(Ventas ventas) {
			ventasRepository.save(ventas);
			return "redirect:/ventasVendedor";
			
		}
		
		@GetMapping("/ventasVendedor/editar/{IdVenta}")
		public String EditarVenta(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
		    Ventas ventas = ventasRepository.findById(IdVenta).get();
			modelo.addAttribute("Ventas", ventas );
			List<Cliente>listaCliente = clienteRepository.findAll();
			List<Vendedor>listaVendedor = vendedorRepository.findAll();
			List<Inventario>listaInventario = inventarioRepository.findAll();
			List<Envios>listaEnvios = enviosRepository.findAll();
			List<Productos>listaProductos = productosRepository.findAll();
			modelo.addAttribute("listaCliente", listaCliente);
			modelo.addAttribute("listaVendedor", listaVendedor);
			modelo.addAttribute("listaInventario", listaInventario);
			modelo.addAttribute("listaEnvios", listaEnvios);
			modelo.addAttribute("listaProductos", listaProductos);
			
			return"vendedor/NuevoVentaVendedor";
			
		}
		
		@GetMapping("/ventasVendedor/eliminar/{IdVenta}")
		public String EliminarInsumo(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
	           ventasRepository.deleteById(IdVenta);
			return "redirect:/ventasVendedor";
			
			
		}
		
}
