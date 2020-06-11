package com.hospedaje.web.producto.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Document(collection="producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Field("id_producto")
	private Integer idProducto;
	@Field("detalle")
	private String detalle;
	@Field("apellidos")
	private Integer stock;
	@Field("precio_unitario")
	private Double precioUnitario;
	@Field("creation_date")
	private Date creationDate;
	@Field("update_date")
	private Date updateDate;
	@Field("enabled")
	private boolean enabled;
	
	public Producto() {
		super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getDetalle() {
		return detalle;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
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

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
}
