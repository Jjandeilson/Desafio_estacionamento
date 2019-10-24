package br.com.compay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compay.model.Vaga;

@Repository // classe com métodos para manipulação da classe vaga
public interface VagaRepository extends JpaRepository<Vaga, Integer>{

//	@Query(value = "select * from vaga where fk_placa_veiculo = :placa", nativeQuery = true)
//	Vaga buscarVagaOcupada(@Param("placa") String placa);
	
	//retorna o veiculo  que não saiu da vaga do estacionamento
	@Query(value = "select * from vaga where fk_placa_veiculo = :placa and hora_saida is null", nativeQuery = true)
	Vaga buscarCarroNaVaga(@Param("placa") String placa);
}
