package it.nttdata.concessionaria.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=1)
    private String modello;
    private Double prezzo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    private Concessionario concessionario;

    public Auto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }
}
