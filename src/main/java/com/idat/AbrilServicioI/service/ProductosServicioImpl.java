package com.idat.AbrilServicioI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicioI.dto.ProductoDTORequest;
import com.idat.AbrilServicioI.dto.ProductoDTOResponse;
import com.idat.AbrilServicioI.model.Productos;
import com.idat.AbrilServicioI.repositorio.ProductosRepositorio;

@Service
public class ProductosServicioImpl implements ProductosServicio {

	@Autowired
	public ProductosRepositorio repositorio;
	
	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		repositorio.save(p);	
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		repositorio.saveAndFlush(p);		
	}

	@Override
	public void eliminarProducto(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		List<ProductoDTOResponse> listaresponse = new ArrayList<ProductoDTOResponse>();
		ProductoDTOResponse p = null;
		
		for (Productos producto : repositorio.findAll()) {
			p.setIdProductoDTO(producto.getIdProducto());
			p.setNombreProductoDTO(producto.getNombreProducto());
			p.setDescripcionDTO(producto.getDescripcion());
			p.setPrecioDTO(producto.getPrecio());
			p.setStockDTO(producto.getStock());
			listaresponse.add(p);
		}
		
		return listaresponse;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		Productos producto = repositorio.findById(id).orElse(null);
		
		ProductoDTOResponse p = new ProductoDTOResponse();
		p.setIdProductoDTO(producto.getIdProducto());
		p.setNombreProductoDTO(producto.getNombreProducto());
		p.setDescripcionDTO(producto.getDescripcion());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());
		return p;
	}

}
