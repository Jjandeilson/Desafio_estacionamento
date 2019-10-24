package br.com.compay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity // classe com informações do veiculo
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@Size(max=8)
	@Column(name= "placa_veiculo")
	@NotEmpty
	private String placaVeiculo;
	
	@Size(min = 8, max = 60)
	@Column(name = "cliente")
	@NotEmpty
	private String nomeDoCliente;
	
	@NotEmpty
	private String cidade;
	
	
	@NotEmpty
	private String uf;
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (placaVeiculo == null) {
			if (other.placaVeiculo != null)
				return false;
		} else if (!placaVeiculo.equals(other.placaVeiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [placaVeiculo=" + placaVeiculo + ", nomeDoCliente=" + nomeDoCliente + ", cidade=" + cidade
				+ ", uf=" + uf + "]";
	}
	
}
