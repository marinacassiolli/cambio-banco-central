package br.com.fiap.nubank.cambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.nubank.cambio.domain.Cotacao;
import br.com.fiap.nubank.cambio.service.CambioBancoCentralService;

@RestController
@RequestMapping("/cambio-banco-central")
public class CambioBancoCentalController {
	
	@Autowired
	public CambioBancoCentralService cambioBancoCentralService;
	
	@GetMapping("/{moeda}/cotacao")
	public ResponseEntity<Cotacao> cotacao(
			@PathVariable String moeda, 
			@RequestParam(required = true) String data) {
		
		Cotacao cotacaoEncontrada = cambioBancoCentralService.getCotacao(moeda, data);
		
		if (cotacaoEncontrada == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(cotacaoEncontrada);
	}	
}