package com.dobrychtop.desafiojava.repository;

import com.dobrychtop.desafiojava.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
