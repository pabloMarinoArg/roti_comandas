package com.comandas.rotiComanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comandas.rotiComanda.entity.Producto;
import com.comandas.rotiComanda.entity.Ticket;
import com.comandas.rotiComanda.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Transactional
	public void crear (Producto producto, Integer cantidad) {
		
		Ticket ticket = new Ticket();
		
		ticket.setProducto(producto);
		ticket.setCantidad(cantidad);
		
		ticketRepository.save(ticket);
	}
	
	@Transactional
	public void eliminar(Long id) {
		
		ticketRepository.deleteById(id);
		
	}
	
	@Transactional(readOnly = true)
	public List<Ticket> listar (){
		
		return ticketRepository.findAll();
		
	}
	
	@Transactional(readOnly = true)
	public Ticket buscarPorId(Long id) throws Exception {
		
		return ticketRepository.findById(id).orElseThrow(()->new Exception("No se encuentra"));
		
	}
	
}
