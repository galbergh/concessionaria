package it.nttdata.concessionaria.repositories;

import it.nttdata.concessionaria.models.Concessionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConcessionarioRepository extends CrudRepository<Concessionario,Long> {

    @Query("select count(c) from Concessionario c")
    //select  distinct count(*)
    Integer countRegion();

}
