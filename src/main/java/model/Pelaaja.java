package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pelaaja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private String name;
   private String birthyear;
   private int palkka;
   @ManyToOne
   @JsonIgnore
   @JoinColumn(name="rooliId")
   private Rooli rooli;
   
   
    public Pelaaja() {
    	
    
 }
   
public Pelaaja(String name, String birthyear, int palkka, Rooli rooli) {
		super();
		
		
		
		this.name = name;
		this.birthyear = birthyear;
		this.palkka = palkka;
		this.rooli = rooli;
	}

public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}
	
	public int getPalkka() {
		return palkka;
	}
	public void setPalkka(int palkka) {
		this.palkka = palkka;
	}
	
	public Rooli getRooli() {
		return rooli;
	}
	public void setRooli(Rooli rooli) {
		this.rooli = rooli;
	}

   
   @Override
	public String toString() {
	   if (this.rooli != null)
		return "Pelaaja [id=" + id + ", name=" + name + ", birthyear=" + birthyear + ", palkka=" + palkka + ", rooli=" + this.getRooli() + "]";
		else
		return "Pelaaja [id=" + id + ", name=" + name + ", birthyear=" + birthyear + ", palkka=" + palkka +  "]";
	}
}

   
   
  