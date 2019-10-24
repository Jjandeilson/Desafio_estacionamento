package br.com.compay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.compay.model.Estacionamento;
import br.com.compay.service.EstacionamentoService;

@RestController
@RequestMapping("/vagas")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoService estacionamentoService;
	
	@GetMapping("/abertas")
	public ModelAndView vagasAbertas(){
		ModelAndView model = new ModelAndView("estacionamento/estacionamentoVagas");
		List<Estacionamento> estacionamentos = estacionamentoService.vagasAbertas();
		model.addObject("estacionamentos",estacionamentos);
		return model;
	}
	
	@GetMapping("/fechadas")
	public ModelAndView vafasFechadas(){
		ModelAndView model = new ModelAndView("estacionamento/estacionamentoSemVagas");
		List<Estacionamento> estacionamentos = estacionamentoService.vagasFechadas();
		model.addObject("estacionamentos", estacionamentos);
		return model;
	}
	
	@GetMapping("/quantidade")
	public ResponseEntity<Estacionamento> quantidadeVaga(){
		return ResponseEntity.ok(estacionamentoService.quantidadeVaga());
	}
}
