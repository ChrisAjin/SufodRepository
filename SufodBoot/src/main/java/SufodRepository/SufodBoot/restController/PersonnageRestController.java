package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.entity.Personnage;
import SufodRepository.SufodBoot.services.PersonnageService;

@RestController
@RequestMapping("/api/personnage")
public class PersonnageRestController {

	@Autowired
	private PersonnageService personnageService;

	//OK
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Personnage> getAll() {
		return personnageService.getAll();
	}
	
	//Ok
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Personnage getById(@PathVariable Long id) {
		return personnageService.getById(id);
	}
	
	//Ok
	@GetMapping("/compte/{id}")
	@JsonView(JsonViews.PersonnagesWithCompte.class)
	public List<Personnage> getPersonnageByCompteId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByCompteId(id);
	}
	
	
	//Ok
	@GetMapping("/attaque/{id}")
	@JsonView(JsonViews.PersonnagesWithAttaque.class)
	public List<Personnage> getPersonnageByAttaqueId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByAttaqueId(id);
	}
	
	//Ok
	@GetMapping("/equipement/{id}")
	@JsonView(JsonViews.PersonnageWithEquipement.class)
	public List<Personnage> getPersonnageByEquipementId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByItemId(id);
	}
	
	//Ok
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Personnage create(@RequestBody Personnage personnage) {
		return personnageService.create(personnage);
	}
}
