package com.comandas.rotiComanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comandas.rotiComanda.entity.Producto;
import com.comandas.rotiComanda.entity.Ticket;
import com.comandas.rotiComanda.service.ProductoService;
import com.comandas.rotiComanda.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/crear")
	public String crear(Model model) {
		
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("productos", productoService.listProduct());
		model.addAttribute("action", "guardar");
		return "ticket.html";
	}
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam Producto producto, @RequestParam Integer cantidad) {
		
		ticketService.crear(producto, cantidad);
		
		return "redirect:/comanda";
	}
	
}
