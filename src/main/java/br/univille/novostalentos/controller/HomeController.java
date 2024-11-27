package br.univille.novostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.univille.novostalentos.service.CapaceteService;

@Controller
@RequestMapping({ "/home", "/" })
public class HomeController {

    @Autowired
    private CapaceteService service;

    @GetMapping("/")
    public String home(Model model) {
        long totalCapacetes = service.getTotalCapacetes();
        model.addAttribute("totalCapacetes", totalCapacetes);
        long valorTotalCapacetes = service.getValorTotalCapacetes();
        model.addAttribute("valorTotalCapacetes", valorTotalCapacetes);
        return "/home/index";
    }
}
