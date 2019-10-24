package br.com.compay.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compay.model.Relatorio;
import br.com.compay.repository.EstacionamentoRepository;
import br.com.compay.repository.RelatorioRepository;

@Service // anotação que indica que essa classe é um da aplicação
public class RelatorioServiceIpml implements RelatorioService{

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private RelatorioRepository relatorioRepository;
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Override
	public void salvar(Relatorio relatorio) {
		relatorioRepository.save(relatorio);		
	}

	@Override
	public Relatorio enviarRelatorio() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = new Date();
		String dataF = sdf.format(data);
		Relatorio relatorio1 = new Relatorio();
		relatorio1.setData(data);
		relatorio1.setEstacionamento(estacionamentoRepository.quantidadeVaga());
		relatorio1.setQuantidadeCarro(quantidadeCarro(dataF));
		if(valorRecolhido(dataF) == 0) {
			relatorio1.setValor(0);
		}else {
			relatorio1.setValor(valorRecolhido(dataF));
		}	
		return relatorio1;
	}

	@Override
	public double valorRecolhido(String  data) {
		double valor;
		if(relatorioRepository.valorRecolhido(data) == null) {
			return valor = 0;
		}
		valor = relatorioRepository.valorRecolhido(data);
		return valor;
	}

	@Override
	public Integer quantidadeCarro(String data) {
		return relatorioRepository.quantidadeCarro(data);
	}
}
