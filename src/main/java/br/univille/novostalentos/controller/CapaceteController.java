package br.univille.novostalentos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Capacete;
import br.univille.novostalentos.service.CapaceteService;

@Controller
@RequestMapping("/capacete")
public class CapaceteController {
    @Autowired
    private CapaceteService service;

    @GetMapping
    public ModelAndView index() {
        var listaCapacetes = service.getAll();
        return new ModelAndView("capacete/index", "listaCapacetes", listaCapacetes);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var capaceteNovo = new Capacete();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("capacete", capaceteNovo);
        return new ModelAndView("capacete/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Capacete capacete) {

        service.save(capacete);

        return new ModelAndView("redirect:/capacete");
    }

    @GetMapping("/search/{nome}")
    public ModelAndView alterar(@PathVariable("nome") String nome) {
        var listaCapacetes = service.findByNome(nome);
        return new ModelAndView("capacete/index", "listaCapacetes", listaCapacetes);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umCapacete = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("capacete", umCapacete);
        return new ModelAndView("capacete/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/capacete");
    }

    @GetMapping("/ordenar/{ordem}")
    public ModelAndView alterar(@PathVariable("ordem") int ordem) {
        var listaCapacetes = service.order(ordem);
        return new ModelAndView("capacete/index", "listaCapacetes", listaCapacetes);
    }

}
