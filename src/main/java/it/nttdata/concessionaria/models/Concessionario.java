package it.nttdata.concessionaria.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Concessionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1)
    private String nome;
    @NotNull
    @Size(min = 1)
    private String via;
    @NotNull
    @Size(min = 1)
    private String citta;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> dipendenti = new HashSet<>();

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> automobili = new HashSet<>();


    @NotNull
    private Regione regione;

    public Concessionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(Set<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public Set<Auto> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(Set<Auto> automobili) {
        this.automobili = automobili;
    }
}
