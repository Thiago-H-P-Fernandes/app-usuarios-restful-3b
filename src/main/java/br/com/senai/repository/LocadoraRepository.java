package br.com.senai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.model.Locadora;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long>{
    
}
