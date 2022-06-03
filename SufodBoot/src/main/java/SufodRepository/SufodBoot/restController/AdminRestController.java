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
import SufodRepository.SufodBoot.entity.JsonViews;
import SufodRepository.SufodBoot.services.CompteServices;
@RestController
@RequestMapping("/api/compte/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {
	@Autowired
	private CompteServices compteServices ;
	
	//OK
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Admin> getAll() {
		return compteServices.getAllAdmin();
	}
	
	//OK
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin getById(@PathVariable Long id) {
		return (Admin) compteServices.getById(id);
	}
	
	//Ok !!Bien mettre un mdp lors de la creation car pas visible (pas de jsonview)
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Admin create(@RequestBody Admin admin) {
		if(compteServices.checkPseudoExist(admin.getPseudo())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		return (Admin) compteServices.create(admin);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Admin update(@RequestBody Admin admin, @PathVariable Long id) {
		admin.setId(id);
		return (Admin) compteServices.update(admin);
	}
	
	@JsonView(JsonViews.Common.class)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		compteServices.deleteById(id);
	}

	
}
