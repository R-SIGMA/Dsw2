package com.idat.AbrilServicioI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AbrilServicioI.model.Productos;
import com.idat.AbrilServicioI.service.ProductosServicio;

@RestController
@RequestMapping("/producto/v1")
public class ProductosController {

	@Autowired
	private ProductosServicio servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Productos>> listarProductos(){
		return new ResponseEntity<List<Productos>>(servicio.listarProductos(), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Productos producto){
		servicio.guardarProducto(producto);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Productos> listarPorId(@PathVariable Integer id) {
		Productos p = servicio.obtenerProductoId(id);
		
		if(p != null)
			return new ResponseEntity<Productos>(p, HttpStatus.OK);
		
		return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> editar(@RequestBody Productos producto){
		Productos p = servicio.obtenerProductoId(producto.getIdProducto());
		
		if(p != null) {
			servicio.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Productos p = servicio.obtenerProductoId(id);
		
		if(p != null) {
			servicio.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
