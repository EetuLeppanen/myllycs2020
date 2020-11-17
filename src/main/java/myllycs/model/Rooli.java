package myllycs.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rooli {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long rooliId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rooli")
	private List<Pelaaja> pelaajat;

	public Rooli() {

	}

	public Rooli(long rooliId, String name) {
		super();
		this.rooliId = rooliId;
		this.name = name;
	}

	public Rooli(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getRooliId() {
		return rooliId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRooliId(long rooliId) {
		this.rooliId = rooliId;
	}

}