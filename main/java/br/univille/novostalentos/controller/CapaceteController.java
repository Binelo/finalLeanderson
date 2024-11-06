package br.univille.novostalentos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Capacete;
import br.univille.novostalentos.service.CapaceteService;

@Controller
@RequestMapping("/")
public class CapaceteController {
    @Autowired
    private CapaceteService service;

    @GetMapping
    public ModelAndView index() {
        var listaProdutos = service.getAll();
        return new ModelAndView("capacete/index", "listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var produtoNovo = new Capacete();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("capacete", produtoNovo);
        return new ModelAndView("capacete/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Capacete produto) {

        service.save(produto);

        return new ModelAndView("redirect:/capacete");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umProduto = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("capacete", umProduto);
        return new ModelAndView("capacete/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/capacete");
    }
}
