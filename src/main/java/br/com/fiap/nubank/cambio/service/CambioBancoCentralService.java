package br.com.fiap.nubank.cambio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.nubank.cambio.domain.Cotacao;
import br.com.fiap.nubank.cambio.domain.Valor;

@Service
public class CambioBancoCentralService {
	
	@Autowired
	private RestTemplate restTemplate;
	 
	@Value(value = "${bcb.endpoint.url.conversao}")
	private String urlBcbApiConversao;
	
	public Cotacao getCotacao(String moeda, String data) {
		final String uri = urlBcbApiConversao
		 		+ "(moeda=@moeda,dataCotacao=@dataCotacao)?"
		 		+ "@moeda='"+ moeda.toUpperCase() +"'&"
		 		+ "@dataCotacao='" + data + "'&"
		 		+ "$top=1&"
		 		+ "$orderby=dataHoraCotacao desc&"
		 		+ "$format=json&"
		 		+ "$select=cotacaoVenda,dataHoraCotacao";

		ArrayList<Cotacao> resultado = restTemplate
				 .getForObject(uri, Valor.class)
				 .getValue();
		
		if (resultado.isEmpty()) return null;
		
		return new Cotacao(
				moeda, 
				resultado.get(0).getCotacaoVenda(),
				resultado.get(0).getDataHoraCotacao());
	 }
}
