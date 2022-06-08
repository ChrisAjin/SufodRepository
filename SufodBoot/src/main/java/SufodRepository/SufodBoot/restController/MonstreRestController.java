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

import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.entity.Monstre;
import SufodRepository.SufodBoot.services.MonstreService;

@RestController
@RequestMapping("/api/monstre")
@CrossOrigin(origins = "*")
public class MonstreRestController {

	@Autowired
	private MonstreService monstreService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Monstre> getAll() {
		return monstreService.getAll();
	}

	// Ok
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Monstre getById(@PathVariable Long id) {
		return monstreService.getById(id);
	}

	// Ok
	@GetMapping("/attaque/{id}")
	@JsonView(JsonViews.PersonnagesWithAttaque.class)
	public List<Monstre> getMonstreByAttaqueId(@PathVariable Long id) {
		return monstreService.getAllMonstreByAttaqueId(id);
	}

	// Ok
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Monstre create(@RequestBody Monstre monstre) {
		return monstreService.create(monstre);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Monstre update(@RequestBody Monstre monstre, @PathVariable Long id) {
		monstre.setId(id);
		return (Monstre) monstreService.update(monstre);
	}

	@JsonView(JsonViews.Common.class)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		monstreService.deleteById(id);
	}
}