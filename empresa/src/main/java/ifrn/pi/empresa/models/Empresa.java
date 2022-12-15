package ifrn.pi.empresa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String evento;
	private String espaco;
	private String data;
	private String horario;
	private String cidade;
	private String observacoes;
	private String barman;
	private String buffet;
	private String bandas;
	private String fotografos;
	private String decoracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getBarman() {
		return barman;
	}

	public void setBarman(String barman) {
		this.barman = barman;
	}

	public String getBuffet() {
		return buffet;
	}

	public void setBuffet(String buffet) {
		this.buffet = buffet;
	}

	public String getBandas() {
		return bandas;
	}

	public void setBandas(String bandas) {
		this.bandas = bandas;
	}

	public String getFotografos() {
		return fotografos;
	}

	public void setFotografos(String fotografos) {
		this.fotografos = fotografos;
	}

	public String getDecoracao() {
		return decoracao;
	}

	public void setDecoracao(String decoracao) {
		this.decoracao = decoracao;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", email=" + email + ", evento=" + evento + ", espaco=" + espaco + ", data=" + data + ", horario=" + horario + ", cidade=" + cidade + ", observacoes=" + observacoes + " barman=" + barman + ", buffet=" + buffet +", bandas=" + bandas + ", fotografos=" + fotografos + ", decoracao=" + decoracao +"]";
	}

}

	