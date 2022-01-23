package com.comandas.rotiComanda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comandas.rotiComanda.carroLista;
import com.comandas.rotiComanda.entity.Comanda;
import com.comandas.rotiComanda.entity.Producto;
import com.comandas.rotiComanda.entity.Ticket;
import com.comandas.rotiComanda.service.ComandaService;
import com.comandas.rotiComanda.service.ProductoService;
import com.comandas.rotiComanda.service.TicketService;



@Controller
@RequestMapping("/comanda")
public class ComandaController {

	@Autowired
	private ComandaService comandaService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/crear")
	public String crear(Model model) {
		
		model.addAttribute("comanda", new Comanda());
		
		
		
		return "crear_comanda.html";
	}
	
	
	
	@GetMapping("/agregarCarrito/{id}")
	public String agregarCarrito(@PathVariable Long id, Model model) {
		
		
		
		try {
			carroLista.cart.add(productoService.buscarProdPorId(id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		return "crear_comanda.html";
		
		
	}

	@GetMapping("/listarCarro")
	public String  listar(Model model) {
		
		model.addAttribute("lista", carroLista.cart);
		
		
		
		return "lista.html";
		
	}
	 
	
	
	
	
	

	
	
}
