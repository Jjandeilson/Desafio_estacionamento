package br.com.compay.service;

import java.util.List;

import br.com.compay.model.Estacionamento;

// intarface com métodos a serem implementados
public interface EstacionamentoService {

//	List<Estacionamento> listaDevagas();
	
	List<Estacionamento> vagasAbertas();
	
	List<Estacionamento> vagasFechadas();
	
	Estacionamento quantidadeVaga();
}
