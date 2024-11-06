package br.univille.novostalentos.service;

import java.util.List;

import br.univille.novostalentos.entity.Capacete;

public interface CapaceteService {
    List<Capacete> getAll();

    void save(Capacete produto);

    Capacete findById(long id);

    void delete(long id);
}
