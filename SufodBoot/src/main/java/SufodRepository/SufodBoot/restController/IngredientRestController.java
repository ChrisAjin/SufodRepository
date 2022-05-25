package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Ingredient;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.ItemService;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController {
	
	@Autowired
	private ItemService itemService ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Ingredient> getAll() {
		return itemService.getAllIngredients();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Ingredient getById(@PathVariable Long id) {
		return (Ingredient) itemService.getById(id);
	}
	


}
