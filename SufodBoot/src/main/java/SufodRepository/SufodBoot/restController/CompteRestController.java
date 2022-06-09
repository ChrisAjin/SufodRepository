package SufodRepository.SufodBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.Compte;
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.CompteServices;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	private CompteServices compteServices;

	// Ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteServices.getAll();
	}

	// Ok
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Compte getById(@PathVariable Long id) {
		return (Compte) compteServices.getById(id);
	}
	
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Compte create(@RequestBody Compte compte) {
		if(compteServices.checkPseudoExist(compte.getPseudo())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		return compteServices.create(compte);
	}

	// OK
	@GetMapping("/personnage/{id}")
	@JsonView(JsonViews.CompteWithPersonnage.class)
	public Compte getCompte(@PathVariable Long id) {
		return compteServices.getCompteByPersonnageId(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/pseudo/{pseudo}")
	public boolean checkPseudo(@PathVariable String pseudo) {
		return compteServices.checkPseudoExist(pseudo);
	}
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Compte update(@RequestBody Compte compte, @PathVariable Long id) {
		compte.setId(id);
		return (Compte) compteServices.update(compte);
	}
	
	@JsonView(JsonViews.Common.class)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		compteServices.deleteById(id);
	}

}
