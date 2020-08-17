package com.hospedaje.web.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospedaje.web.producto.dto.request.ProductoConsumoRequest;
import com.hospedaje.web.producto.dto.request.ProductoRequest;
import com.hospedaje.web.producto.dto.response.ProductoResponse;
import com.hospedaje.web.producto.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Validated
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("/listar")
	public Flux<ProductoResponse> listarProductos(@RequestHeader HttpHeaders headers){
		return productoService.listarProductos(headers);
	}
	
	@GetMapping
	public Mono<ProductoResponse> obtenerProducto(@RequestParam("idproducto")Integer idProducto,
			@RequestParam("cantidad")Integer cantidad){
		if(cantidad==null)cantidad=0;
		return productoService.obtenerProducto(idProducto,cantidad);
	}
	
	@PostMapping("/agregar")
	public Mono<ProductoResponse> agregarProducto(@RequestBody ProductoRequest productoRequest,@RequestHeader HttpHeaders headers){
		return productoService.agregarProducto(productoRequest,headers);
	}
	
	@PutMapping("/{idProducto}")
	public Mono<ProductoResponse> actualizarProducto(@RequestBody ProductoRequest productoRequest,@RequestHeader HttpHeaders headers){
		return productoService.agregarProducto(productoRequest, headers);
	}
	
	@PostMapping("/agotado")
	public Flux<ProductoResponse> validarStock(@RequestBody List<ProductoConsumoRequest> lstProductoConsumo){
		return productoService.listarProductosAgotados(lstProductoConsumo);
	}
}
