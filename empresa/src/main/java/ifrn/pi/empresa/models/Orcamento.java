package ifrn.pi.empresa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomedocliente;
	private String email;
	private String tipodeevento;
	private String espaco;
	private String data;
	private String horario;
	private String cidade;
	private String observacoes;

	@ManyToMany
	private List<Servico> servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspaco() {
		return espaco;
	}

	public void setEspaco(String espaco) {
		this.espaco = espaco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getNomedocliente() {
		return nomedocliente;
	}

	public void setNomedocliente(String nomedocliente) {
		this.nomedocliente = nomedocliente;
	}

	public String getTipodeevento() {
		return tipodeevento;
	}

	public void setTipodeevento(String tipodeevento) {
		this.tipodeevento = tipodeevento;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", nomedocliente=" + nomedocliente + ", email=" + email + ", tipodeevento="
				+ tipodeevento + ", espaco=" + espaco + ", data=" + data + ", horario=" + horario + ", cidade=" + cidade
				+ ", observacoes=" + observacoes + "]";
	}

}
