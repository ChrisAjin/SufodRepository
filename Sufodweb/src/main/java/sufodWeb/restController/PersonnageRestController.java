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
	
	//Ok il faudrait trier les données de sorties pour avoir les choses qui nous interesses
	@GetMapping("/compte/{id}")
	@JsonView(JsonViews.PersonnagesWithCompte.class)
	public List<Personnage> getPersonnageByCompteId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByCompteId(id);
	}
	
	
	//Ok mais le resultat sort 2 fois
	@GetMapping("/attaque/{id}")
	@JsonView(JsonViews.PersonnagesWithAttaque.class)
	public List<Personnage> getPersonnageByAttaqueId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByAttaqueId(id);
	}
	
	//A tester car aucun element dans la table item_personnage
	@GetMapping("/equipement/{id}")
	@JsonView(JsonViews.PersonnageWithEquipement.class)
	public List<Personnage> getPersonnageByEquipementId(@PathVariable Long id) {
		return personnageService.getAllPersonnageByItemId(id);
	}
	
	//Pas tester
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Personnage create(@RequestBody Personnage personnage) {
		return personnageService.create(personnage);
	}
}
