package it.nttdata.concessionaria.controllers;

import it.nttdata.concessionaria.models.Concessionario;
import it.nttdata.concessionaria.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ConcessionarioController {
    private final ConcessionarioRepository concessionarioRepository;

    public ConcessionarioController(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/concessionari")
    public String getAllConcessionari(Model model){
        model.addAttribute("listaconcessionari",concessionarioRepository.findAll());
        return "listaconcessionari";
    }
}
