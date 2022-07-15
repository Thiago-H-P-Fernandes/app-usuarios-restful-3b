package br.com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
}
