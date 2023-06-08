package br.com.curso.bibliotecaref.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EXEMPLAR_LIVRO")
@PrimaryKeyJoinColumn(name = "idObra")
@NamedQueries({
	@NamedQuery(name = "buscaTodosOrdenadosTitulo", query = "FROM Livro ORDER BY titulo"),
	@NamedQuery(name = "buscaTodosOrdenadosAutor", query = "FROM Livro ORDER BY autor")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "buscaMaisAntigo", query = "SELECT \r\n"
			+ "  o.titulo \r\n"
			+ "FROM \r\n"
			+ "  biblioteca.tb_exemplar_livro l,\r\n"
			+ "  biblioteca.tb_exemplar_obra o\r\n"
			+ "WHERE\r\n"
			+ "  l.id_obra = o.id\r\n"
			+ "ORDER BY\r\n"
			+ "  o.data_publicacao\r\n"
			+ "LIMIT 1")
})
public class Livro extends ObraFisica {

	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private String isbn;

	public Livro() {
	}

	public Livro(Long id, String titulo, Date dataPublicacao, String codLocalizacao, String autor, String isbn) {
		super(id, titulo, dataPublicacao, codLocalizacao);
		this.autor = autor;
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + ", codLocalizacao="
				+ codLocalizacao + ", autor=" + autor + ", isbn=" + isbn + "]";
	}

}
