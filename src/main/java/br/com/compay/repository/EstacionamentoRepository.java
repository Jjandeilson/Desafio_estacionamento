package br.com.compay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compay.model.Estacionamento;

@Repository // classe com métodos para manipulação da classe estacionamento
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer>{

	@Query(value="select * from estacionamento where ocupado = false",nativeQuery = true) //busca todas as disponiveis do estacionamento
	List<Estacionamento> vagasAbertas();
	
	@Query(value = "select * from estacionamento where ocupado = true", nativeQuery = true) // busca todas as vagas oculpadas do estacionamento
	List<Estacionamento> vagasFechadas();
	
	@Query(value = "select count(*) from estacionamento where ocupado = false", nativeQuery = true) //retorna a quantidade de vagas ocupadas no estacionamento
	Integer quantidadeVaga();
}
