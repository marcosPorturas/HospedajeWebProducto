package com.hospedaje.web.producto.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hospedaje.web.producto.config.ApplicationProperties;
import com.hospedaje.web.producto.dto.request.ProductoRequest;
import com.hospedaje.web.producto.dto.response.ProductoResponse;
import com.hospedaje.web.producto.entity.Producto;
import com.hospedaje.web.producto.repository.ProductoRepository;
import com.hospedaje.web.producto.util.Utilitario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImplement implements ProductoService{

	private static final Logger LOG = LoggerFactory.getLogger(ProductoServiceImplement.class);
	
	Gson gson = new Gson();
	
	@Autowired
	ApplicationProperties properties;
	
	@Autowired
	ProductoRepository productoRepository;

	
	@Override
	public Flux<ProductoResponse> listarProductos(HttpHeaders headers) {
		return productoRepository.findAll()
				.map(this::productoResponseDto);
	}

	@Override
	public Mono<ProductoResponse> obtenerProducto(Integer idProducto) {
		return productoRepository.findById(idProducto)
				.map(this::productoResponseDto);
	}

	@Override
	public Mono<ProductoResponse> agregarProducto(ProductoRequest socioRequest,HttpHeaders headers) {
		return productoRepository.save(getProductoEntity(socioRequest))
				.map(this::productoResponseDto);
	}
	
	@Override
	public Flux<ProductoResponse> listarProductosXIds(List<Integer> idProductos) {
		return productoRepository.findAllById(idProductos)
				.map(this::productoResponseDto);
	}
	
	
	private ProductoResponse productoResponseDto(Producto producto) {
		return ProductoResponse.builder()
				.idProducto(producto.getIdProducto())
				.detalle(producto.getDetalle())
				.stock(producto.getStock())
				.precioUnitario(producto.getPrecioUnitario())
				.creationDate(Utilitario.convertirFechaddMMYYYY(producto.getCreationDate()))
				.enabled(producto.isEnabled()).build();
				
	}
	
	private Producto getProductoEntity(ProductoRequest productoRequest) {
		return Producto.builder()
				.idProducto(productoRequest.getIdProducto())
				.detalle(productoRequest.getDetalle())
				.stock(productoRequest.getStock())
				.creationDate(new Date())
				.enabled(true)
				.precioUnitario(productoRequest.getPrecioUnitario()).build();
	}

}
;