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
@RequestMapping("/produtos")
public class CapaceteController {
    @Autowired
    private CapaceteService service;

    @GetMapping
    public ModelAndView index() {
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var produtoNovo = new Capacete();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produtoNovo);
        return new ModelAndView("produto/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Capacete produto) {

        service.save(produto);

        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umProduto = service.findById(id);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", umProduto);
        return new ModelAndView("produto/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/produtos");
    }
}
