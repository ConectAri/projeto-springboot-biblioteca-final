package br.com.curso.bibliotecaref.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ObraFisica extends Obra {

	@Column(nullable = false)
	protected String codLocalizacao;

	public ObraFisica() {
	}

	public ObraFisica(Long id, String titulo, Date dataPublicacao, String codLocalizacao) {
		super(id, titulo, dataPublicacao);
		this.codLocalizacao = codLocalizacao;
	}

	public String getCodLocalizacao() {
		return codLocalizacao;
	}

	public void setCodLocalizacao(String codLocalizacao) {
		this.codLocalizacao = codLocalizacao;
	}

}
