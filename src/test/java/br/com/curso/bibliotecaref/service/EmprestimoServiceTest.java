package br.com.curso.bibliotecaref.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.curso.bibliotecaref.entity.Emprestimo;
import br.com.curso.bibliotecaref.entity.Obra;
import br.com.curso.bibliotecaref.entity.Usuario;
import br.com.curso.bibliotecaref.exception.ServiceException;
import br.com.curso.bibliotecaref.repository.EmprestimoRepository;
import br.com.curso.bibliotecaref.repository.ObraRepository;
import br.com.curso.bibliotecaref.repository.UsuarioRepository;
import br.com.curso.bibliotecaref.templates.ObraTemplate;
import br.com.curso.bibliotecaref.templates.UsuarioTemplate;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class EmprestimoServiceTest {
	
	@Mock
	private EmprestimoRepository repository;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@Mock
	private ObraRepository obraRepository;
	
	@InjectMocks
	private EmprestimoService service = new EmprestimoService();

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		FixtureFactoryLoader.loadTemplates("br.com.curso.bibliotecaref.templates");
	}
	
	@Test
	public void testObraNaoEncontrada() {
		Usuario estudante = UsuarioTemplate.getEstudante();
		
		when(usuarioRepository.findById(estudante.getId())).thenReturn(
				Optional.of(estudante));
		when(obraRepository.findById(1l)).thenReturn(Optional.ofNullable(null));
		
		Exception exception = assertThrows(ServiceException.class, () -> {
	        service.realizaEmprestimo(estudante.getId(), 1l);
	    });

	    String mensagemEsperada = "Usuário e/ou obra não localizado(s).";
	    String mensagemAtual = exception.getMessage();

	    assertTrue(mensagemAtual.contains(mensagemEsperada));
	}
	
	@Test
	public void testUsuarioNaoEncontrado() {
		Obra obra = ObraTemplate.getLivro();
		
		when(usuarioRepository.findById(1l)).thenReturn(Optional.ofNullable(null));
		when(obraRepository.findById(obra.getId())).thenReturn(Optional.of(obra));
		
		Exception exception = assertThrows(ServiceException.class, () -> {
	        service.realizaEmprestimo(1l, obra.getId());
	    });

	    String mensagemEsperada = "Usuário e/ou obra não localizado(s).";
	    String mensagemAtual = exception.getMessage();

	    assertTrue(mensagemAtual.contains(mensagemEsperada));
	}
	
	@Test
	public void testEstudanteExcedeLimite() {
		Usuario estudante = UsuarioTemplate.getEstudanteExcedeLimite();
		Obra obra = ObraTemplate.getLivro();
		
		when(usuarioRepository.findById(estudante.getId())).thenReturn(
				Optional.of(estudante));
		when(obraRepository.findById(obra.getId())).thenReturn(Optional.of(obra));
		
		Exception exception = assertThrows(ServiceException.class, () -> {
	        service.realizaEmprestimo(estudante.getId(), obra.getId());
	    });

	    String mensagemEsperada = "Usuário já está com sua quantidade máxima "
				+ "de obras emprestadas.";
	    String mensagemAtual = exception.getMessage();

	    assertTrue(mensagemAtual.contains(mensagemEsperada));
	}
	
	@Test
	public void testProfessorExcedeLimite() {
		Usuario professor = UsuarioTemplate.getProfessorExcedeLimite();
		Obra obra = ObraTemplate.getLivro();
		
		when(usuarioRepository.findById(professor.getId())).thenReturn(
				Optional.of(professor));
		when(obraRepository.findById(obra.getId())).thenReturn(Optional.of(obra));
		
		Exception exception = assertThrows(ServiceException.class, () -> {
	        service.realizaEmprestimo(professor.getId(), obra.getId());
	    });

	    String mensagemEsperada = "Usuário já está com sua quantidade máxima "
				+ "de obras emprestadas.";
	    String mensagemAtual = exception.getMessage();

	    assertTrue(mensagemAtual.contains(mensagemEsperada));		
	}
	
	@Test
	public void testEmprestimoRealizado() {
		Usuario professor = UsuarioTemplate.getProfessor();
		Obra obra = ObraTemplate.getLivro();
		Emprestimo emprestimo = new Emprestimo(1l, new Date(), professor, obra);
		
		int totalEmprestimosAntes = professor.getTotalEmprestimos();
		
		when(usuarioRepository.findById(professor.getId())).thenReturn(
				Optional.of(professor));
		when(obraRepository.findById(obra.getId())).thenReturn(Optional.of(obra));
		
		when(repository.save(any(Emprestimo.class))).thenReturn(emprestimo);
		
		when(usuarioRepository.save(professor)).thenReturn(professor);
		
		Emprestimo result = null;
		try {
			result = service.realizaEmprestimo(professor.getId(), obra.getId());
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
		
		assertNotNull(result);
		assertTrue(professor.getTotalEmprestimos() == (totalEmprestimosAntes + 1));
	}
}
