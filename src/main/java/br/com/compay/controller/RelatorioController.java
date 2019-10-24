package br.com.compay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compay.model.Relatorio;
import br.com.compay.service.RelatorioService;

@RestController
@RequestMapping("/enviar/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioService relatorioService;

	@GetMapping
	public Relatorio enviarRelatorio() {
		return relatorioService.enviarRelatorio();
	}
}
