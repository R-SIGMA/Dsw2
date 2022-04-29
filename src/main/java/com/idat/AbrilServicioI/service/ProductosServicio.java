package com.idat.AbrilServicioI.service;

import java.util.List;

import com.idat.AbrilServicioI.model.Productos;

public interface ProductosServicio {

	public void guardarProducto(Productos producto);
	public void editarProducto(Productos producto);
	public void eliminarProducto(Integer id);
	public List<Productos> listarProductos();
	public Productos obtenerProductoId(Integer id);
	
}
