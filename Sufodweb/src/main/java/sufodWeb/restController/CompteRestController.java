package sufodWeb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sufod.entity.Compte;
import sufod.entity.JsonViews;
import sufod.services.CompteServices;



@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	@Autowired
	private CompteServices compteServices ;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteServices.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Compte create(@RequestBody Compte compte) {
		return compteServices.create(compte);
	}

}
