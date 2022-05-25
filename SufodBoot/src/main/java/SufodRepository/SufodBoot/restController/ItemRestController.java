package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Item;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.ItemService;



@RestController
@RequestMapping("/api/item")
public class ItemRestController {
	
	@Autowired
	private ItemService itemService ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Item> getAll() {
		return itemService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Item create(@RequestBody Item item) {
		return itemService.create(item);
	}

}
