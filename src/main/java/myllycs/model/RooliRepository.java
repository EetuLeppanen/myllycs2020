package myllycs.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RooliRepository extends CrudRepository<Rooli, Long> {

    List<Rooli> findByName(String name);
}