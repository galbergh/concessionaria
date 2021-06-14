package it.nttdata.concessionaria.controllers;

import it.nttdata.concessionaria.models.Auto;
import it.nttdata.concessionaria.repositories.AutoRepository;
import it.nttdata.concessionaria.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AutoController {

    private final AutoRepository autoRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public AutoController(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/automobili")
    public String getAuto(Model model){
        model.addAttribute("automobili",autoRepository.findAll());
        return "automobili";
    }

    @GetMapping("/automobiliconcessionario/{nomeConcessionario}")
    public String getAutoConcessionario(Model model, @PathVariable ("nomeConcessionario") String nomeConcessionario){
        ArrayList<Auto> listaAuto = (ArrayList<Auto>) autoRepository.findAll();
        List<Auto> ans = listaAuto.stream().filter(c -> c.getConcessionario().getNome().equals(nomeConcessionario)).collect(Collectors.toList());
        model.addAttribute("automobili",ans);
        return "automobili";
    }

    @PostMapping("/addAuto")
    //@ResponseBody
    public String addAuto(Auto a){
        autoRepository.save(a);
        return "redirect:/automobili";
    }

    @GetMapping("/addAuto")
    public String getFormAuto(Model model){
        model.addAttribute("listaConcessionarie",concessionarioRepository.findAll());
        return "formAuto";
    }
}
