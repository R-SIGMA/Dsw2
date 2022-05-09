package com.idat.AbrilServicioI.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.AbrilServicioI.model.Productos;

@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Integer> {
	
}
