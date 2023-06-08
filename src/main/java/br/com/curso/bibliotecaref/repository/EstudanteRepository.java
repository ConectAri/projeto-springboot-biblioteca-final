package br.com.curso.bibliotecaref.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.bibliotecaref.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
