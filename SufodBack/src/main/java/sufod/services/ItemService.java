package sufod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sufod.entity.Equipement;
import sufod.entity.Ingredient;
import sufod.entity.Item;
import sufod.exception.ItemException;
import sufod.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	public List<Item> getAll() {
		return itemRepo.findAll();
	}

	public List<Equipement> getAllEquipements() {
		return itemRepo.findAllEquipements();
	}

	public List<Ingredient> getAllIngredients() {
		return itemRepo.findAllIngredients();
	}

	public Item getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> {
			throw new ItemException("id inconnu");
		});
	}
	
	public List<Equipement> getAllEquipementByBodypart(String bodypart) {
		return itemRepo.findByBodyPart(bodypart);
	}
	

	public Item create(Item item) {
		if (item.getId() != null) {
			throw new ItemException("id auto");
		}
		return itemRepo.save(item);
	}

	public Item update(Item item) {
		Item itemEnBase = getById(item.getId());
		itemEnBase.setLibelle(item.getLibelle());
		itemEnBase.setDescription(item.getDescription());
		itemEnBase.setDropChance(item.getDropChance());
		return itemRepo.save(itemEnBase);
	}

	public void delete(Item item) {
		itemRepo.delete(item);
	}

	public void deleteById(Long id) {
		Item item = getById(id);
		itemRepo.delete(item);
	}

	public void deleteEquipementById(Long id) {
		Item item = new Equipement();
		item.setId(id);
		delete(item);
	}

	public void deleteIngredientById(Long id) {
		Item item = new Ingredient();
		item.setId(id);
		delete(item);
	}
}
