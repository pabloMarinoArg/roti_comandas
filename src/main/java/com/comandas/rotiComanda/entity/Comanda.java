package com.comandas.rotiComanda.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Comanda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha;
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> listaProductos;
	
	private String nombreCliente;
	private String numeroTel;
	
	private String comentarios;
	
	
	
	@PrePersist
	public void setearFecha() {
		this.fecha= LocalDate.now();
		this.listaProductos = new ArrayList<>();
		}
	
	Double precioTotal() {
		Double total = 0.00;
		for (Ticket ticket : listaProductos) {
			total+=ticket.getImporte();
		}
		
		return total;
	}
	
}
