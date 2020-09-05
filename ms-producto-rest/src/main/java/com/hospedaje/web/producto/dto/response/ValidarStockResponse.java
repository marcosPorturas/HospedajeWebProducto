package com.hospedaje.web.producto.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidarStockResponse {
	
	private List<ProductoStock> almacen;
	
	private List<ProductoStock> agotado;

	public List<ProductoStock> getAlmacen() {
		return almacen;
	}

	public void setAlmacen(List<ProductoStock> almacen) {
		this.almacen = almacen;
	}

	public List<ProductoStock> getAgotado() {
		return agotado;
	}

	public void setAgotado(List<ProductoStock> agotado) {
		this.agotado = agotado;
	}

}
