package br.com.compay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estacionamento") // classe responsavel por realizar todo mapeamento do estacionamento
public class Estacionamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idVaga;
	private Boolean ocupado;
	
	@Transient
	private Integer quantidadeVagas;
	
	public Integer getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
	
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}
	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVaga == null) ? 0 : idVaga.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (idVaga == null) {
			if (other.idVaga != null)
				return false;
		} else if (!idVaga.equals(other.idVaga))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Estacionamento [idVaga=" + idVaga + ", ocupado=" + ocupado + ", quantidadeVagas=" + quantidadeVagas
				+ "]";
	}
	
	
}
