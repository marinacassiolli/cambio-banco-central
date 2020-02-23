package br.com.fiap.nubank.cambio.domain;

import java.util.ArrayList;

public class Valor {
	
	private ArrayList<Cotacao> value;

	public Valor() { }
	
	public Valor(ArrayList<Cotacao> value) {
		super();
		this.value = value;
	}

	public ArrayList<Cotacao> getValue() {
		return value;
	}

	public void setValue(ArrayList<Cotacao> value) {
		this.value = value;
	}
	
	
}
