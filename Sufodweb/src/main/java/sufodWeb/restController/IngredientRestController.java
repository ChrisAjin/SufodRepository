package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.Ingredient;
import sufod.services.ItemService;
import sufod.entity.JsonViews;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {
	
	@Autowired
	private ItemService itemService ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Ingredient> getAll() {
		return itemService.getAllIngredient();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Ingredient getById(@PathVariable Long id) {
		return (Ingredient) itemService.getById(id);
	}
	

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return itemService.create(ingredient);
	}
}
