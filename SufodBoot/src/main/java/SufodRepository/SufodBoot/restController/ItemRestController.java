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
import SufodRepository.SufodBoot.entity.Item;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.ItemService;



@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "*")
public class ItemRestController {
	
	@Autowired
	private ItemService itemService ;
	
	//Ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Item> getAll() {
		return itemService.getAll();
	}
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Item getItemById(@PathVariable Long id) {
		return (Item) itemService.getById(id);
	}

	//Ok
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Item create(@RequestBody Item item) {
		return (Item) itemService.create(item);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Item update(@RequestBody Item item, @PathVariable Long id) {
		item.setId(id);
		return (Item) itemService.update(item);
	}
	

}
