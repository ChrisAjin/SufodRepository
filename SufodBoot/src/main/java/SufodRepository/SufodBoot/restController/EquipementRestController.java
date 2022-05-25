package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Equipement;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.ItemService;

@RestController
@RequestMapping("/api/equipement")
public class EquipementRestController {
	
	@Autowired
	private ItemService itemService  ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Equipement> getAll() {
		return itemService.getAllEquipements();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Equipement getEquipementById(@PathVariable Long id) {
		return (Equipement) itemService.getEquipementById(id);
	}
	
	@GetMapping("/{bodypart}")
	@JsonView(JsonViews.Common.class)
	public List<Equipement> getByBodypart(@PathVariable String bodypart) {
		return itemService.getAllEquipementByBodypart(bodypart);
	}


}
