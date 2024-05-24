package com.productos.Controller.vendedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.productos.Repository.CategoriasRepository;
import com.productos.Repository.ProductosRepository;
import com.productos.Repository.UnidadMedidaRepository;
import com.productos.modelo.Categorias;
import com.productos.modelo.Productos;
import com.productos.modelo.UnidadesMedida;


@Controller

public class ProductosVendedorController {


	@Autowired
	private CategoriasRepository categoriaRepository;
	
	
	@Autowired
	private ProductosRepository productosRepository;
	
	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository; 
	
	
	@GetMapping("/productosVendedor")
	public String listarProductos(Model modelo) {
		List<Productos> listarProductos = productosRepository.findAll();
		modelo.addAttribute("listarProductos", listarProductos);	
		return"vendedor/ProductosVendedor";
	}	
	
	@GetMapping("/productosVendedor/nuevo")
	public String nuevoProducto(Model modelo) {
		List<UnidadesMedida> listaUnidad = unidadMedidaRepository.findAll();
		List<Categorias> listaCategoria = categoriaRepository.findAll();
		modelo.addAttribute("productos",new Productos());
		modelo.addAttribute("listaUnidad", listaUnidad);
		modelo.addAttribute("listaCategoria", listaCategoria);
		
 		return"vendedor/NuevoProductoVendedor";
	}
	
	@PostMapping("/productosVendedor/guardar")
	public String guardarproductos(Productos productos) {
		productosRepository.save(productos);
		return "redirect:/productosVendedor";
		
	}
	
	@GetMapping("/productosVendedor/editar/{IdProducto}")
	public String EditarProducto(@PathVariable("IdProducto")Integer IdProducto, Model modelo) {
		Productos productos= productosRepository.findById(IdProducto).get();
		modelo.addAttribute("productos", productos);
		List<UnidadesMedida> listaUnidad = unidadMedidaRepository.findAll();
		List<Categorias> listaCategoria = categoriaRepository.findAll();
		modelo.addAttribute("listaUnidad",listaUnidad);
		modelo.addAttribute("listaCategoria", listaCategoria);
		return"vendedor/NuevoProductoVendedor";
		
	}
	
	@GetMapping("/productosVendedor/eliminar/{IdProducto}")
	public String EliminarUsuario(@PathVariable("IdProducto")Integer IdProducto, Model modelo) {
           productosRepository.deleteById(IdProducto);
		return "redirect:/productosVendedor";
		
		
	}
	
}
