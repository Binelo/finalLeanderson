package br.univille.novostalentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Capacete;

@Repository
public interface CapaceteRepository extends JpaRepository<Capacete, Long> {
    List<Capacete> findByNomeContainingIgnoreCase(String nome);

}
