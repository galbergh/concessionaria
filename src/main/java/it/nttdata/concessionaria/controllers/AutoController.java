package it.nttdata.concessionaria.controllers;

import it.nttdata.concessionaria.repositories.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoController {

    private final AutoRepository autoRepository;

    public AutoController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @GetMapping("/automobili")
    public String getAuto(Model model){
        model.addAttribute("automobili",autoRepository.findAll());
        return "automobili";
    }
}
