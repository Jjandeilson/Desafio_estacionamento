package br.com.compay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.compay.model.EnumEstado;
import br.com.compay.model.Estacionamento;
import br.com.compay.model.Veiculo;
import br.com.compay.service.EstacionamentoService;

@Controller
public class PaginaController {
	
	@Autowired
	private EstacionamentoService estacionamentoService;	

	@GetMapping({"/", "/index"})
	public ModelAndView index(Veiculo veiculo) {
		ModelAndView model = new ModelAndView("index");
		Estacionamento e = estacionamentoService.quantidadeVaga();
		model.addObject("numeroVagas",e);
		return model;
	}
	
	@GetMapping("/veiculos")
	public ModelAndView paginaDeCadastro(Veiculo veiculo) {
		ModelAndView model = new ModelAndView("veiculo/cadastrarVeiculo");
		model.addObject("estados", EnumEstado.values());
		return model;
	}
	
}
