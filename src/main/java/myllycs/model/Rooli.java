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
    @GeneratedValue(strategy=GenerationType.AUTO)
        private Long rooliId;
        private String name;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "rooli")
        private List<Pelaaja> pelaajat;

        public Rooli() {}

        public Rooli(String name) {
            super();
            this.name = name;
        }

        public Long getrooliId() {
            return rooliId;
        }

        public void setrooliId(long rooliId) {
            this.rooliId = rooliId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Pelaaja> getPelaajat() {
            return pelaajat;
        }

        public void setBooks(List<Pelaaja> pelaajat) {
            this.pelaajat = pelaajat;
        }

        @Override
        public String toString() {
            return "Category [rooliId=" + rooliId + ", name=" + name + "]";
        }



}