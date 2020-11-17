package myllycs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import myllycs.model.Pelaaja;
import myllycs.model.PelaajaRepository;
import myllycs.model.Rooli;
import myllycs.model.RooliRepository;
import myllycs.model.User;
import myllycs.model.UserRepository;


@SpringBootApplication
public class PelaajaApplication {
	private static final Logger log = LoggerFactory.getLogger(PelaajaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PelaajaApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner pelaajaDemo(PelaajaRepository prepository, RooliRepository rorepository, UserRepository urepository) {
	return (args) -> {
		
		
		
		
		
		log.info("save two users");
        User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
        User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
        urepository.deleteAll();
		urepository.save(user1);
        urepository.save(user2);
        
        
		log.info("save a couple players");
		rorepository.deleteAll();
		rorepository.save(new Rooli("In-Game Leader"));
		rorepository.save(new Rooli("Rifler"));
		rorepository.save(new Rooli("AWP"));
		prepository.deleteAll();
		prepository.save(new Pelaaja("Atte Ampuja", "1999", 150000, rorepository.findByName("Rifler").get(0)));
		prepository.save(new Pelaaja("Joonas Joonaksela", "2005", 13, rorepository.findByName("AWP").get(0)));
		prepository.save(new Pelaaja("Eetu Leppänen", "1999", 1500000, rorepository.findByName("In-Game Leader").get(0)));
		
		
		log.info("fetch all players");
		for (Pelaaja pelaaja : prepository.findAll()) {
			log.info(pelaaja.toString());
		}

	};
}
}
	

