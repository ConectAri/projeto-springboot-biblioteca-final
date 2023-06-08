package br.com.curso.bibliotecaref;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaReferenciaApplication {

	public static final Logger log = LoggerFactory.getLogger(BibliotecaReferenciaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaReferenciaApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner executar(LivroRepository livroRepository, EmprestimoService emprestimoService) {
		return(args) -> {
			// Apagando todos os livros
			livroRepository.deleteAll();

			String titulo = "Dom Casmurro";
			String autor = "Machado de Assis";
			String codLocalizacao = "ABC123";
			String isbn = "123456789";
			Date dataPublicacao = (new SimpleDateFormat("dd/MM/yyyy")).parse("12/03/1879");

			Livro livro = new Livro(null, titulo, dataPublicacao, codLocalizacao, autor, isbn);
			livroRepository.save(livro);

			log.info("Listando livros cadastrados...");
			List<Livro> livros = livroRepository.findAll();
			log.info(livros.toString());

			log.info("Pesquisando um livro pelo ISBN");
			livro = livroRepository.findByIsbn(isbn);
			log.info(livro.toString());

			log.info("Pesquisando livros por nome do autor ou titulo");
			livros = livroRepository.buscaPorAutorOuTitulo("Assis", "Dom");
			log.info(livros.toString());

			log.info("Pesquisando livros por titulo ou nome do autor");
			livros = livroRepository.buscaPorTituloOuAutor("Dom", "Assis");
			log.info(livros.toString());

			log.info("Pesquisando quantos anos faz que um livro foi publicado");
			log.info(livro.toString());
			log.info("Este livro foi publicado a " + 
					livroRepository.quantosAnosPublicacaoLivro(livro.getId()) + " anos.");
			
			log.info("Pesquisando livros ordenados por titulo");
			livros = livroRepository.buscaTodosOrdenadosTitulo();
			log.info(livros.toString());
			
			log.info("Pesquisando livros ordenados por autor");
			livros = livroRepository.buscaTodosOrdenadosAutor();
			log.info(livros.toString());
			
			log.info("Pesquisando o livro mais antigo");
			log.info(livroRepository.buscaMaisAntigo());
			
			log.info("Atualizando o ISBN de um livro");
			livroRepository.atualizaIsbnLivro(livro.getId(), "XXX");
			Optional<Livro> optLivro = livroRepository.findById(livro.getId());
			if (optLivro.isPresent()) {
				log.info(optLivro.get().toString());	
			}

			log.info("Apagando um livro");
			livroRepository.apagaLivro(livro.getId());
			optLivro = livroRepository.findById(livro.getId());
			if (optLivro.isEmpty()) {
				log.info("Livro removido com sucesso.");	
			}
			
			log.info("Verificando quantos empréstimos estão em atraso ...");
			Integer atrasos = emprestimoService.quantidadeEmAtraso();
			log.info(String.format("Temos %d empréstimo(s) em atraso.", (atrasos == null) ? 0 : atrasos) );
		};
	}
*/
}
