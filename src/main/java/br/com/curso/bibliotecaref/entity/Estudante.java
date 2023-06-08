package br.com.curso.bibliotecaref.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESTUDANTE")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Estudante extends Usuario {
	
	private static final int MAX_EMPRESTIMOS = 5;
	
	@Column(nullable = false)
	private String matricula;

	public Estudante() {
	}

	public Estudante(Long id, String nome, String rg, String email, String matricula) {
		super(id, nome, rg, email);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int getMaxDiasEmprestimoObra() {	
		return MAX_EMPRESTIMOS;
	}

}
