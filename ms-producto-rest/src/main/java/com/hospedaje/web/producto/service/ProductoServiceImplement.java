package com.hospedaje.web.producto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.hospedaje.web.producto.config.ApplicationProperties;
import com.hospedaje.web.producto.dto.request.ProductoConsumoRequest;
import com.hospedaje.web.producto.dto.request.ProductoRequest;
import com.hospedaje.web.producto.dto.response.ProductoResponse;
import com.hospedaje.web.producto.dto.response.ProductoStock;
import com.hospedaje.web.producto.dto.response.ValidarStockResponse;
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
	public Mono<ProductoResponse> obtenerProducto(Integer idProducto,Integer cantidad) {
		return productoRepository.findById(idProducto)
				.map(this::productoResponseDto);
	}

	@Override
	public Mono<ProductoResponse> agregarProducto(ProductoRequest socioRequest,HttpHeaders headers) {
		return productoRepository.save(getProductoEntity(socioRequest))
				.map(this::productoResponseDto);
	}
	
	@Override
	public Flux<ProductoResponse> listarProductosXIds(int[] idProductos) {
		List<Integer> lstIdProductos = Arrays.stream(idProductos).boxed().collect(Collectors.toList());
		return productoRepository.findAllById(lstIdProductos)
				.map(this::productoResponseDto);
	}
	
	@Override
	public Mono<ValidarStockResponse> listarProductosAgotados(List<ProductoConsumoRequest> productoConsumoRequest) {
		
		List<ProductoStock> almacen = new ArrayList<>();
		List<ProductoStock> agotado = new ArrayList<>();
		
		List<Integer> lstIdProductos = new ArrayList<>();
		productoConsumoRequest.forEach(request->
			lstIdProductos.add(request.getIdProducto())
		);
		
		return Flux.zip(
				productoRepository.findAllById(lstIdProductos),
				Flux.fromIterable(productoConsumoRequest))
				.map(tupla->{
					if(tupla.getT1().getStock()<tupla.getT2().getCantidad()) {
						agotado.add(setProductoStock(tupla.getT1(),tupla.getT2()));
					}else {
						almacen.add(setProductoStock(tupla.getT1(),tupla.getT2()));
					}
					return ValidarStockResponse.builder().agotado(agotado).almacen(almacen).build();
				}).single();
				
				
		
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

	private ProductoStock setProductoStock(Producto producto,ProductoConsumoRequest productoConsumoRequest) {
		return ProductoStock.builder()
				.idProducto(producto.getIdProducto())
				.detalle(producto.getDetalle())
				.cantidad(productoConsumoRequest.getCantidad())
				.precioUnitario(producto.getPrecioUnitario())
				.subTotal(producto.getPrecioUnitario()*productoConsumoRequest.getCantidad())
				.build();
	}
}
