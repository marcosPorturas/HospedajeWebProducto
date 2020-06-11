package com.hospedaje.web.producto.service;

import org.springframework.http.HttpHeaders;

import com.hospedaje.web.producto.dto.request.ProductoRequest;
import com.hospedaje.web.producto.dto.response.ProductoResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

	public Flux<ProductoResponse> listarProductos(HttpHeaders headers);
	public Mono<ProductoResponse> obtenerProducto(Integer idSocio);
	public Mono<ProductoResponse> agregarProducto(ProductoRequest socioRequest,HttpHeaders headers);
	
}
