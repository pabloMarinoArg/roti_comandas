package com.comandas.rotiComanda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comandas.rotiComanda.entity.Producto;
import com.comandas.rotiComanda.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional
	public void crear (String  nombre, Double precio) {
		
		Producto prod = new Producto();
		
		prod.setNombre(nombre);
		prod.setPrecio(precio);
		
		productoRepository.save(prod);
		
	}
	
	@Transactional
	public void eliminar(Long id) {
		
		productoRepository.deleteById(id);
		
	}
	
	@Transactional
	public void modificar(Long id, String nombre, Double precio) {
		
		productoRepository.modificar(id, nombre, precio);
		
	}
	
	@Transactional(readOnly = true)
	public List<Producto> listProduct(){
		
		return productoRepository.findAll();
		
		
	}
	
	@Transactional(readOnly = true)
	public Producto buscarProdPorId(Long id) throws Exception {
		
		return productoRepository.findById(id).orElseThrow(()-> new Exception("No se encuentra el producto"));
		
		
	}
	
	
}
