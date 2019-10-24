package br.com.compay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compay.model.Veiculo;

@Repository // classe com métodos para manipulação da classe Veiculo
public interface VeiculoRepository extends JpaRepository<Veiculo, String>{

	//busca o veiculo pela númeração da placa
	Veiculo findByPlacaVeiculo(String placaVeiculo);
}
