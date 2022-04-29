package com.idat.AbrilServicioI.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.AbrilServicioI.model.Productos;

@Repository
public class ProductosRepositorioImpl implements ProductosRepositorio{

	public List<Productos> listar = new ArrayList<>();
	
	@Override
	public void guardarProducto(Productos producto) {
		listar.add(producto);		
	}

	@Override
	public void editarProducto(Productos producto) {
		listar.remove(obtenerProductoId(producto.getIdProducto()));
		listar.add(producto);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		listar.remove(obtenerProductoId(id));
	}

	@Override
	public List<Productos> listarProductos() {
		return listar;
	}

	@Override
	public Productos obtenerProductoId(Integer id) {
		return listar.stream().filter(producto -> producto.getIdProducto() == id).findFirst().orElse(null);
	}

}
