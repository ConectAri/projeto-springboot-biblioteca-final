package br.com.curso.bibliotecaref.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.bibliotecaref.entity.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {

}
