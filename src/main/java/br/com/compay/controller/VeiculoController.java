package br.com.compay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.compay.model.EnumEstado;
import br.com.compay.model.Veiculo;
import br.com.compay.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private VeiculoService veiculoService;
	
	@PostMapping("/salvar")
	public ModelAndView salvarCarro(@Valid @ModelAttribute Veiculo veiculo,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("veiculo/cadastrarVeiculo");
			model.addObject("estados", EnumEstado.values());
			return model;
		}else {
			veiculoService.salvar(veiculo);
			attr.addFlashAttribute("menssagem", "Salvo com sucesso!.");
			return new ModelAndView("redirect:/veiculos");
		}
	}
	
//	@GetMapping("/buscar/{placaVeiculo}")
//	public ResponseEntity<?> buscarVeiculo(@PathVariable("placaVeiculo") String placaVeiculo){
//		Veiculo veiculo = veiculoService.buscar(placaVeiculo);
//		return ResponseEntity.ok(veiculo);
//	}
	
	@GetMapping("/veiculos/cadastrados")
	public ModelAndView veiculosCadastrados() {
		ModelAndView model = new ModelAndView("veiculo/veiculosCadastrados");
		List<Veiculo> veiculos = veiculoService.veiculosCadastrados();
		model.addObject("veiculos", veiculos);
		return model;
	}
	
	
}
