package jpa.jpa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.jpa.dominio.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}