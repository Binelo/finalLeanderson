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
    public void save(Capacete capacete) {
        repositorio.save(capacete);

    }

    @Override
    public List<Capacete> findByNome(String nome) {
        return repositorio.findByNomeContainingIgnoreCase(nome);
    }

    public List<Capacete> order(int ordem) {
        List<Capacete> capacetes = repositorio.findAll();
        
        capacetes.sort((c1, c2) -> {
            double valorTotalC1 = c1.getValor();
            double valorTotalC2 = c2.getValor();
            
            if (ordem == 1) {
                return Double.compare(valorTotalC2, valorTotalC1);
            } else {
                return Double.compare(valorTotalC1, valorTotalC2);
            }
        });
        
        return capacetes;
    }

    public long getTotalCapacetes() {
        long total = 0;
        List<Capacete> capacetes = repositorio.findAll();
        
        for (Capacete capacete : capacetes) {
            total += capacete.getQuantidade();
        }
        
        return total;
    }

    public long getValorTotalCapacetes() {
        long totalValor = 0;
        
        List<Capacete> capacetes = repositorio.findAll();
        
        for (Capacete capacete : capacetes) {
            totalValor += capacete.getQuantidade() * capacete.getValor();
        }
        
        return totalValor;
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
