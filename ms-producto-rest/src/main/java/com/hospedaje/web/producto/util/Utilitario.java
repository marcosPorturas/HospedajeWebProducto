package com.hospedaje.web.producto.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hospedaje.web.producto.dto.response.ProductoResponse;
import com.hospedaje.web.producto.entity.Producto;

public class Utilitario {
	
	
	
	public static String convertirFechaddMMYYYY (Date date) {
		String dateConvert = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateConvert = sdf.format(date);
		return dateConvert;
	}
	
	
}
