package br.com.curso.bibliotecaref.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_EXEMPLAR_OBRA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Obra {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(nullable = false)
	protected String titulo;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	protected Date dataPublicacao;

	public Obra() {
	}

	public Obra(Long id, String titulo, Date dataPublicacao) {
		this.id = id;
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	@JsonInclude
	public String getDataPublicacaoFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataPublicacao);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
