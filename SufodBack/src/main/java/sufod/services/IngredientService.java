package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sufod.entity.Ingredient;
import sufod.exception.IngredientException;
import sufod.repository.IngredientRepository;

@Service
public class IngredientService extends ItemService {

	@Autowired
	private IngredientRepository ingredientRepo;

//	public List<Ingredient> getAll() {
//		return ingredientRepo.findAll();
//	}
//
//	public Ingredient getById(Long id) {
//		return ingredientRepo.findById(id).orElseThrow(() -> {
//			throw new IngredientException("id inconnu");
//		});
//	}

	public Ingredient create(Ingredient ingredient) {
		if (ingredient.getId() != null) {
			throw new IngredientException("id auto");
		}
		return ingredientRepo.save(ingredient);
	}

	public void delete(Ingredient ingredient) {
		delete(ingredient.getId());
	}

//	public void delete(Long id) {
//		Ingredient ingredient = getById(id);
//		ingredientRepo.delete(ingredient);
//	}

}
