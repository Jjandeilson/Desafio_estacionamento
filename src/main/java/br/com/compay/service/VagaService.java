package br.com.compay.service;

import br.com.compay.model.Vaga;

//intarface com métodos a serem implementados
public interface VagaService {

	void salvar(Vaga vaga);
	Vaga buscarVagaOcupada(String placa);
	void desoculpaVaga(Vaga vaga);
	double calcularValor(String entrada, String saida);
}
