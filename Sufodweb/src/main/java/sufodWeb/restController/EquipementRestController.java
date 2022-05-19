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

import sufod.entity.Equipement;
import sufod.entity.JsonViews;
import sufod.services.ItemService;

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
	public Equipement getById(@PathVariable Long id) {
		return (Equipement) itemService.getById(id);
	}
	
	@GetMapping("/{bodypart}")
	@JsonView(JsonViews.Common.class)
	public List<Equipement> getByBodypart(@PathVariable String bodypart) {
		return itemService.getAllEquipementByBodypart(bodypart);
	}


}
