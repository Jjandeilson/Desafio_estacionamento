package br.com.compay.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "vaga") // classe que aloca o veiculo a vaga do estacionamento
public class Vaga implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_vaga")
	@NotNull
	private Estacionamento estacionamento;
	
	@OneToOne
	@JoinColumn(name = "fk_placa_veiculo")
	@NotNull
	private Veiculo veiculo;
	
	@JsonFormat(pattern = "HH:mm")
	@Column(name = "hora_entrada")
	private LocalTime horaEntrada;
	
	@JsonFormat(pattern = "HH:mm")
	@Column(name = "hora_saida")
	private LocalTime horaSaida;
	
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonFormat(pattern = "kk:mm:ss")
	private String hora;
	
	public Vaga() {}
	
	public Vaga(Veiculo veiculo) {
		super();
		this.veiculo = veiculo;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public LocalTime getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estacionamento == null) ? 0 : estacionamento.hashCode());
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
		Vaga other = (Vaga) obj;
		if (estacionamento == null) {
			if (other.estacionamento != null)
				return false;
		} else if (!estacionamento.equals(other.estacionamento))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vaga [id=" + id + ", estacionamento=" + estacionamento + ", veiculo=" + veiculo + ", horaEntrada="
				+ horaEntrada + ", horaSaida=" + horaSaida + ", hora=" + hora + "]";
	}
}
