package it.nttdata.concessionaria.controllers;

import it.nttdata.concessionaria.models.Auto;
import it.nttdata.concessionaria.models.Concessionario;
import it.nttdata.concessionaria.repositories.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

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

    @GetMapping("/automobiliconcessionario/{nomeConcessionario}")
    public String getAutoConcessionario(Model model, @PathVariable ("nomeConcessionario") String nomeConcessionario){
        ArrayList<Auto> listaAuto = (ArrayList<Auto>) autoRepository.findAll();
        listaAuto.stream().filter(auto -> auto.getConcessionario().getNome().equals(nomeConcessionario));
        model.addAttribute("automobili",listaAuto);
        return "automobili";
    }
}
