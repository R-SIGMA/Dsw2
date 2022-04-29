package com.idat.AbrilServicioI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicioI.model.Productos;
import com.idat.AbrilServicioI.repositorio.ProductosRepositorio;

@Service
public class ProductosServicioImpl implements ProductosServicio {

	@Autowired
	public ProductosRepositorio repositorio;
	
	@Override
	public void guardarProducto(Productos producto) {
		repositorio.guardarProducto(producto);	
	}

	@Override
	public void editarProducto(Productos producto) {
		repositorio.editarProducto(producto);		
	}

	@Override
	public void eliminarProducto(Integer id) {
		repositorio.eliminarProducto(id);
	}

	@Override
	public List<Productos> listarProductos() {
		return repositorio.listarProductos();
	}

	@Override
	public Productos obtenerProductoId(Integer id) {
		return repositorio.obtenerProductoId(id);
	}

}
