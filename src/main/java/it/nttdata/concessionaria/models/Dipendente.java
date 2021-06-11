package it.nttdata.concessionaria.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=1)
    private String nome;
    @NotNull
    @Size(min=1)
    private String cognome;
    @NotNull
    @Min(16)
    private Integer eta;
    private Double stipendio;

     @NotNull
     @ManyToOne
     @JoinColumn(name = "concessionario_id")
    private Concessionario concessionario;

    public Dipendente() {
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Double getStipendio() {
        return stipendio;
    }

    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }

    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }
}
