package com.hospedaje.web.producto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hospedaje.web.producto.entity.Producto;

import reactor.core.publisher.Mono;


@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto,Integer> {
	
	Mono<Producto> findByIdProducto(Integer idProducto);
	

}
