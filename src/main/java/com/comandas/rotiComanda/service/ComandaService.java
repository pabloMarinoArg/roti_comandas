package com.comandas.rotiComanda.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comandas.rotiComanda.entity.Comanda;
import com.comandas.rotiComanda.entity.Ticket;
import com.comandas.rotiComanda.repository.ComandaRepository;


@Service
public class ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private TicketService ticketService;
	

	@Transactional
	public void crear(String direccion, String nombreCliente, String numeroTel, String comentarios, List<Ticket> lista) {
		
		Comanda comanda = new Comanda();
		comanda.setFecha(LocalDate.now());
		comanda.setDireccion(direccion);
		comanda.setListaProductos(lista);
		comanda.setNombreCliente(nombreCliente);
		comanda.setNumeroTel(numeroTel);
		comanda.setDireccion(direccion);
		comanda.setComentarios(comentarios);
		
		comandaRepository.save(comanda);

	}
	
	
	
	
	@Transactional(readOnly = true)
	public List<Comanda> listaComandas() {

		return comandaRepository.findAll();

	}

	@Transactional(readOnly = true)
	public Comanda findComandaById(Long id) throws Exception {

		return comandaRepository.findById(id).orElseThrow(() -> new Exception("No existe la comanda"));

	}

	@Transactional
	public void eliminar(Long id) {

		comandaRepository.deleteById(id);

	}
	
	
	public List<Ticket> agregarCarrito(List<Ticket> lista) {
		
		return lista;
	}
	
	

}
