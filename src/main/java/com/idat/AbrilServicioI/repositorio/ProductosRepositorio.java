package com.idat.AbrilServicioI.repositorio;

import java.util.List;

import com.idat.AbrilServicioI.model.Productos;

public interface ProductosRepositorio {

	public void guardarProducto(Productos producto);
	public void editarProducto(Productos producto);
	public void eliminarProducto(Integer id);
	public List<Productos> listarProductos();
	public Productos obtenerProductoId(Integer id);
	
}
