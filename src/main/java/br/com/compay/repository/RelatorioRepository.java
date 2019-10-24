package br.com.compay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compay.model.Relatorio;

@Repository // classe com métodos para manipulação da classe relatorio
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer>{

	@Query(value="select sum(valor) from relatorio where data_relatorio = :data", nativeQuery = true)
	Double valorRecolhido(@Param("data") String data);
	
	@Query(value = "select count(data_relatorio) from relatorio where data_relatorio = :data", nativeQuery = true)
	Integer quantidadeCarro(@Param("data") String data);
}
