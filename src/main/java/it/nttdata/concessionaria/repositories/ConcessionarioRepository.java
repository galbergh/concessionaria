package it.nttdata.concessionaria.repositories;

import it.nttdata.concessionaria.models.Concessionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConcessionarioRepository extends CrudRepository<Concessionario,Long> {

    @Query("SELECT COUNT(DISTINCT(c.regione)) from Concessionario c")

    Integer countRegion();

}
