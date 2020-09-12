package com.hospedaje.web.producto.service;

import java.util.List;

import org.springframework.http.HttpHeaders;

import com.hospedaje.web.producto.dto.request.ProductoConsumoRequest;
import com.hospedaje.web.producto.dto.request.ProductoRequest;
import com.hospedaje.web.producto.dto.response.ProductoResponse;
import com.hospedaje.web.producto.dto.response.ValidarStockResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

	public Flux<ProductoResponse> listarProductos(HttpHeaders headers);
	public Mono<ProductoResponse> obtenerProducto(Integer idProducto,Integer cantidad);
	public Mono<ProductoResponse> agregarProducto(ProductoRequest socioRequest,HttpHeaders headers);
	public Mono<ValidarStockResponse> listarProductosAgotados(List<ProductoConsumoRequest> productoConsumoRequest);
	public Flux<ProductoResponse> actualizarStockProductos(List<ProductoConsumoRequest> productoConsumoRequest);
}
