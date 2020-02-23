package br.com.fiap.nubank.cambio.domain;

public class Cotacao {
	
	private String moeda;
	private double cotacaoVenda;
	private String dataHoraCotacao;

	public Cotacao() { }
	
	public Cotacao(String moeda, double cotacaoVenda, String dataHoraCotacao) {
		super();
		this.moeda = moeda;
		this.cotacaoVenda = cotacaoVenda;
		this.dataHoraCotacao = dataHoraCotacao;
	}

	public double getCotacaoVenda() {
		return cotacaoVenda;
	}
	
	public void setCotacaoVenda(double cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}
	
	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
		
}
