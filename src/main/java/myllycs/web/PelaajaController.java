package myllycs.web;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myllycs.model.Pelaaja;
import myllycs.model.PelaajaRepository;
import myllycs.model.RooliRepository;

import org.springframework.security.access.prepost.PreAuthorize;



@Controller
public class PelaajaController {

    @Autowired
    private PelaajaRepository repository;

    @Autowired
    private RooliRepository rorepository;


    
    @RequestMapping(value="/pelaajalista")
    public String pelaajaLista(Model model) {
        model.addAttribute("pelaajat", repository.findAll());
        return "pelaajalista";
    }
    
    @RequestMapping(value="/pelaajat", method = RequestMethod.GET)
    public @ResponseBody List<Pelaaja> pelaajaListaRest() {	
        return (List<Pelaaja>) repository.findAll();
    }    
    
    @RequestMapping(value="/pelaajalista/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Pelaaja> findPelaajaRest(@PathVariable("id") Long Id) {	
    	return repository.findById(Id);
    }       

    @RequestMapping(value = "/lisaapelaaja")
    public String addPelaaja(Model model){
        model.addAttribute("pelaaja", new Pelaaja());
        model.addAttribute("roolit", rorepository.findAll());
        return "lisaapelaaja";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Pelaaja pelaaja){
        repository.save(pelaaja);
        return "redirect:pelaajalista";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deletePelaaja(@PathVariable("id") Long pelaajaId, Model model) {
        repository.deleteById(pelaajaId);
        return "redirect:../pelaajalista";
    }
    @RequestMapping(value="/modify/{id}")
    public String editPelaaja(@PathVariable("id") Long pelaajaId, Model model) {
        model.addAttribute("pelaaja", repository.findById(pelaajaId));
        model.addAttribute("roolit", rorepository.findAll());
        return "muokkaapelaajaa";
    }
    
    @RequestMapping(value= {"/", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
}