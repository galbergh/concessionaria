package it.nttdata.concessionaria.repositories;

import it.nttdata.concessionaria.models.Concessionario;
import org.springframework.data.repository.CrudRepository;

public interface ConcessionarioRepository extends CrudRepository<Concessionario,Long> {
}
