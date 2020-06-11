package com.hospedaje.web.producto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationProperties {
	
	@Value("${socio.codigo.idf0}")
	public String socioCodigoIdf0;

	@Value("${socio.codigo.idf1}")
	public String socioCodigoIdf1;
	
	@Value("${socio.codigo.idt3}")
	public String socioCodigoIdt3;
	
	@Value("${socio.mensaje.idf0}")
	public String socioMensajeIdf0;

	@Value("${socio.mensaje.idf1}")
	public String socioMensajeIdf1;
	
	@Value("${socio.codigo.idt3}")
	public String socioMensajeIdt3;
	
	@Value("${metodo.listarsocios}")
	public String metodoListarSocios;
	
	@Value("${metodo.obtenersocio}")
	public String metodoObtenerSocio;
	
	@Value("${metodo.agregarsocio}")
	public String metodoAgregarSocio;
	
	
}
