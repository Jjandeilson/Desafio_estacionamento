package br.com.compay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compay.model.Veiculo;
import br.com.compay.repository.VeiculoRepository;

@Service // anotação que indica que essa classe é um da aplicação
public class VeiculoServiceIpml implements VeiculoService{

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private VeiculoRepository veiculoRepository;

	@Override
	public void salvar(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}

	@Override
	public Veiculo buscar(String placaVeiculo) {
		Veiculo veiculo = veiculoRepository.findByPlacaVeiculo(placaVeiculo);
		return veiculo;
	}

	@Override
	public List<Veiculo> veiculosCadastrados() {
		return veiculoRepository.findAll();
	}

}
