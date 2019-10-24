package br.com.compay.service;

import java.util.List;

import br.com.compay.model.Veiculo;

//intarface com métodos a serem implementados
public interface VeiculoService {

	void salvar(Veiculo veiculo);
	Veiculo buscar(String placaVeiculo);
	List<Veiculo> veiculosCadastrados();
}
