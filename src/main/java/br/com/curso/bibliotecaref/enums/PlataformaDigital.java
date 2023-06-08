package br.com.curso.bibliotecaref.enums;

public enum PlataformaDigital {
	
	SCIENCE("Science", "https://www.science.org/"),
	REVISTAS_USP("Revistas USP", "https://www.revistas.usp.br/wp/"),
	RBCMS("Revista Brasileira de Ciências Médicas e da Saúde", "http://www.rbcms.com.br/");
	
	private String descricao;
	
	private String url;

	private PlataformaDigital(String descricao, String url) {
		this.descricao = descricao;
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUrl() {
		return url;
	}

}
