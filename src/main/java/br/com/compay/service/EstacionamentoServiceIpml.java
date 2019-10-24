package br.com.compay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compay.model.Estacionamento;
import br.com.compay.repository.EstacionamentoRepository;

@Service // anotação que indica que essa classe é um da aplicação
public class EstacionamentoServiceIpml implements EstacionamentoService{

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private EstacionamentoRepository estacionamentoRepository;

//	@Override
//	public List<Estacionamento> listaDevagas() {
//		return estacionamentoRepository.findAll();
//	}

	@Override
	public List<Estacionamento> vagasAbertas() {
		return estacionamentoRepository.vagasAbertas();
	}

	@Override
	public List<Estacionamento> vagasFechadas() {
		return estacionamentoRepository.vagasFechadas();
	}

	@Override
	public Estacionamento quantidadeVaga() {
		Estacionamento e = new Estacionamento();
		e.setQuantidadeVagas(estacionamentoRepository.quantidadeVaga());
		return e;
	}
}
