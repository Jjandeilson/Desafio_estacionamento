package br.com.compay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.compay.model.Estacionamento;
import br.com.compay.model.Vaga;
import br.com.compay.model.Veiculo;
import br.com.compay.service.EstacionamentoService;
import br.com.compay.service.VagaService;
import br.com.compay.service.VeiculoService;

@Controller
public class VagaController {

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private VagaService vagaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private EstacionamentoService estacionamentoService;
	
	@PostMapping("/veiculo/buscar")
	public ModelAndView buscarVeiculo(@ModelAttribute Veiculo veiculo, RedirectAttributes att) {
		Vaga vaga = new Vaga();
		ModelAndView model = new ModelAndView("vaga/estacionarVeiculo");
		Veiculo v = veiculoService.buscar(veiculo.getPlacaVeiculo());
		List<Estacionamento> estacionamentos = estacionamentoService.vagasAbertas();
		
		if(v == null) {
			att.addFlashAttribute("menssagem", "Veiculo não é cadastrado no sistema, Cadastre-se no sistema!");
			return new ModelAndView("redirect:/index");
		}
		
		vaga.setVeiculo(veiculo);
		model.addObject("vaga", vaga);
		model.addObject("estacionamentos", estacionamentos);
		return model;		
	}
	
	@PostMapping("/estacionar/veiculo")
	public ModelAndView salva(@ModelAttribute Vaga vaga, RedirectAttributes att) {
		Vaga vaga1 = vagaService.buscarVagaOcupada(vaga.getVeiculo().getPlacaVeiculo());
		if(vaga1 != null) {
			att.addFlashAttribute("menssagem", "Carro já está em uma vaga.");
			return new ModelAndView("redirect:/index");
		}
		
		vagaService.salvar(vaga);
		att.addFlashAttribute("menssagem", "Veiculo salvo na vaga.");
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/estacionar/veiculo")
	public ModelAndView estacionarVeiculo(Vaga vaga) {
		ModelAndView model = new ModelAndView("/vaga/estacionarVeiculo");
		List<Estacionamento> estacionamentos = estacionamentoService.vagasAbertas();
		model.addObject("estacionamentos", estacionamentos);
		return model;
	}
	
	@PostMapping("/liberar")
	public ModelAndView liberarVaga(@ModelAttribute Vaga vaga,BindingResult result, RedirectAttributes att) {
		
		att.addFlashAttribute("menssagem", "Vaga liberada. Valor pago: " + 
				String.format("%.2f", vagaService.calcularValor(vaga.getHoraEntrada().toString(), vaga.getHora())));
		vagaService.desoculpaVaga(vaga);
		return new ModelAndView("redirect:/index");
		
	}
	
	@PostMapping("/sair")
	public ModelAndView sairDavaga(@ModelAttribute Vaga vaga, BindingResult result, RedirectAttributes att) {
		
		if(vaga.getVeiculo() == null) {
			att.addFlashAttribute("menssagem", "Preencha o campo com a placa correta");
			return new ModelAndView("redirect:/sair");
		}
		
		Vaga vaga1 = vagaService.buscarVagaOcupada(vaga.getVeiculo().getPlacaVeiculo());
		
		if(vaga1 == null) {
			att.addFlashAttribute("menssagem", "Veiculo não ocupa nenhum vaga");
			return new ModelAndView("redirect:/sair");
		}
		
		ModelAndView model = new ModelAndView("vaga/sairDaVaga");
		model.addObject("vaga", vaga1);
		return model;
	}
	
	@GetMapping("/sair")
	public String vagaDoCarro(@ModelAttribute Vaga vaga) {
		return "vaga/sairDaVaga";
	}	
}
