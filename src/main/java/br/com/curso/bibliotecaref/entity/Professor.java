package br.com.curso.bibliotecaref.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PROFESSOR")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Professor extends Usuario {
	
	public static final int MAX_EMPRESTIMOS = 10;
	
	@Column(nullable = false)
	private String titulacao;

	public Professor() {
	}

	public Professor(Long id, String nome, String rg, String email, String titulacao) {
		super(id, nome, rg, email);
		this.titulacao = titulacao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public int getMaxDiasEmprestimoObra() {
		return MAX_EMPRESTIMOS;
	}

}
