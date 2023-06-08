package br.com.curso.bibliotecaref.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.bibliotecaref.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
