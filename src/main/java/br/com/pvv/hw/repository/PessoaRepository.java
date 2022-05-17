package br.com.pvv.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pvv.hw.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
