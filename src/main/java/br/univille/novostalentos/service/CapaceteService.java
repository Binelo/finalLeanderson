package br.univille.novostalentos.service;

import java.util.List;

import br.univille.novostalentos.entity.Capacete;

public interface CapaceteService {
    List<Capacete> getAll();

    void save(Capacete capacete);

    Capacete findById(long id);

    List<Capacete> findByNome(String nome);

    List<Capacete> order(int ordem);

    long getTotalCapacetes();

    long getValorTotalCapacetes();

    void delete(long id);
}
