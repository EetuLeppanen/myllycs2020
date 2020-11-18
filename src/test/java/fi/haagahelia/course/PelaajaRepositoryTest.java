package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import myllycs.model.PelaajaRepository;
import myllycs.model.Pelaaja;
import myllycs.model.Rooli;

@RunWith(SpringRunner.class)	
@DataJpaTest
public class PelaajaRepositoryTest {
	@Autowired
	private PelaajaRepository repository;
	
	@Test
	public void findByNameShouldReturnPelaaja() {
		List <Pelaaja> pelaajat = repository.findByName("Atte Ampuja");
		assertThat(pelaajat).hasSize(1);
		assertThat(pelaajat.get(0).getBirthyear()).isEqualTo("1999");
		
	}
	
	@Test
	public void createNewPelaaja() {
		Pelaaja pelaaja = new Pelaaja("Esko Aho", "1960", 150000, new Rooli("AWP"));
	assertThat(pelaaja.getId()).isNotNull();
	}
	
	
	
}