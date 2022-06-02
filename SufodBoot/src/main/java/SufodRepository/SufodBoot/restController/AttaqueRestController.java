package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.AttaqueService;


@RestController
@RequestMapping("/api/attaque")
@CrossOrigin(origins = "*")
public class AttaqueRestController {
	@Autowired
	private AttaqueService attaqueService ;
	
	//Ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Attaque> getAll() {
		return attaqueService.getAll();
	}
	
	//Ok
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Attaque getById(@PathVariable Long id) {
		return attaqueService.getById(id);
	}


	//Ok
	@GetMapping("/personnage/{id}")
	@JsonView(JsonViews.AttaquesWithPersonnage.class)
	public List<Attaque> getAttaquesPersonnage(@PathVariable Long id) {
		return attaqueService.getAttaquesByPersonnageId(id);
	}
	
	//Ok
	@GetMapping("/monstre/{id}")
	@JsonView(JsonViews.AttaquesWithMonstre.class)
	public List<Attaque> getAttaquesMonstre(@PathVariable Long id) {
		return attaqueService.getAttaquesByMonstreId(id);
	}
	
	//OK
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Attaque create(@RequestBody Attaque attaque) {
		return attaqueService.create(attaque);
	}
}
