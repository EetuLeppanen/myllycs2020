package myllycs.model;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RooliRepository extends CrudRepository<Rooli, Long> {

    List<Rooli> findByName(String name);
}