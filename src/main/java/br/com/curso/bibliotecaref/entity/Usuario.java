package br.com.curso.bibliotecaref.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(nullable = false)
	protected String nome;
	
	@Column(nullable = false)
	protected String rg;
	
	@Column(nullable = false)
	protected String email;
	
	@OneToMany(mappedBy = "usuario")
	protected List<Emprestimo> emprestimos;
	
	@Column
	protected int totalEmprestimos;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String rg, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public String getEmail() {
		return email;
	}

	public int getTotalEmprestimos() {
		return totalEmprestimos;
	}

	public void setTotalEmprestimos(int totalEmprestimos) {
		this.totalEmprestimos = totalEmprestimos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract int getMaxDiasEmprestimoObra();
}
