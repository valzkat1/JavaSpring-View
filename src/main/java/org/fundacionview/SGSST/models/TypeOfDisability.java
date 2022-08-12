package org.fundacionview.SGSST.models;

import org.springframework.stereotype.Component;

@Component
public class TypeOfDisability {

	public String nombre; 
	public String valor;
	
	public TypeOfDisability() {
		super();
	}

	public TypeOfDisability(String nombre, String valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	} 
	
	
}
