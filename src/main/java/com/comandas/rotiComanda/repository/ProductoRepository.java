package com.comandas.rotiComanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comandas.rotiComanda.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Modifying
	@Query("UPDATE Producto p SET p.nombre=:nombre, p.precio=:precio WHERE p.id=:id")
	void modificar(@Param("id") Long id, @Param("nombre") String nombre, @Param("precio") Double precio);
	
}
