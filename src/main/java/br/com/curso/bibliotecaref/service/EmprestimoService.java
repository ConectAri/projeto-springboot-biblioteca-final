package br.com.curso.bibliotecaref.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.bibliotecaref.entity.Emprestimo;
import br.com.curso.bibliotecaref.entity.Obra;
import br.com.curso.bibliotecaref.entity.Usuario;
import br.com.curso.bibliotecaref.exception.ServiceException;
import br.com.curso.bibliotecaref.repository.EmprestimoRepository;
import br.com.curso.bibliotecaref.repository.ObraRepository;
import br.com.curso.bibliotecaref.repository.UsuarioRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ObraRepository obraRepository;
	
	@Transactional
	public Integer quantidadeEmAtraso() {
		return repository.quantidadeEmAtraso();
	}
	
	@Transactional(rollbackFor = ServiceException.class)
	public Emprestimo realizaEmprestimo(Long usuarioId, Long obraId) throws ServiceException {
		Optional<Usuario> optUsuario = usuarioRepository.findById(usuarioId);
		Optional<Obra> optObra = obraRepository.findById(obraId);
		
		if (optUsuario.isEmpty() || optObra.isEmpty()) {
			throw new ServiceException("Usuário e/ou obra não localizado(s).");
		}
		
		Usuario usuario = optUsuario.get();
		Obra obra = optObra.get();
		
		Emprestimo emprestimo = new Emprestimo(null, new Date(), usuario, obra);
		emprestimo = repository.save(emprestimo);
		
		int totalObras = usuario.getTotalEmprestimos() + 1;
		if (totalObras > usuario.getMaxDiasEmprestimoObra()) {
			throw new ServiceException("Usuário já está com sua quantidade máxima "
					+ "de obras emprestadas.");
		}
		
		usuario.setTotalEmprestimos(totalObras);
		usuarioRepository.save(usuario);
		
		return emprestimo;
	}

}
