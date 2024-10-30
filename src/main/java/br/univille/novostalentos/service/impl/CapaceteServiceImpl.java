package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Capacete;
import br.univille.novostalentos.repository.CapaceteRepository;
import br.univille.novostalentos.service.CapaceteService;

@Service
public class CapaceteServiceImpl implements CapaceteService {

    @Autowired
    private CapaceteRepository repositorio;

    @Override
    public List<Capacete> getAll() {

        return repositorio.findAll();
    }

    @Override
    public void save(Capacete produto) {
        repositorio.save(produto);

    }

    @Override
    public Capacete findById(long id) {
        var result = repositorio.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Capacete();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

}
