package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.JsonViews;
import sufod.entity.Personnage;
import sufod.services.PersonnageService;

@RestController
@RequestMapping("/api/vivants/personnage")
public class PersonnageRestController {

	@Autowired
	private PersonnageService personnageService;

	@GetMapping("/all")
	@JsonView(JsonViews.Common.class)
	public List<Personnage> getAll() {
		return personnageService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Personnage getById(@PathVariable Long id) {
		return (Personnage) personnageService.getById(id);
	}
	
	@GetMapping("compte/{id}")
	@JsonView(JsonViews.PersonnagesWithCompte.class)
	public List<Personnage> getPersonnageByJoueurId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByJoueurId(id);
	}
	
	@GetMapping("attaque/{id}")
	@JsonView(JsonViews.PersonnagesWithAttaque.class)
	public List<Personnage> getPersonnageByAttaqueId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByAttaqueId(id);
	}
	
	@GetMapping("equipement/{id}")
	@JsonView(JsonViews.PersonnagesWithEquipement.class)
	public List<Personnage> getPersonnageByEquipementId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByEquipementId(id);
	}
	
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Personnage create(@RequestBody Personnage personnage) {
		return personnageService.create(personnage);
	}
}
