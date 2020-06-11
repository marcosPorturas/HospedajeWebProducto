package com.hospedaje.web.producto.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class ProductoResponse implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer idProducto;
	private String detalle;
	private Integer stock;
	private Double precioUnitario;
	private String creationDate;
	private boolean enabled;
	
	public ProductoResponse () {
		super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getDetalle() {
		return detalle;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
