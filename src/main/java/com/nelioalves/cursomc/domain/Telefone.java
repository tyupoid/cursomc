package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Telefone  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String numero;

	public Telefone() {
	}

	public Telefone(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	
	

}
