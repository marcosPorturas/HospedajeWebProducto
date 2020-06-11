package com.hospedaje.web.producto.dto.request;

public class ProductoRequest {

	private Integer idProducto;
	private String detalle;
	private Integer stock;
	private Double precioUnitario;
	
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
	
	
	
}
