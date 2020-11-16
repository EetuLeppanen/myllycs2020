package myllycs.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface PelaajaRepository extends CrudRepository<Pelaaja, Long> {

	 List <Pelaaja> findByName (String name);
}