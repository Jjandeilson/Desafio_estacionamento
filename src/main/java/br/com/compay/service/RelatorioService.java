package br.com.compay.service;

import br.com.compay.model.Relatorio;

//intarface com métodos a serem implementados
public interface RelatorioService {

	void salvar(Relatorio relatorio);
	Relatorio enviarRelatorio();
	double valorRecolhido(String data);
	Integer quantidadeCarro(String data);
}
