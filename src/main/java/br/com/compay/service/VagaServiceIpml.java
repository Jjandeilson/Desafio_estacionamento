package br.com.compay.service;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compay.model.Estacionamento;
import br.com.compay.model.Relatorio;
import br.com.compay.model.Vaga;
import br.com.compay.repository.EstacionamentoRepository;
import br.com.compay.repository.VagaRepository;


@Service // anotação que indica que essa classe é um da aplicação
public class VagaServiceIpml implements VagaService{

	@Autowired // injeção da interface repository que contém métodos a serem utilizados
	private VagaRepository vagaRepository;
	
	@Autowired 
	private EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	private RelatorioService relatorioService;

	@Override
	public void salvar(Vaga vaga) {
		LocalTime time = LocalTime.parse(vaga.getHora());
		Estacionamento e = estacionamentoRepository.getOne(vaga.getEstacionamento().getIdVaga());
		e.setOcupado(true);
		vaga.setHoraEntrada(time);
		Vaga v = vagaRepository.buscarCarroNaVaga(vaga.getVeiculo().getPlacaVeiculo());
		if(v != null) {
			System.out.println("Carro já oculpa uma vaga");
		}else {
			estacionamentoRepository.save(e);
			vagaRepository.save(vaga);
		}
	}

	@Override
	public Vaga buscarVagaOcupada(String placa) {
		Vaga v = vagaRepository.buscarCarroNaVaga(placa);
		return v;
	}

	@Override
	public void desoculpaVaga(Vaga vaga) {
		LocalTime time = LocalTime.parse(vaga.getHora());
		Relatorio r = new Relatorio();
		Date data = new Date();
		Estacionamento e = estacionamentoRepository.getOne(vaga.getEstacionamento().getIdVaga());
		e.setOcupado(false);
		r.setData(data);
		vaga.setHoraSaida(time);
		r.setValor(calcularValor(vaga.getHoraEntrada().toString(), vaga.getHora()));
		estacionamentoRepository.save(e);
		vagaRepository.save(vaga);	
		relatorioService.salvar(r);
	}

	@Override
	public double calcularValor(String entrada, String saida) {
		entrada = entrada.replace(":", ".");
		saida = saida.replace(":", ".");
		double valorEntrada = Double.parseDouble(entrada);
		double valorSaida = Double.parseDouble(saida);
		double resultado = valorSaida - valorEntrada;
		
		if(resultado <= 3 ) {
			resultado = 7;
			System.out.println(resultado);
		}else {
			resultado = 7 + ((resultado -3) * 3);
			System.out.println(resultado);
		}
		return resultado;
	}

//	@Override
//	public double calcularValor(String entrada, String saida) {
//		entrada = entrada.replace(":", ".");
//		saida = saida.replace(":", ".");
//		double valorEntrada = Double.parseDouble(entrada);
//		double valorSaida = Double.parseDouble(saida);
//		double resultado = valorSaida - valorEntrada;
//		double resultadoMais = resultado % 3;
//		double valorFinal = 0;
//		
//		if(resultado % 3 == 0) {
//			valorFinal = (resultado / 3) * 7;
//		}else if(resultado < 3) {
//			valorFinal = 7;
//		}else {
//			valorFinal = (((resultado - resultadoMais) / 3) * 7) + (resultadoMais * 3);
//		}
//		return valorFinal;
//	}
	
	
}
