package br.com.curso.bibliotecaref.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.bibliotecaref.entity.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {

}
