package br.com.curso.bibliotecaref.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_EMPRESTIMO")
@NamedStoredProcedureQuery(
		name = "atrasos",
		procedureName = "proc_qtde_emprestimos_em_atraso",
		parameters = {
				@StoredProcedureParameter(
						mode = ParameterMode.OUT,
						name = "quantidade",
						type = Integer.class)
		})
public class Emprestimo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@OneToOne
	@JoinColumn(name = "idObra", referencedColumnName = "id")
	private Obra obra;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
	private Usuario usuario;

	public Emprestimo() {
	}

	public Emprestimo(Long id, Date data, Usuario usuario, Obra obra) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
		this.obra = obra;
	}

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Obra getObra() {
		return obra;
	}

}
