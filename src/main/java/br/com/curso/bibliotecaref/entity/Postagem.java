package br.com.curso.bibliotecaref.entity;

import java.util.Date;

import br.com.curso.bibliotecaref.enums.PlataformaDigital;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_POSTAGEM")
@PrimaryKeyJoinColumn(name = "idObra")
public class Postagem extends ObraDigital {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public PlataformaDigital plataforma;
	
	@Column(nullable = false)
	private String conteudo;

	public Postagem() {
	}

	public Postagem(Long id, String titulo, Date dataPublicacao, String url, PlataformaDigital plataforma, String conteudo) {
		super(id, titulo, dataPublicacao, url);
		this.plataforma = plataforma;
		this.conteudo = conteudo;
	}

	public PlataformaDigital getPlataforma() {
		return plataforma;
	}

	public String getConteudo() {
		return conteudo;
	}

}
