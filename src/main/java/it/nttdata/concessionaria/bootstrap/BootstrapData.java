package it.nttdata.concessionaria.bootstrap;

import it.nttdata.concessionaria.models.Auto;
import it.nttdata.concessionaria.models.Concessionario;
import it.nttdata.concessionaria.models.Dipendente;
import it.nttdata.concessionaria.models.Regione;
import it.nttdata.concessionaria.repositories.AutoRepository;
import it.nttdata.concessionaria.repositories.ConcessionarioRepository;
import it.nttdata.concessionaria.repositories.DipendenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ConcessionarioRepository concessionarioRepository;
    private final AutoRepository autoRepository;
    private final DipendenteRepository dipendenteRepository;

    public BootstrapData(ConcessionarioRepository concessionarioRepository, AutoRepository autoRepository, DipendenteRepository dipendenteRepository) {
        this.concessionarioRepository = concessionarioRepository;
        this.autoRepository = autoRepository;
        this.dipendenteRepository = dipendenteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Concessionario c1 = new Concessionario();
        c1.setNome("Concessionario1");
        c1.setVia("Via roma 23");
        c1.setCitta("Roma");
        c1.setRegione(Regione.LAZIO);

        Concessionario c2 = new Concessionario();
        c2.setNome("Concessionario2");
        c2.setVia("Via milano 35");
        c2.setCitta("Milano");
        c2.setRegione(Regione.LOMBARDIA);


        Auto a1 = new Auto();
        a1.setModello("458 Italia");
        a1.setPrezzo(200000.00);
        a1.setConcessionario(c1);

        Auto a2 = new Auto();
        a2.setModello("FXX");
        a2.setPrezzo(750000.00);
        a2.setConcessionario(c1);

        Auto a3 = new Auto();
        a3.setModello("La Ferrari");
        a3.setPrezzo(1000000.00);
        a3.setConcessionario(c2);

        Auto a4 = new Auto();
        a4.setModello("F12 Berlinetta");
        a4.setPrezzo(600000.00);
        a4.setConcessionario(c2);

        Dipendente d1 = new Dipendente();
        d1.setNome("Mattia");
        d1.setCognome("Binotto");
        d1.setEta(40);
        d1.setStipendio(35000.00);
        d1.setConcessionario(c1);

        Dipendente d2 = new Dipendente();
        d2.setNome("Giorgio");
        d2.setCognome("Alberghina");
        d2.setEta(24);
        d2.setStipendio(20000.00);
        d2.setConcessionario(c1);

        Dipendente d3 = new Dipendente();
        d3.setNome("Carlos");
        d3.setCognome("Saintz");
        d3.setEta(25);
        d3.setStipendio(600000.00);
        d3.setConcessionario(c2);

        Dipendente d4 = new Dipendente();
        d4.setNome("Charles");
        d4.setCognome("Lecrerc");
        d4.setEta(23);
        d4.setStipendio(700000.00);
        d4.setConcessionario(c2);

        c1.getDipendenti().add(d1);
        c1.getDipendenti().add(d2);
        c2.getDipendenti().add(d3);
        c2.getDipendenti().add(d4);

        c1.getAutomobili().add(a1);
        c1.getAutomobili().add(a2);
        c2.getAutomobili().add(a3);
        c2.getAutomobili().add(a4);

        concessionarioRepository.save(c1);
        concessionarioRepository.save(c2);
        autoRepository.save(a1);
        autoRepository.save(a2);
        autoRepository.save(a3);
        autoRepository.save(a4);
        dipendenteRepository.save(d1);
        dipendenteRepository.save(d2);
        dipendenteRepository.save(d3);
        dipendenteRepository.save(d4);










    }
}
