package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.Attaque;
import sufod.entity.Compte;
import sufod.services.AttaqueService;
import sufod.entity.JsonViews;

@RestController
@RequestMapping("/api/attaque")
public class AttaqueRestController {
	@Autowired
	private AttaqueService attaqueService ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Attaque> getAll() {
		return attaqueService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Attaque create(@RequestBody Attaque attaque) {
		return attaqueService.create(attaque);
	}
	
	@GetMapping("personnage/{id}")
	@JsonView(JsonViews.AttaquesWithPersonnage.class)
	public List<Attaque> getAttaques() {
		return personnageService.getAttaquesByPersonnageId();
	}
	
	@GetMapping("monstre/{id}")
	@JsonView(JsonViews.AttaquesWithMonstre.class)
	public List<Attaque> getAttaques() {
		return monstreService.getAttaquesByMonstreId();
	}
}
