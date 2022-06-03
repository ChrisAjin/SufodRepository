package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Equipement;
import SufodRepository.SufodBoot.entity.Ingredient;
import SufodRepository.SufodBoot.entity.Joueur;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.entity.PartieCorps;
import SufodRepository.SufodBoot.services.ItemService;

@RestController
@RequestMapping("/api/equipement")
@CrossOrigin(origins = "*")
public class EquipementRestController {

	@Autowired
	private ItemService itemService;

	// Ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Equipement> getAll() {
		return itemService.getAllEquipements();
	}

	// Ok
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Equipement getEquipementById(@PathVariable Long id) {
		return (Equipement) itemService.getEquipementById(id);
	}

	// Ok
	@GetMapping("/bodypart/{bodypart}")
	@JsonView(JsonViews.Common.class)
	public List<Equipement> getByBodypart(@PathVariable PartieCorps bodypart) {
		return itemService.getAllEquipementByBodypart(bodypart);
	}

	//Ok
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Equipement create(@RequestBody Equipement equipement) {
		return (Equipement) itemService.create(equipement);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Equipement update(@RequestBody Equipement equipement, @PathVariable Long id) {
		equipement.setId(id);
		return (Equipement) itemService.update(equipement);
	}
	
	
//	@JsonView(JsonViews.Common.class)
//	@DeleteMapping("/{id}")
//	public void deleteById(@PathVariable Long id) {
//		itemService.deleteById(id);
//	}

}
