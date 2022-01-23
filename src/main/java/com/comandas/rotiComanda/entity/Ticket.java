package com.comandas.rotiComanda.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	@ManyToOne
	private Producto producto;

	public Double getImporte() {
		
		return cantidad.doubleValue()*this.producto.getPrecio();
	}
	
	public void aumentarCantidad() {
		
		this.cantidad++;
		
	}
	
	
	
	
}
