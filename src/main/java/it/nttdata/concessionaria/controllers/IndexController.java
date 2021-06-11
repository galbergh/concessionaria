package it.nttdata.concessionaria.controllers;

import it.nttdata.concessionaria.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

   private final ConcessionarioRepository concessionarioRepository;


    public IndexController(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("numeroregioni",concessionarioRepository.countRegion());
        return "index";
    }


}
