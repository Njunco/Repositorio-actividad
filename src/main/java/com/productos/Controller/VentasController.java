package com.productos.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.productos.Repository.ClienteRepository;
import com.productos.Repository.EnviosRepository;
import com.productos.Repository.InventarioRepository;
import com.productos.Repository.ProductosRepository;
import com.productos.Repository.VendedorRepository;
import com.productos.Repository.VentasProductoRepository;
import com.productos.Repository.VentasRepository;
import com.productos.modelo.Cliente;
import com.productos.modelo.Envios;
import com.productos.modelo.Inventario;
import com.productos.modelo.Productos;
import com.productos.modelo.Vendedor;
import com.productos.modelo.Ventas;
import com.productos.modelo.VentasProducto;


@Controller
public class VentasController {
	
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
	    
	    @Autowired
	    private VentasProductoRepository ventasProductoRepository;
	    	    
		@GetMapping("/ventas")
		public String listarVentas(Model modelo) {
			List<Ventas>listarVentas= ventasRepository.findAll();
			modelo.addAttribute("listarVentas", listarVentas);
			return "Admin/Ventas";
		}
		
		@GetMapping("/ventas/nuevo")
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
	 		return"Admin/NuevoVenta2";
		}
		
		@PostMapping("/ventas/guardar")
		@ResponseBody
		public ResponseEntity  guardarproductos(Ventas ventas) throws Exception{
			ventas.setFechaVenta(new Date());
			ventas.setCiudadCompra("Activo");
			int idVenta =  ventasRepository.save(ventas).getIdVenta();
			String json = String.format("{\"id\": %s}", idVenta);
			return new ResponseEntity(json, HttpStatus.OK);
		}
		
		@PostMapping("/ventas/editar")
		@ResponseBody
		public ResponseEntity editarVenta(Ventas ventas) throws Exception{
			ventas.setFechaVenta(new Date());
			ventas.setCiudadCompra("Activo");
			ventasRepository.save(ventas);
			deleteVentasProducto(ventas.getIdVenta());
			return new ResponseEntity(HttpStatus.OK);
		}
		
		@PostMapping("/ventas_productos/guardar")
		@ResponseBody
		public ResponseEntity guardarventasproductos(VentasProducto ventasProductos) throws Exception{
			try {
				guardarInventarioProducto(ventasProductos.getProductos().getIdProducto(), ventasProductos.getCantidadCompra());
				ventasProductoRepository.save(ventasProductos);
			}catch(Exception e) {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity(HttpStatus.OK);
		}

		private void guardarInventarioProducto(int idProducto, int cantidad){
			Productos producto = productosRepository.findById(idProducto).get();
			int cantidadNueva = producto.getCantidadEmpaque() - cantidad;
			producto.setCantidadEmpaque(cantidadNueva);
			productosRepository.save(producto);
		}
		
		@GetMapping("/ventas/editar/{IdVenta}")
		public String EditarVenta(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
		    Ventas ventas = ventasRepository.findById(IdVenta).get();
			modelo.addAttribute("Ventas", ventas );
			List<Cliente>listaCliente = clienteRepository.findAll();
			List<Vendedor>listaVendedor = vendedorRepository.findAll();
			List<Inventario>listaInventario = inventarioRepository.findAll();
			List<Envios>listaEnvios = enviosRepository.findAll();
			List<Productos>listaProductos = productosRepository.findAll();
			List<Productos>listaProductosVenta =  getProductosVenta(IdVenta);
			modelo.addAttribute("listaCliente", listaCliente);
			modelo.addAttribute("listaVendedor", listaVendedor);
			modelo.addAttribute("listaInventario", listaInventario);
			modelo.addAttribute("listaEnvios", listaEnvios);
			modelo.addAttribute("listaProductos", listaProductos);
			modelo.addAttribute("listaProductosVenta", listaProductosVenta);
			return"Admin/EditarVenta";
		}
		
		@GetMapping("/ventas/ver/{IdVenta}")
		public String VerVenta(@PathVariable("IdVenta")Integer IdVenta, Model modelo) {
		    Ventas ventas = ventasRepository.findById(IdVenta).get();
		    List<Productos> productos = getProductosVenta(IdVenta);
		    modelo.addAttribute("Ventas", ventas);
		    modelo.addAttribute("listaProductos", productos);
			return"Admin/VerVenta";
		}
		
		private List<Productos> getProductosVenta(int idVenta) {
		    List<Productos> productos = new ArrayList<Productos>();
		    ventasProductoRepository.findAll().forEach(x -> {
		    	if(x.getVentas().getIdVenta() == idVenta) {
		    		Productos producto = x.getProductos();
		    		producto.setCantidadEmpaque(x.getCantidadCompra());
		    		productos.add(producto);
		    	}
		    });
		    return productos;
		}
		
		@GetMapping("/ventas/eliminar/{IdVenta}")
		@ResponseBody
		public ResponseEntity EliminarInsumo(@PathVariable("IdVenta")Integer idVenta) {
          
           List<VentasProducto> ventasProductos = new ArrayList<VentasProducto>();
           deleteVentasProducto(idVenta);
           ventasRepository.deleteById(idVenta);
           String json = String.format("{\"delete\": %s}", true);
           return new ResponseEntity(json, HttpStatus.OK);
		}
		
		private void deleteVentasProducto(int idVenta) {
			ventasProductoRepository.findAll().forEach(ventasProducto -> {
        	   if(ventasProducto.getVentas().getIdVenta() == idVenta) {
        		   guardarInventarioProducto(ventasProducto.getProductos().getIdProducto(), -ventasProducto.getCantidadCompra());
        		   ventasProductoRepository.deleteById(ventasProducto.getIdVentaProducto());
        	   }
           	});
		}
		
		@GetMapping("/ventas/addProduct/{idProducto}")
		@ResponseBody
		public ResponseEntity AddProduct(@PathVariable("idProducto")Integer idProducto, Model modelo)
		{
			Productos product = productosRepository.findById(idProducto).get();
			String json = String.format("{\"id\": %s, \"nombre\": \"%s\", \"precio\":%s}",
					product.getIdProducto(), product.getNombreProducto(), product.getPrecio());
			return new ResponseEntity(json, HttpStatus.OK);
		}
		
		@SuppressWarnings("unchecked")
		@GetMapping("/ventas/validarProducto/{idProducto}/{cantidad}")
		@ResponseBody
		private ResponseEntity validarCantidadValida(@PathVariable("idProducto")Integer idProducto, @PathVariable("cantidad")Integer cantidad) {
			boolean isValid = true;
			Productos product = productosRepository.findById(idProducto).get();
			int nuevaCantidad = product.getCantidadEmpaque() - cantidad;
			
			if(nuevaCantidad < 0) {
				isValid = false;
			}
			String json = String.format("{\"isValid\": %s, \"cantidad\": %s}", isValid, product.getCantidadEmpaque());
			return new ResponseEntity(json, HttpStatus.OK);
		}
}
