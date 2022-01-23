package com.comandas.rotiComanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comandas.rotiComanda.entity.Producto;
import com.comandas.rotiComanda.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		
		model.addAttribute("listaProductos", productoService.listProduct());
		model.addAttribute("title", "Listado de productos");
		
		return "listar_productos.html";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		
		model.addAttribute("title", "Crear producto");
		model.addAttribute("producto", new Producto());
		model.addAttribute("action", "guardar");
		
		return "crear_producto.html";
		
	}
	
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable Long id, Model model) throws Exception {
		
		model.addAttribute("title", "Modificar producto");
		model.addAttribute("producto", productoService.buscarProdPorId(id));
		model.addAttribute("action", "editar");
		
		return "crear_producto.html";
	}
	
	@PostMapping("/editar")
	public String editar(@RequestParam Long id, @RequestParam String nombre, @RequestParam Double precio) {
		
		productoService.modificar(id, nombre, precio);
		
		return "redirect:/producto/listar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam String nombre, @RequestParam Double precio) {
		
		productoService.crear(nombre, precio);
		
		return "redirect:/producto/listar";
	}
	
	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		
		productoService.eliminar(id);
		
		return "redirect:/producto/listar";
	}
	
	
	
	
}
