package com.idat.AbrilServicioI.service;

import java.util.List;

import com.idat.AbrilServicioI.dto.ProductoDTORequest;
import com.idat.AbrilServicioI.dto.ProductoDTOResponse;
import com.idat.AbrilServicioI.model.Productos;

public interface ProductosServicio {

	public void guardarProducto(ProductoDTORequest producto);
	public void editarProducto(ProductoDTORequest producto);
	public void eliminarProducto(Integer id);
	public List<ProductoDTOResponse> listarProductos();
	public ProductoDTOResponse obtenerProductoId(Integer id);
	
}
